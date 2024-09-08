package atoresPrincipais;

import atoresPrincipais.Medico;
import atoresPrincipais.Secretaria;
import gerenciadorMensagem.GerenciadorMensagem;
import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import classesAuxiliares.Buscas;
import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private String nome;
    private Secretaria secretaria;
    private GerenciadorMensagem gerenciador;
    private List<Medico> medicos;

    public Clinica(String nome, Secretaria secretaria) {
        this.nome = nome;
        this.secretaria = secretaria;
        this.gerenciador = new GerenciadorMensagem(secretaria);
        this.medicos = new ArrayList<>();
    }

    public GerenciadorMensagem getGerenciador() {
        return gerenciador;
    }

    public void setGerenciador(GerenciadorMensagem gerenciador) {
        this.gerenciador = gerenciador;
    }
    
    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medico) {
        this.medicos.add(medico);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void cadastraMedico(String crm, String nome, String especialidade) {
        if (crm != null) { 
            this.setMedicos(new Medico(nome, crm, especialidade));
            System.out.println("Medico cadastrado com sucesso");
            return;
        }
        System.out.println("Campo crm vazio");
    }
    
   public boolean verificaCRM(String crm){
        for(char c : crm.toCharArray()){
            if(Character.isLetter(c)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
    
    public List<String> imprimirMedicos() {
        List<String> meds = new ArrayList<>();
        for(Medico obj : medicos) {
            meds.add(obj.toString());
        }
        return meds;
    }
    
    public void imprimirMedicosPacientes() {
        for(Medico obj : medicos) {
            System.out.print("Doutor -> ");
            obj.imprimirMedico();
            
            System.out.println("Pacientes:");
            //obj.imprimirPacientes();
            
            System.out.println();
        }
    }
    
    public String imprimirSecretariaPacientes() {
        String Pacs = "";
        for(Paciente obj : secretaria.getPacientes()) {
            Pacs = Pacs+obj.imprimirPaciente();
        }
        return Pacs;
    }
    
    public String imprimirSecretariaConsultas() {
        String cons = "";
        for(Consulta obj : secretaria.getConsultas()) {
            cons = cons+obj.imprimirConsulta();
        }
        return cons;
    }
    
    public boolean testaPaciente(String cpf){
        Paciente paciente = Buscas.buscaPaciente(secretaria.getPacientes(), cpf);
        if(paciente != null){
            return true;
        }else{
            return false;
        }
    }
}
