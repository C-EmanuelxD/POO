package programa;

import atoresPrincipais.Medico;
import atoresSecundários.Paciente;
import dadosPessoas.DadosAdicionais;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BdTeste {
    public static void main(String[] args) {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

        // Criação do EntityManager para gerenciar as transações
        EntityManager em = emf.createEntityManager();

        // Início da transação
        em.getTransaction().begin();

        // Criar e configurar a entidade DadosAdicionais
        DadosAdicionais dadosAdicionais = new DadosAdicionais();
        // Configurar dadosAdicionais...

        em.persist(dadosAdicionais);

        Paciente paciente = new Paciente();
        paciente.setDadosAdicionais(dadosAdicionais);
        paciente.setCpf("123");
        Medico m = new Medico("Roberto", "153", "geral");

        em.persist(paciente);

        // Commit da transação
        em.getTransaction().commit();
    }
}
