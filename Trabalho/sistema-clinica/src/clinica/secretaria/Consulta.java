package clinica.secretaria;

import clinica.tipos.TipoConsulta;
import clinica.pessoas.Medico;
import clinica.pessoas.Paciente;

public class Consulta {
    private String data;
    private String horario;
    private Medico medico;
    private Paciente paciente;
    private TipoConsulta tipoConsulta;

    public Consulta(String data, String horario, Medico medico, Paciente paciente, TipoConsulta tipoConsulta) {
        this.data = data;
        this.horario = horario;
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsulta = tipoConsulta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }
    
}
