package Principais;

import Auxiliares.Buscas;
import DadosPessoas.DadosAdicionais;
import DadosPessoas.Prontuario;
import Relatorios.Atestado;
import Relatorios.Receita;
import Relatorios.DeclaracaoAcompanhamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//NAO FEITO AINDA
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
        paciente.getDadosAdicionais().cadastraCirurgia(cirurgia); // NAO TEM COMO DESFAZER CIRURGIAS
        paciente.getDadosAdicionais().cadastraAlergia(alergia); // NAO TEM COMO CURAR ALERGIAS
        
    }
    
    public void removeDadosAdicionais(String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        paciente.setDadosAdicionais(null);
        
    }
    
    public void cadastraProntuario(String cpf, String sintomas, String diagnostico, String preescricaoTratamento, String dataAdd){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        paciente.setProntuarios(new Prontuario(sintomas, diagnostico, preescricaoTratamento, dataAdd));
        
    }
    
    public void atualizaProntuario(String cpf, String data, String dataAlterar, String diagnostico, String Preescricao, String Sintoma){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        int index = paciente.getProntuarios().indexOf(Buscas.buscaProntuario(paciente.getProntuarios(), data));
        paciente.getProntuarios().get(index).setData(dataAlterar);
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
        for(int i = 0; i < consultas.size(); i++){
            Consulta consulta = consultas.get(i);
            String data = consulta.getData();
            String[] parte = data.split("/");
            if (mes == parte[1]){
                System.out.print(consulta.getPaciente().getNome());
            }
        }
    }
    
    public void geraAtestado(String dataInicio, String dataFim, String justificativa, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        Atestado atestado = new Atestado(dataInicio, dataFim, justificativa);
        atestado.imprimir(paciente.getNome(), nome);    
    }
    
    public void geraReceita(Map remedios, String infoExtra, String data, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);
        
        Receita receita = new Receita(remedios, infoExtra, data);
        receita.imprimir(paciente.getNome(), nome);
    }
    
    public void geraDeclaracaoAcompanhamento(String justificativa, String acompanhante, String data, String cpf){
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        DeclaracaoAcompanhamento acompanhante1 = new DeclaracaoAcompanhamento(justificativa, acompanhante, data);
        acompanhante1.imprimir(paciente.getNome(), nome);
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
    
    public void imprimirPacientes() {
        for(Consulta x : consultas) {
            System.out.println("\tNome: " + x.getPaciente().getNome() + ", Cpf: " + x.getPaciente().getCpf()+ ", Data de nascimento: " + x.getPaciente().getDataNascimento() +
                    ", Endereço: " + x.getPaciente().getEndereco() + ", Plano: " + x.getPaciente().getTipoPlano());
        }
    }
}
