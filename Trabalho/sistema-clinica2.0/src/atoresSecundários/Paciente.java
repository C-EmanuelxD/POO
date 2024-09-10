package atoresSecundários;

import dadosPessoas.Prontuario;
import dadosPessoas.DadosAdicionais;
import clinicaTipos.TipoConvenio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class Paciente {
    @Id
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "endereco", length = 255)
    private String endereco;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "sms", length = 20)
    private String sms;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_convenio")
    private TipoConvenio tipoConvenio;

    @OneToOne
    @JoinColumn(name = "dados_adicionais_id")
    private DadosAdicionais dadosAdicionais;

    @OneToMany(mappedBy = "paciente")
    private List<Prontuario> prontuarios = new ArrayList<>();
    
    public Paciente() {}
    
    public Paciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        this.cpf = cpf;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.email = email;
        this.sms = sms;
        this.tipoConvenio = tipoConvenio;
        this.dadosAdicionais = new DadosAdicionais();
        this.prontuarios = new ArrayList<>();
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
        this.prontuarios.add(prontuario);
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
    
    public String imprimirPaciente() {
        return "Paciente - > Nome: " + nome + ", Cpf: " + cpf + ", Data de Nascimento: " + dataNascimento + ", Endereco: " + endereco +", Email: " + email + ", SMS: " + sms + ", Convenio: " + tipoConvenio + "\n\n";
    }
    
    public String imprimirProntuarios() {
        String pronts = "";
        for(Prontuario obj : prontuarios) {
            pronts = pronts+obj.imprimirProntuario();
            
        }
        return pronts;
    }
}
