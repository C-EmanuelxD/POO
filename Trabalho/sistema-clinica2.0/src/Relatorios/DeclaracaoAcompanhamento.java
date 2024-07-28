package Relatorios;

import Principais.Paciente;

public class DeclaracaoAcompanhamento extends Relatorio {
    private String justificativa;
    private String acompanhante;
    
    public DeclaracaoAcompanhamento(String justificativa, String acompanhante, String data){
        this.justificativa = justificativa;
        this.acompanhante = acompanhante;
        this.data = data;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    @Override
    public void imprimir(String pacienteNome, String medicoNome){
        System.out.println("Declaro que " + acompanhante + "esteve no dia " + data+ "acompanhando " + paciente + "no atendimento");
        System.out.println("Assinado por" + medico + ".");
 
    }
}
