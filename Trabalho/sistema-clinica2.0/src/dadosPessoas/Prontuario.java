package dadosPessoas;
//NAO FEITO AINDA
public class Prontuario {
    private String sintomas;
    private String diagnostico;
    private String prescricao;
    private String data;

    public Prontuario(String sintomas, String diagnostico, String prescricao, String data) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        this.data = data; //CHAVE PRIMARIA PARA BUSCAS DE PRONTUARIO
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
