package dadosPessoas;

import atoresSecundários.Paciente;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="prontuario")
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "sintomas", length = 500)
    private String sintomas;

    @Column(name = "diagnostico", length = 500)
    private String diagnostico;

    @Column(name = "prescricao", length = 500)
    private String prescricao;

    @Column(name = "data", nullable = false)
    private String data;  // Consider using a Date type if appropriate

    @ManyToOne
    @JoinColumn(name = "paciente_cpf", nullable = false)  // Foreign key to Paciente
    private Paciente paciente;

    public Prontuario(String sintomas, String diagnostico, String prescricao, String data, Paciente paciente) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.data = data; //CHAVE PRIMARIA PARA BUSCAS DE PRONTUARIO
        this.paciente = paciente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }
    
    public String imprimirProntuario() {
        return ("Data: " + data + "\n" +
                "Sintomas: " + sintomas + "\n" +
                "Diagnostico: " + diagnostico + "\n" +
                "Prescrição: " + prescricao + "\n\n");
    } 
}
