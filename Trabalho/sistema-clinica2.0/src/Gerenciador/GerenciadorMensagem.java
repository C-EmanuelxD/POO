package Gerenciador;

import Principais.Consulta;
import Principais.Paciente;
import Principais.Secretaria;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorMensagem {
    private Secretaria secretaria;
    private Email email;
    private SMS sms;
    
    public GerenciadorMensagem(Secretaria secretaria) {
        this.secretaria = secretaria;
        this.email = new Email();
        this.sms = new SMS();
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    
    public void enviarEmail(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
        List<Consulta> consultasParaRemover = new ArrayList<>();
        
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getEmail() != null) {
                email.enviaEmail(consulta);
                consultasParaRemover.add(consulta);
            } else {
                index++;
            }
        }
        
        for (Consulta consulta : consultasParaRemover) {
            secretaria.removeConsulta(consulta.getMedico().getCrm(), consulta.getData(), consulta.getHorario());
        }
    }
    
    public void enviarSMS(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
        List<Consulta> consultasParaRemover = new ArrayList<>();
        
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getSms() != null) {
                sms.enviaSMS(consulta);
                consultasParaRemover.add(consulta);
            } else {
                index++;
            }
        }
        
        for (Consulta consulta : consultasParaRemover) {
            secretaria.removeConsulta(consulta.getMedico().getCrm(), consulta.getData(), consulta.getHorario());
        }
    }
}
