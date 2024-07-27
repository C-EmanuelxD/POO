package Relatorios;

public class Atestado extends Relatorio {
    private String dataInicio;
    private String dataFim;
    private String justificativa;
    
    public Atestado(String dataInicio, String dataFim, String justificativa){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.justificativa = justificativa;
    }
   
    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }
    
    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void imprimir(String paciente, String medico){
        System.out.println("Atestado para: "+ paciente + "valido de" + dataInicio +", ate " + dataFim);
        System.out.println("Pelo motivo de:" + justificativa + ".");
        System.out.println("Assinado por" + medico);
        
    }
}