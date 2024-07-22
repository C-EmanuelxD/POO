package clinica.pessoas;

import java.util.List;

public class Medico {
    private String nome;
    private String crm;
    private List<Paciente> pacientes;
    
    public Medico(String nome, String crm) {
        this.nome = nome;
        this.crm = crm;
        this.pacientes = null;
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
