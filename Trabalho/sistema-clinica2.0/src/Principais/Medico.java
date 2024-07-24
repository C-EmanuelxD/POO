package Principais;

import Auxiliares.Buscas;
import DadosPessoas.DadosAdicionais;
import DadosPessoas.Prontuario;
import java.util.List;
//NAO FEITO AINDA
public class Medico {
    private String nome;
    private String crm;
    private List<Paciente> pacientes;
    private Buscas busca;
    
    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
        this.pacientes = null;
    }
    
    
    public void addDadosAdcionais(String cpf, boolean fuma, boolean bebe, boolean colesterol,
        boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias){
        
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        paciente.setDadosAdicionais(new DadosAdicionais(fuma, bebe, colesterol, diabete, doencaCardiaca, cirurgias, alergias));
        
    }
    
    public void attDadosAdicionais(String cpf,boolean fuma, boolean bebe, boolean colesterol,
        boolean diabete, boolean doencaCardiaca, String cirurgia, String alergia){
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        
        paciente.getDadosAdicionais().setFuma(fuma);
        paciente.getDadosAdicionais().setBebe(bebe);
        paciente.getDadosAdicionais().setColesterol(colesterol);
        paciente.getDadosAdicionais().setDiabete(diabete);
        paciente.getDadosAdicionais().setDoencaCardiaca(doencaCardiaca);
        paciente.getDadosAdicionais().addCirurgias(cirurgia); // NAO TEM COMO DESFAZER CIRURGIAS
        paciente.getDadosAdicionais().addAlergias(alergia); // NAO TEM COMO CURAR ALERGIAS
        
    }
    
    public void removeDadosAdicionais(String cpf){
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        
        paciente.setDadosAdicionais(null);
        
    }
    
    
    public void addProntuario(String cpf, String sintomas, String diagnostico, String preescricaoTratamento, String dataAdd){
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        
        paciente.addProntuarios(new Prontuario(sintomas, diagnostico, preescricaoTratamento, dataAdd));
        
    }
    
    public void removeProntuario(String cpf, String data){
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        int index;
        index = paciente.getProntuarios().indexOf(busca.buscaProntuario(paciente.getProntuarios(), data));
        paciente.getProntuarios().remove(index);
        
    }
    
    public void attProntuario(String cpf, String data, String dataAlterar, String diagnostico, String Preescricao, String Sintoma){
        Paciente paciente = busca.buscaPaciente(pacientes, cpf);
        int index;
        index = paciente.getProntuarios().indexOf(busca.buscaProntuario(paciente.getProntuarios(), data));
        paciente.getProntuarios().get(index).setData(dataAlterar);
        paciente.getProntuarios().get(index).setDiagnostico(diagnostico);
        paciente.getProntuarios().get(index).setPrescricao(Preescricao);
        paciente.getProntuarios().get(index).setSintomas(Sintoma);
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

    public List<Paciente> getPaciente() {
        return pacientes;
    }

    public void setPaciente(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

}
