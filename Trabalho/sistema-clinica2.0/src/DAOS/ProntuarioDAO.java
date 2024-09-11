package DAOS;

import atoresSecundários.Paciente;
import dadosPessoas.Prontuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fabri
 */
public class ProntuarioDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

    public void cadastraProntuario(String cpf, String sintomas, String diagnostico, String preescricaoTratamento, String dataAdd) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            Prontuario prontuario = new Prontuario(sintomas, diagnostico, preescricaoTratamento, dataAdd);
            paciente.getProntuarios().add(prontuario);
            em.merge(paciente);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void atualizaProntuario(String cpf, String data, String diagnostico, String prescricao, String sintomas) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            List<Prontuario> prontuarios = paciente.getProntuarios();
            for (Prontuario prontuario : prontuarios) {
                if (prontuario.getData().equals(data)) {  // Identifica o prontuário pela data
                    prontuario.setDiagnostico(diagnostico);
                    prontuario.setPrescricao(prescricao);
                    prontuario.setSintomas(sintomas);
                    break;
                }
            }
            em.merge(paciente);  // Atualiza o paciente com o prontuário modificado
        }
        em.getTransaction().commit();
        em.close();
    }

    public void removeProntuario(String cpf, String data) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            List<Prontuario> prontuarios = paciente.getProntuarios();
            Prontuario prontuarioARemover = null;
            for (Prontuario prontuario : prontuarios) {
                if (prontuario.getData().equals(data)) {
                    prontuarioARemover = prontuario;
                    break;
                }
            }
            if (prontuarioARemover != null) {
                prontuarios.remove(prontuarioARemover);
                em.remove(em.contains(prontuarioARemover) ? prontuarioARemover : em.merge(prontuarioARemover));
            }
            em.merge(paciente);  // Atualiza o paciente sem o prontuário
        }
        em.getTransaction().commit();
        em.close();
    }

}
