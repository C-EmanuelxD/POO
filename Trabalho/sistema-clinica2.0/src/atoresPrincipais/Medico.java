package atoresPrincipais;

import classesAuxiliares.Buscas;
import dadosPessoas.DadosAdicionais;
import dadosPessoas.Prontuario;
import atoresSecundários.Consulta;
import atoresSecundários.Paciente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @Column(name = "crm", nullable = false, unique = true)
    private String crm;  // CRM será a chave primária

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "especialidade", nullable = false)
    private String especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Consulta> consultas;  // Relacionamento One-to-Many com Consulta

    public Medico() {
    }

    public Medico(String nome, String crm, String especialidade) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.consultas = new ArrayList<>();
    }

    public void cadastraDadosAdicionais(String cpf, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            DadosAdicionais dadosAdicionais = new DadosAdicionais(fuma, bebe, colesterol, diabete, doencaCardiaca, cirurgias, alergias);
            em.getTransaction().begin();
            em.persist(dadosAdicionais);
        }
        em.close();
    }

    public void atualizaDadosAdicionais(String cpf, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, String cirurgia, String alergia, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            DadosAdicionais dadosAdicionais = paciente.getDadosAdicionais();
            if (dadosAdicionais != null) {
                dadosAdicionais.setFuma(fuma);
                dadosAdicionais.setBebe(bebe);
                dadosAdicionais.setColesterol(colesterol);
                dadosAdicionais.setDiabete(diabete);
                dadosAdicionais.setDoencaCardiaca(doencaCardiaca);
                if (!"".equals(cirurgia)) {// nao sei se ta certo daqui pra baixo me basiei no mdico la ai nao sei se com db funciona igual
                    dadosAdicionais.cadastraCirurgia(cirurgia);
                }
                if (!"".equals(alergia)) {
                    dadosAdicionais.cadastraAlergia(alergia);
                }
            }
        }
        em.getTransaction().commit();
        em.close();
    }

    public void removeDadosAdicionais(String cpf, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null && paciente.getDadosAdicionais() != null) {
            DadosAdicionais dadosAdicionais = paciente.getDadosAdicionais();
            paciente.setDadosAdicionais(null);  // Remove a relação no paciente
            em.remove(em.contains(dadosAdicionais) ? dadosAdicionais : em.merge(dadosAdicionais));  // Remove dados adicionais
        }
        em.getTransaction().commit();
        em.close();
    }

    public void cadastraProntuario(String cpf, String sintomas, String diagnostico, String preescricaoTratamento, String dataAdd, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            Prontuario prontuario = new Prontuario(sintomas, diagnostico, preescricaoTratamento, dataAdd, paciente);
            em.getTransaction().begin();
            em.persist(prontuario);
            em.getTransaction().commit();
        } else {
            System.out.println("Paciente não encontrado.");
        }
        em.close();
    }

    public void atualizaProntuario(String cpf, String data, String diagnostico, String prescricao, String sintomas, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            Prontuario prontuario = em.createQuery("SELECT p FROM Prontuario p WHERE p.data = :dataProntuario AND p.paciente.cpf = :cpfPaciente", Prontuario.class).setParameter("dataProntuario", data).setParameter("cpfPaciente", cpf).getSingleResult();
            prontuario.setData(data);
            prontuario.setDiagnostico(diagnostico);
            prontuario.setPrescricao(prescricao);
            prontuario.setSintomas(sintomas);
            em.merge(prontuario);
            em.getTransaction().commit();
            System.out.println("Prontuário atualizado com sucesso.");
        } else {
            System.out.println("Prontuário não encontrado para a data e paciente fornecidos.");
        }
        em.close();

    }

    public void removeProntuario(String cpf, String data, EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            Prontuario prontuario = em.createQuery("SELECT p FROM Prontuario p WHERE p.data = :dataProntuario AND p.paciente.cpf = :cpfPaciente", Prontuario.class).setParameter("dataProntuario", data).setParameter("cpfPaciente", cpf).getSingleResult();
            em.remove(prontuario);
            em.getTransaction().commit();
            System.out.println("Prontuário removido com sucesso.");

        } else {
            System.out.println("Prontuário não encontrado para a data e paciente fornecidos.");

        }
    }

    public String pacienteMes(String mes) {
        int numPacientes = 0;
        String pacs = "";
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            String data = consulta.getData();
            String[] parte = data.split("/");

            if (mes.equals(parte[1])) {
                pacs = pacs + consulta.getPaciente().imprimirPaciente();
                numPacientes++;
            }
        }
        return pacs;
    }

    public String geraAtestado(String dataInicio, String dataFim, String justificativa, String cpf) {
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        return "Atestado para: " + paciente.getNome() + "\nvalido de " + dataInicio + ", ate " + dataFim + "\n"
                + "Pelo motivo de: " + justificativa + "." + "\n"
                + "Assinado por: " + nome + "\n";
    }

    public void geraReceita(Map<String, String> remedios, String infoExtra, String data, String cpf) {
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        for (String key : remedios.keySet()) {
            System.out.println(key + ": " + remedios.get(key));
        }
        System.out.println(infoExtra + ".");
        System.out.println("Para o paciente: " + paciente.getNome() + ".");
        System.out.println("Medico: " + nome + " " + data + ".");
    }

    public String geraDeclaracaoAcompanhamento(String justificativa, String acompanhante, String data, String cpf) {
        Paciente paciente = Buscas.buscaPacienteConsulta(consultas, cpf);

        return "Declaro que " + acompanhante + " esteve no dia " + data + " acompanhando " + paciente.getNome() + " no atendimento" + "\n"
                + "Assinado por " + nome + ".";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Consulta> getConsulta() {
        return consultas;
    }

    public void setConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void imprimirMedico() {
        System.out.println("Nome: " + nome + ", Crm: " + crm + ", Especialidade: " + especialidade);
    }

    @Override
    public String toString() {
        return "Doutor -> Nome: " + nome + ", Crm: " + crm + ", Especialidade: " + especialidade;
    }

    // imprime todos os pacientes do medico, sem duplicacao.
    public List<String> imprimirNomePacientes() {
        Set<Paciente> pacientesImpressos = new HashSet<>();
        List<String> pacs = new ArrayList<>();
        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            if (!pacientesImpressos.contains(paciente)) {
                pacientesImpressos.add(paciente);
                pacs.add(paciente.getCpf());
            }
        }
        return pacs;
    }

    public String imprimirPacientes() {
        Set<Paciente> pacientesImpressos = new HashSet<>();
        String PACS = "";
        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            if (!pacientesImpressos.contains(paciente)) {
                pacientesImpressos.add(paciente);
                PACS = PACS + ("Nome: " + paciente.getNome()
                        + ", Cpf: " + paciente.getCpf()
                        + ", Data de nascimento: " + paciente.getDataNascimento() + "\n");
            }
        }
        return PACS;
    }

}
