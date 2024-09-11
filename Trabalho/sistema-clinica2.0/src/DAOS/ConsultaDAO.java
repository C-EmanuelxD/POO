package DAOS;

import atoresSecundários.Consulta;
import clinicaTipos.TipoConsulta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultaPU");

    public void cadastrarConsulta(Consulta consulta) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(consulta);
        em.getTransaction().commit();
        em.close();
    }

    public void removeConsulta(String crm, String data, String horario) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // Busca a consulta pelo CRM, data e horário
        Consulta consulta = em.createQuery("SELECT c FROM Consulta c WHERE c.medico.crm = :crm AND c.data = :data AND c.horario = :horario", Consulta.class).setParameter("crm", crm).setParameter("data", data).setParameter("horario", horario).getSingleResult();

        if (consulta != null) {
            em.remove(consulta);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void atualizarConsulta(String crm, String data, String horario, String dataNova, String horarioNovo, TipoConsulta tipoConsulta) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Busca a consulta pelo CRM, data e horário
        Consulta consulta = em.createQuery("SELECT c FROM Consulta c WHERE c.medico.crm = :crm AND c.data = :data AND c.horario = :horario", Consulta.class).setParameter("crm", crm).setParameter("data", data).setParameter("horario", horario).getSingleResult();

        if (consulta != null) {
            consulta.setData(dataNova);  // Atualiza a data
            consulta.setHorario(horarioNovo);  // Atualiza o horario
            consulta.setTipoConsulta(tipoConsulta);  // Atualiza o tipo de consulta
            em.merge(consulta);  // Faz o merge da consulta com os novos dados
        }
        em.getTransaction().commit();
        em.close();
    }

}
