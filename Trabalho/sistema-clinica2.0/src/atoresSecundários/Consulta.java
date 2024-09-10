package atoresSecundários;

import atoresPrincipais.Medico;
import clinicaTipos.TipoConsulta;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "data")
    private String data;  // Parte da chave composta

    @Column(name = "horario")
    private String horario;  // Outra parte da chave composta

    @ManyToOne
    @JoinColumn(name = "medico_crm")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_cpf")
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
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
    
    public String imprimirConsulta() {
        return ("Consulta -> Data: " + data + ", Horario: " + horario + ", Tipo Consulta: " + tipoConsulta + "\n" +
        "Medico -> " + "Nome: " + medico.getNome() + ", Crm: " + medico.getCrm() + ", Especialidade: " + medico.getEspecialidade()+ "\n" +
        "Paciente -> " + "Nome: " + paciente.getNome() + ", Cpf: " + paciente.getCpf() + ", Data de nascimento: " +
                paciente.getDataNascimento() + ", Endereço: " + paciente.getEndereco() + ", Convênio: " + paciente.getTipoPlano()+"\n\n");
    }
}
