package Gerenciador;

import Principais.Consulta;


public class SMS {
     public void enviaSMS(Consulta consulta) {
        System.out.println("Olá, " + consulta.getPaciente().getNome() + "Deseja confirmar consulta para dia " + consulta.getData() + "no horário " + consulta.getHorario() + "com o médico " + consulta.getMedico().getNome() + "?");
     }  
}
