package programa;

import atoresPrincipais.Clinica;
import atoresPrincipais.Secretaria;
import atoresPrincipais.Medico;
import clinicaTipos.TipoConsulta;
import clinicaTipos.TipoConvenio;
import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BdTeste {

    public static void main(String[] args) {
        System.out.println("oi");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

        // Criação do EntityManager para gerenciar as transações
        EntityManager em = emf.createEntityManager();
        Clinica clinica = new Clinica("Saude & Cia", new Secretaria("Vanessa"));
        Secretaria sec = clinica.getSecretaria();
        em.getTransaction().begin();

        em.persist(sec);
        clinica.cadastraMedico("Fabio", "11111", "Oftalmologista", emf);

        Medico med = em.find(Medico.class, "11111");
        System.out.println(med.getNome());

        sec.cadastraPaciente("231", "Antonio", "02/07/2001", "Mauricio Fé, 357", null, "9999-4444", TipoConvenio.PLANO, emf);
        // sec.removePaciente("231", emf);
        sec.atualizaPaciente("231", "zé", "Alecrim Dourado, 220", "jose@gmail.com", "8842-3233", TipoConvenio.PLANO, emf);        // Início da transação
        // em.getTransaction().begin();
        sec.cadastraPaciente("2313", "Antonio", "02/07/2001", "Mauricio Fé, 357", null, "9999-4444", TipoConvenio.PLANO, emf);

        sec.removePaciente("jg", emf);
        med.cadastraProntuario("231", "muito diabates", "dormir", "dorme", "02/07/2001", emf);
        med.cadastraDadosAdicionais("231", false, false, false, true, true, Arrays.asList("Apendicite", "Pedra no rim"), Arrays.asList((String) null), emf);
        sec.cadastraConsulta("02/03/2024", "09:30", "11111", "231", TipoConsulta.NORMAL, emf);
        //med.cadastraDadosAdicionais("231", false, false, false, true, true, Arrays.asList("Apendicite", "Pedra no rim"), null, emf);
        // Exemplo de criação de um novo paciente (dados fictícios)

        // Paciente paciente = new Paciente("12345678901", "João Silva", "1990-01-01", 
        //       "Rua Exemplo, 123", "joao.silva@email.com", "987654321", TipoConvenio.PLANO);
        // Persistindo o objeto paciente no banco de dados
        //em.persist(paciente);
        // Commit da transação
        //em.getTransaction().commit();
        em.getTransaction().commit();
        em.close();
    }
}
