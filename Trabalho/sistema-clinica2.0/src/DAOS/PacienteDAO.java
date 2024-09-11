package DAOS;

import atoresSecundários.Paciente;
import clinicaTipos.TipoConvenio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PacienteDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

    public void cadastrar(Paciente paciente) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(paciente);
        em.getTransaction().commit();
        em.close();
    }

    public void atualizar(String cpf, String nome, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            em.getTransaction().begin();
            paciente.setNome(nome);
            paciente.setEndereco(endereco);
            paciente.setEmail(email);
            paciente.setSms(sms);
            paciente.setTipoConvenio(tipoConvenio);
            em.merge(paciente);
            em.getTransaction().commit();
            em.close();
        }
    }

    public void remover(String cpf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            em.remove(paciente);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Paciente buscaCPF(String cpf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        em.close();
        return paciente;
    }

//        public List<Paciente> buscaTodos(){
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        List<Paciente> pacientes = em.createQuery("FROM Paciente", Paciente.class).getResultList();
//        em.close();
//        return pacientes;
//    }

//   }
}
