package atoresPrincipais;

import atoresPrincipais.Medico;
import atoresPrincipais.Secretaria;
import gerenciadorMensagem.GerenciadorMensagem;
import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import classesAuxiliares.Buscas;
import java.util.ArrayList;
import java.util.List;

public class Clinica {

    private String nome;
    private Secretaria secretaria;
    private GerenciadorMensagem gerenciador;
    private List<Medico> medicos;

    public Clinica(String nome, Secretaria secretaria) {
        this.nome = nome;
        this.secretaria = secretaria;
        this.gerenciador = new GerenciadorMensagem(secretaria);
        this.medicos = new ArrayList<>();
    }

    public GerenciadorMensagem getGerenciador() {
        return gerenciador;
    }

    public void setGerenciador(GerenciadorMensagem gerenciador) {
        this.gerenciador = gerenciador;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(Medico medico) {
        this.medicos.add(medico);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void cadastraMedico(String nome, String crm, String especialidade, EntityManagerFactory emf) {
        Medico novoMedico = new Medico(nome, crm, especialidade);
        if (crm != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(novoMedico);
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("Campo crm vazio");
        }
    }

    public boolean verificaCRM(String crm) {
        for (char c : crm.toCharArray()) {
            if (Character.isLetter(c)) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    public List<String> imprimirMedicos(EntityManagerFactory emf) {
        // Criar a consulta JPQL para obter todos os médicos
        EntityManager em = emf.createEntityManager();
        List<Medico> medicos = em.createQuery("SELECT m FROM Medico m", Medico.class).getResultList();

        // Criar a lista de strings para armazenar a representação dos médicos
        List<String> listaMedicos = new ArrayList<>();

        // Converter cada médico para string e adicionar à lista
        for (Medico medico : medicos) {
            listaMedicos.add(medico.toString());
        }

        return listaMedicos;
    }
    
    public void imprimirMedicosPacientes() {
        for (Medico obj : medicos) {
            System.out.print("Doutor -> ");
            obj.imprimirMedico();

            System.out.println("Pacientes:");
            //obj.imprimirPacientes();

            System.out.println();
        }
    }

    public String imprimirSecretariaPacientes() {
        String Pacs = "";
        for (Paciente obj : secretaria.getPacientes()) {
            Pacs = Pacs + obj.imprimirPaciente();
        }
        return Pacs;
    }

    public String imprimirSecretariaConsultas() {
        String cons = "";
        for (Consulta obj : secretaria.getConsultas()) {
            cons = cons + obj.imprimirConsulta();
        }
        return cons;
    }

    public boolean testaPaciente(String cpf) {
        Paciente paciente = Buscas.buscaPaciente(secretaria.getPacientes(), cpf);
        if (paciente != null) {
            return true;
        } else {
            return false;
        }
    }
}
