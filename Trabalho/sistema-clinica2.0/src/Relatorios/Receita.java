package Relatorios;

import Principais.Medico;
import Principais.Paciente;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Receita extends Relatorio {
    private Map<String, String> remedios;
    private String infoExtra;
    
    public Receita(Map<String, String> remedios, String infoExtra, String data){
        this.remedios = remedios;
        this.infoExtra = infoExtra;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getMedico(){
        return medico;
    }
        
    public void setMedico(Medico medico){
        this.medico = medico;
    }
    

    public void imprimir(String paciente, String medico){
        for (String key : remedios.keySet()){
            System.out.println(key + "=" + remedios.get(key));
        }
        System.out.println(infoExtra);
        System.out.println(medico + data);
        
    }
}
