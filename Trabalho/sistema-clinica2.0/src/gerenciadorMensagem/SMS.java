package gerenciadorMensagem;

import atoresSecundários.Consulta;

public class SMS {
    
     public String enviaSMS(Consulta consulta) {
        return "Olá, " + consulta.getPaciente().getNome() + ". Deseja confirmar consulta para dia " + consulta.getData() + " no\nhorário " + consulta.getHorario() + " com o médico " + consulta.getMedico().getNome() + "?";
     }  
}