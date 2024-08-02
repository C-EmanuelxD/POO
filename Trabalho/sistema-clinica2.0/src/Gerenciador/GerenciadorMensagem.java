package Gerenciador;

import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import atoresPrincipais.Secretaria;
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
        
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getEmail() != null) {
                email.enviaEmail(consulta);
            }
            index++;
        }
        
    }
    
    public void enviarSMS(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
        
        int index = 0;
        while (index < consultasMensagem.size()) {
            Consulta consulta = consultasMensagem.get(index);
            Paciente paciente = consulta.getPaciente();
            if (paciente.getSms() != null) {
                sms.enviaSMS(consulta);
            }
            index++;
        }
    }
}
