package Principais;

import Gerenciador.GerenciadorMensagem;
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
            //System.out.println("Medico cadastrado com sucesso");
            return;
        }
        System.out.println("Campo crm vazio");
    }
    
}
