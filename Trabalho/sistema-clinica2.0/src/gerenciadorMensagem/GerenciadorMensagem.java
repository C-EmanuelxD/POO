package gerenciadorMensagem;

import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import atoresPrincipais.Secretaria;
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
    
    public List<String> enviarEmail(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
        List<String> emails = new ArrayList<>();
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getEmail() != null) {
                emails.add(email.enviaEmail(consulta));
            }
            index++;
        }
        return emails;
    }
    
    public List<String> enviarSMS(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
        List<String> SMSs = new ArrayList<>();
        
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getSms() != null) {
                SMSs.add(sms.enviaSMS(consulta));
            }
            index++;
        }
        return SMSs;
    }
}