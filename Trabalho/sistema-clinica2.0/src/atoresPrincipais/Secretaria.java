package atoresPrincipais;

import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import java.util.ArrayList;
import clinicaTipos.TipoConsulta;
import clinicaTipos.TipoConvenio;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "secretaria")
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "secretaria_id") // Cria uma coluna de FK na tabela paciente
    private List<Paciente> pacientes; // Uma secretária pode gerenciar muitos pacientes

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "secretaria_id") // Cria uma coluna de FK na tabela consulta
    private List<Consulta> consultas;  // Uma secretária pode gerenciar muitas consultas

    public Secretaria(String nome) {
        this.nome = nome;
        pacientes = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void setPacientes(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void cadastraPaciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio, EntityManagerFactory emf) {
        Paciente novoPaciente = new Paciente(cpf, nome, dataNascimento, endereco, email, sms, tipoConvenio);
        if (cpf != null) {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(novoPaciente);
            em.getTransaction().commit();
            em.close();
        } else {
            System.out.println("Campo cpf vazio");
        }
    }

    public void atualizaPaciente(String cpf, String nome, String endereco, String email, String sms, TipoConvenio tipoConvenio, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            paciente.setNome(nome);
            paciente.setEndereco(endereco);
            paciente.setEmail(email);
            paciente.setSms(sms);
            paciente.setTipoConvenio(tipoConvenio);
            em.merge(paciente);
        } else {
            System.out.println("Paciente não encontrado");
        }
        em.getTransaction().commit();
        em.close();
    }

    public void removePaciente(String cpf, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {

            em.remove(paciente);
            em.getTransaction().commit();
            em.close();
        }

    }

    public void cadastraConsulta(String data, String horario, String crm, String cpf, TipoConsulta tipoConsulta, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        Medico medico = em.find(Medico.class, crm);
        if (paciente != null && medico != null) {
            Consulta novaConsulta = new Consulta(data, horario, medico, paciente, tipoConsulta);
            em.persist(novaConsulta);
            em.merge(medico);
            em.getTransaction().commit();
            System.out.println("Consulta cadastrada com sucesso");
        } else {
            System.out.println("Paciente e/ou Médico não encontrado");
        }
        em.close();
    }

    public void atualizaConsulta(String crm, String data, String horario, String dataNova, String horarioNovo, TipoConsulta tipoConsulta, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Consulta consulta = em.createQuery("SELECT c FROM Consulta c WHERE c.medico.crm = :crm AND c.data = :data AND c.horario = :horario", Consulta.class).setParameter("crm", crm).setParameter("data", data).setParameter("horario", horario).getSingleResult();
        if (consulta != null) {
            consulta.setData(dataNova);
            consulta.setHorario(horarioNovo);
            consulta.setTipoConsulta(tipoConsulta);
            em.merge(consulta); //sincroniza legal ai dog
            em.getTransaction().commit();
            System.out.println("Consulta atualizada com sucesso");
        } else {
            System.out.println("Consulta não encontrada");
        }
        em.close();
    }

    public void removeConsulta(String crm, String data, String horario, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Consulta consulta = em.createQuery("SELECT c FROM Consulta c WHERE c.medico.crm = :crm AND c.data = :data AND c.horario = :horario",
                Consulta.class).setParameter("crm", crm).setParameter("data", data).setParameter("horario", horario).getSingleResult();
        if (consulta != null) {
            em.remove(consulta);
            em.getTransaction().commit();
            em.close();
            System.out.println("Consulta removida com sucesso");
        } else {
            System.out.println("Consulta não encontrada");

        }
    }

    // ta meio feito fe com fe ta em 
    public List<Consulta> consultasDiaSeguinte(String dataAtual, EntityManagerFactory emf) {
        String[] partes = dataAtual.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        if (dia == 31) {
            mes += 1;
            dia = 1;
        } else if (mes == 12 && dia == 31) {
            ano += 1;
            mes = 1;
            dia = 1;
        } else {
            dia += 1;
        }

        String prox_dia = String.format("%02d/%02d/%d", dia, mes, ano);
        EntityManager em = emf.createEntityManager();
        // tem que colocar filtro para email/sms
        List<Consulta> consultasComContato = em.createQuery(
                "SELECT c FROM Consulta c WHERE c.data = :data AND c.paciente.email IS NOT NULL AND c.paciente.celular IS NOT NULL",
                Consulta.class)
                .setParameter("data", prox_dia)
                .getResultList();

        List<Consulta> consultasSemContato = em.createQuery(
                "SELECT c FROM Consulta c WHERE c.data = :data AND (c.paciente.email IS NULL OR c.paciente.celular IS NULL)",
                Consulta.class)
                .setParameter("data", prox_dia)
                .getResultList();
        em.close();
        return consultasComContato;
    }

    public List<Consulta> gerarRelatorioConsulta(String dataAtual, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        List<Consulta> consultas = em.createQuery("SELECT c FROM Consulta c WHERE c.data = :data",
                Consulta.class)
                .setParameter("data", dataAtual)
                .getResultList();
        em.close();

        return consultas;
    }
}
