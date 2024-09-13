package programa;

import classesAuxiliares.Buscas;
import dadosPessoas.Prontuario;
import atoresPrincipais.Clinica;
import atoresPrincipais.Medico;
import atoresSecundários.Paciente;
import atoresPrincipais.Secretaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// JA FORAM DEIADOS ALGUNS TESTES DE CADASTRO, OS TESTES PODEM SER REMOVIDOS E VÃO DA LINHA 25 ATÉ A LINHA 49
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

        // Criação do EntityManager para gerenciar as transações
        EntityManager em = emf.createEntityManager();
        Clinica clinica = new Clinica("Saude & Cia", new Secretaria("Vanessa"));
        Secretaria sec = clinica.getSecretaria();
        em.getTransaction().begin();
        em.persist(sec);
        //new MenuEntrar(emf, clinica, sec).setvisible(true);
        em.getTransaction().commit();
        em.close();
    }
}
