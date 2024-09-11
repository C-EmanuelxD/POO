package DAOS;

import atoresSecundários.Paciente;
import dadosPessoas.DadosAdicionais;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author fabri
 */
public class DadosAdicionaisDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CLINICAPU");

    public void cadastraDadosAdicionais(String cpf, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Paciente paciente = em.find(Paciente.class, cpf);
        if (paciente != null) {
            DadosAdicionais dadosAdicionais = new DadosAdicionais(fuma, bebe, colesterol, diabete, doencaCardiaca, cirurgias, alergias);
            paciente.setDadosAdicionais(dadosAdicionais);
            em.merge(paciente);  // Faz o merge para persistir a relação
        }
        em.getTransaction().commit();
        em.close();
    }

    public void atualizaDadosAdicionais(String cpf, boolean fuma, boolean bebe, boolean colesterol, boolean diabete, boolean doencaCardiaca, String cirurgia, String alergia) {
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

    public void removeDadosAdicionais(String cpf) {
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

}
