/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOS;

import atoresPrincipais.Medico;
import atoresSecundários.Paciente;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author fabri
 */
public class MedicoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsultaPU");
    // verifica nao sei se ta certo
    //  imprimir o nome de todos os pacientes de um medico
    public void imprimirNomePacientes(String crm) {
        EntityManager em = emf.createEntityManager();
        // Busca o medico pelo CRM
        Medico medico = em.find(Medico.class, crm);
        if (medico != null) {
            // Busca todas as consultas do médico
            String query = "SELECT c.paciente_id FROM Consulta c WHERE c.medico_crm = :crm"; TypedQuery<Integer> tq = em.createQuery(query, Integer.class); tq.setParameter("crm", crm); 
            List<Integer> pacienteIds = tq.getResultList();
            // Remove duplicatas
            Set<Integer> uniquePacienteIds = new HashSet<>(pacienteIds);
            // Busca pacientes
            for (Integer pacienteId : uniquePacienteIds) {
                Paciente paciente = em.find(Paciente.class, pacienteId);
                if (paciente != null) {
                    System.out.println(paciente.getNome());
                }
            }
        } else {
            System.out.println("Médico não encontrado.");
        }

        em.close();
    }
}
