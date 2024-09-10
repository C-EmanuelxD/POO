package atoresPrincipais;

import classesAuxiliares.Buscas;
import dadosPessoas.DadosAdicionais;
import dadosPessoas.Prontuario;
import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @Column(name = "crm", nullable = false, unique = true)
    private String crm;  // CRM será a chave primária

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;  // Relacionamento One-to-Many com Consulta
    
    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }
    
    public void cadastraDadosAdicionais(String cpf, boolean fuma, boolean bebe, boolean colesterol,
        boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias){
        
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        paciente.setDadosAdicionais(new DadosAdicionais(fuma, bebe, colesterol, diabete, doencaCardiaca, cirurgias, alergias));
        
    }
    
    public void atualizaDadosAdicionais(String cpf,boolean fuma, boolean bebe, boolean colesterol,
        boolean diabete, boolean doencaCardiaca, String cirurgia, String alergia){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        paciente.getDadosAdicionais().setFuma(fuma);
        paciente.getDadosAdicionais().setBebe(bebe);
        paciente.getDadosAdicionais().setColesterol(colesterol);
        paciente.getDadosAdicionais().setDiabete(diabete);
        paciente.getDadosAdicionais().setDoencaCardiaca(doencaCardiaca);
        if (!"".equals(cirurgia)) {
            paciente.getDadosAdicionais().cadastraCirurgia(cirurgia); // NAO TEM COMO DESFAZER CIRURGIAS
        }
        
        if (!"".equals(alergia)) {
            paciente.getDadosAdicionais().cadastraAlergia(alergia); // NAO TEM COMO CURAR ALERGIAS
        }
    }
    
    public void removeDadosAdicionais(String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        paciente.setDadosAdicionais(null);
        
    }
    
    public void cadastraProntuario(String cpf, String sintomas, String diagnostico, String preescricaoTratamento, String dataAdd){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        paciente.setProntuarios(new Prontuario(sintomas, diagnostico, preescricaoTratamento, dataAdd));
        
    }
    
    public void atualizaProntuario(String cpf, String data, String diagnostico, String Preescricao, String Sintoma){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        int index = paciente.getProntuarios().indexOf(Buscas.buscaProntuario(paciente.getProntuarios(), data)); // data não pode ser atualizada
        paciente.getProntuarios().get(index).setDiagnostico(diagnostico);
        paciente.getProntuarios().get(index).setPrescricao(Preescricao);
        paciente.getProntuarios().get(index).setSintomas(Sintoma);
    }
    
    public void removeProntuario(String cpf, String data){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        int index = paciente.getProntuarios().indexOf(Buscas.buscaProntuario(paciente.getProntuarios(), data));
        paciente.getProntuarios().remove(index);
        
    }
    
    public String pacienteMes(String mes){
        int numPacientes = 0;
        String pacs = "";
        for(int i = 0; i < consultas.size(); i++){
            Consulta consulta = consultas.get(i);
            String data = consulta.getData();
            String[] parte = data.split("/");
            
            if (mes.equals(parte[1])){
                pacs = pacs+consulta.getPaciente().imprimirPaciente();
                numPacientes++;
            }
        }
        return pacs;
    }
    public String geraAtestado(String dataInicio, String dataFim, String justificativa, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        return "Atestado para: "+ paciente.getNome()+ "\nvalido de " + dataInicio +", ate " + dataFim + "\n" +
                           "Pelo motivo de: " + justificativa + "." + "\n" + 
                           "Assinado por: " + nome+"\n";  
    }
    
    public void geraReceita(Map<String, String> remedios, String infoExtra, String data, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        for (String key : remedios.keySet()){
            System.out.println(key + ": " + remedios.get(key));
        }
        System.out.println(infoExtra + ".");
        System.out.println("Para o paciente: " + paciente.getNome() + ".");
        System.out.println("Medico: "+ nome + " " + data + ".");       
    }
    
    public String geraDeclaracaoAcompanhamento(String justificativa, String acompanhante, String data, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        return "Declaro que " + acompanhante + " esteve no dia " + data+ " acompanhando " + paciente.getNome() + " no atendimento" + "\n" +
        "Assinado por " + nome + ".";
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsulta() {
        return consultas;
    }

    public void setConsulta(Consulta consulta) {
         this.consultas.add(consulta);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void imprimirMedico() {
         System.out.println("Nome: " + nome + ", Crm: " + crm + ", Especialidade: " + especialidade);
    }
    
    @Override
    public String toString(){
        return "Doutor -> Nome: " + nome + ", Crm: " + crm + ", Especialidade: " + especialidade;
    }
    
    // imprime todos os pacientes do medico, sem duplicacao.
    public List<String> imprimirNomePacientes() {
        Set<Paciente> pacientesImpressos = new HashSet<>();
        List<String> pacs = new ArrayList<>();
        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            if (!pacientesImpressos.contains(paciente)) {
                pacientesImpressos.add(paciente);
                pacs.add(paciente.getCpf());
            }
        }
        return pacs;
    }
    
    public String imprimirPacientes() {
        Set<Paciente> pacientesImpressos = new HashSet<>();
        String PACS = "";
        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            if (!pacientesImpressos.contains(paciente)) {
                pacientesImpressos.add(paciente);
                PACS = PACS+("Nome: " + paciente.getNome() +
                                   ", Cpf: " + paciente.getCpf() +
                                   ", Data de nascimento: " + paciente.getDataNascimento() + "\n"

                );
            }
        }
        return PACS;
    }
    
}
