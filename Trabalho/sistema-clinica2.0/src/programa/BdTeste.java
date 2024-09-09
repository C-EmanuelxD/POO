package programa;

import atoresSecundários.Paciente;
import clinicaTipos.TipoConvenio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BdTeste {
    public static void main(String[] args) {
        System.out.println("oi");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");
        
        // Criação do EntityManager para gerenciar as transações
        EntityManager em = emf.createEntityManager();
        
        // Início da transação
        em.getTransaction().begin();

        // Exemplo de criação de um novo paciente (dados fictícios)
        Paciente paciente = new Paciente("12345678901", "João Silva", "1990-01-01", 
                "Rua Exemplo, 123", "joao.silva@email.com", "987654321", TipoConvenio.PLANO);

        // Persistindo o objeto paciente no banco de dados
        em.persist(paciente);

        // Commit da transação
        em.getTransaction().commit();
    }
}
