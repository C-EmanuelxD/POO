package atoresPrincipais;

import atoresPrincipais.Medico;
import atoresPrincipais.Secretaria;
import gerenciadorMensagem.GerenciadorMensagem;
import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
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
    
    public void imprimirMedicos() {
        for(Medico obj : medicos) {
            System.out.print("Doutor -> ");
            obj.imprimirMedico();
            System.out.println();
        }
    }
    
    public void imprimirMedicosPacientes() {
        for(Medico obj : medicos) {
            System.out.print("Doutor -> ");
            obj.imprimirMedico();
            
            System.out.println("Pacientes:");
            obj.imprimirPacientes();
            
            System.out.println();
        }
    }
    
    public void imprimirSecretariaPacientes() {
        for(Paciente obj : secretaria.getPacientes()) {
            obj.imprimirPaciente();
        }
    }
    
    public void imprimirSecretariaConsultas() {
        for(Consulta obj : secretaria.getConsultas()) {
            obj.imprimirConsulta();
            System.out.println();
        }
    }
}
