package clinica.pessoas.relatorios;

import clinica.pessoas.Paciente;
import java.util.List;

public class PacientesAtendidos {
    private String data;
    private List<Paciente> pacientes;
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Paciente> getPaciente() {
        return pacientes;
    }

    public void setPaciente(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    
    public void pacientesAtendidosMes(Paciente paciente) {
        System.out.println(paciente);
    }
    
}
