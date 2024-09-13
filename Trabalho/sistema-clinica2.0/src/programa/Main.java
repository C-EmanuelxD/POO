//package programa;
//
//import Interface.MenuEntrar;
//import atoresPrincipais.Clinica;
//import atoresPrincipais.Secretaria;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Main {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");
//
//        // Criação do EntityManager para gerenciar as transações
//        EntityManager em = emf.createEntityManager();
//        Clinica clinica = new Clinica("Saude & Cia", new Secretaria("Vanessa"));
//        Secretaria sec = clinica.getSecretaria();
//        em.getTransaction().begin();
//        em.persist(sec);
//        new MenuEntrar(emf, clinica).setvisible(true);
//        em.getTransaction().commit();
//        em.close();
//    }
//}
