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

public class Medico {
    private String nome;
    private String crm;
    private String especialidade;
    private List<Consulta> consultas;
    
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
    
    public void pacienteMes(String mes){
        int numPacientes = 0;
        
        for(int i = 0; i < consultas.size(); i++){
            Consulta consulta = consultas.get(i);
            String data = consulta.getData();
            String[] parte = data.split("/");
            if (mes.equals(parte[1])){
                consulta.getPaciente().imprimirPaciente();
                numPacientes++;
            }
        }
        System.out.println("\tNúmero de pacientes atendidos no mês: " + numPacientes);
    }
    public void geraAtestado(String dataInicio, String dataFim, String justificativa, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        System.out.println("Atestado para: "+ paciente.getNome()+ "\nvalido de " + dataInicio +", ate " + dataFim);
        System.out.println("Pelo motivo de: " + justificativa + ".");
        System.out.println("Assinado por: " + nome+"\n");        
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
    
    public void geraDeclaracaoAcompanhamento(String justificativa, String acompanhante, String data, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        System.out.println("Declaro que " + acompanhante + " esteve no dia " + data+ " acompanhando " + paciente.getNome() + " no atendimento");
        System.out.println("Assinado por " + nome + ".");
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
    
    // imprime todos os pacientes do medico, sem duplicacao.
    public void imprimirPacientes() {
        Set<Paciente> pacientesImpressos = new HashSet<>();

        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            if (!pacientesImpressos.contains(paciente)) {
                pacientesImpressos.add(paciente);
                System.out.println("\tNome: " + paciente.getNome() +
                                   ", Cpf: " + paciente.getCpf() +
                                   ", Data de nascimento: " + paciente.getDataNascimento()

                );
            }
        }
    }
    
}
