package gerenciadorMensagem;

import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import atoresPrincipais.Secretaria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerenciadorMensagem {

    private Secretaria secretaria;
    private Email email;
    private SMS sms;

    public GerenciadorMensagem(Secretaria secretaria) {
        this.secretaria = secretaria;
        this.email = new Email();
        this.sms = new SMS();
    }
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
    EntityManager em = emf.createEntityManager();

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public List<String> enviarEmail(String dataAtual) {
        List<Consulta> consultasMensagem = em.createQuery("SELECT c FROM Consulta c WHERE c.data = :data", Consulta.class).setParameter("data", dataAtual).getResultList();
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
        List<Consulta> consultasMensagem = em.createQuery("SELECT c FROM Consulta c WHERE c.data = :data", Consulta.class).setParameter("data", dataAtual).getResultList();
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
