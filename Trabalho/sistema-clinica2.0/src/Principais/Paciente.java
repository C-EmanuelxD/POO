package Principais;

import DadosPessoas.Prontuario;
import DadosPessoas.DadosAdicionais;
import clinica.tipos.TipoConvenio;
import java.util.List;
// NAO FEITO AINA
public class Paciente {
    private String cpf;
    private String nome;
    private String dataNascimento;
    private String endereco;
    private String email;
    private String sms;
    private TipoConvenio tipoConvenio;
    private DadosAdicionais dadosAdicionais; // verificar esta implemtentação
    private List<Prontuario> prontuarios;

    public Paciente( String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.sms = sms;
        this.tipoConvenio = tipoConvenio;
        this.dadosAdicionais = null;
        this.prontuarios = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }

    public TipoConvenio getTipoConvenio() {
        return tipoConvenio;
    }

    public void setTipoConvenio(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }

    public List<Prontuario> getProntuarios() {
        return prontuarios;
    }

    public void setProntuarios(Prontuario prontuario){
        prontuarios.add(prontuario);
    }

    public DadosAdicionais getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(DadosAdicionais dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public TipoConvenio getTipoPlano() {
        return tipoConvenio;
    }

    public void setTipoPlano(TipoConvenio tipoConvenio) {
        this.tipoConvenio = tipoConvenio;
    }
    
    public void imprimirPaciente() {
        System.out.println("\tNome: " + nome + ", Cpf: " + cpf + ", Data de Nascimento: " + dataNascimento + ", Endereco: " + endereco +", Email: " + email + ", SMS: " + sms + ", Convenio: " + tipoConvenio);
    }

}
