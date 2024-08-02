package Gerenciador;

import atoresSecundários.Consulta;

public class Email {
        
    public void enviaEmail(Consulta consulta) {
        System.out.println("\tOlá, " + consulta.getPaciente().getNome() + ". Deseja confirmar consulta para dia " + consulta.getData() + " no horário " + consulta.getHorario() + " com o médico " + consulta.getMedico().getNome() + "?");
    }
}
