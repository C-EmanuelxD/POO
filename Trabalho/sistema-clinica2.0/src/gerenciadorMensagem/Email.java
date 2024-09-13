package gerenciadorMensagem;

import atoresSecundários.Consulta;

public class Email {

    public String enviaEmail(Consulta consulta) {
        return "Olá, " + consulta.getPaciente().getNome() + ". Deseja confirmar consulta para dia " + consulta.getData() + " no\nhorário " + consulta.getHorario() + " com o médico " + consulta.getMedico().getNome() + "?";
    }
}
