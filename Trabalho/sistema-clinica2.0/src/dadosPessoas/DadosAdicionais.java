package dadosPessoas;
//NAO FEITO AINDA

import atoresSecundários.Paciente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="dados_adicionais")
public class DadosAdicionais {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "fuma")
    private boolean fuma;

    @Column(name = "bebe")
    private boolean bebe;

    @Column(name = "colesterol")
    private boolean colesterol;

    @Column(name = "diabete")
    private boolean diabete;

    @Column(name = "doenca_cardiaca")
    private boolean doencaCardiaca;
    
    @ElementCollection
    @CollectionTable(name = "cirurgias", joinColumns = @JoinColumn(name = "dados_adicionais_id"))
    private List<String> cirurgias = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "alergias", joinColumns = @JoinColumn(name = "dados_adicionais_id"))
    private List<String> alergias = new ArrayList<>();

    @OneToOne(mappedBy = "dadosAdicionais")
    private Paciente paciente;
    
    public DadosAdicionais() {}
    
    public DadosAdicionais(boolean fuma, boolean bebe, boolean colesterol, boolean diabete,
                            boolean doencaCardiaca, List<String> cirurgias, List<String> alergias) {
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }
    
    public DadosAdicionais(boolean fuma, boolean bebe, boolean colesterol, boolean diabete,
                            boolean doencaCardiaca, Paciente paciente) {
        this.fuma = fuma;
        this.bebe = bebe;
        this.colesterol = colesterol;
        this.diabete = diabete;
        this.doencaCardiaca = doencaCardiaca;
        this.paciente = paciente;
    }

    public void cadastraCirurgia(String cirurgia){
        cirurgias.add(cirurgia);
    }
    
    public void cadastraAlergia(String alergia){
        alergias.add(alergia);
    }
    
    public boolean isFuma() {
        return fuma;
    }

    public void setFuma(boolean fuma) {
        this.fuma = fuma;
    }

    public boolean isBebe() {
        return bebe;
    }

    public void setBebe(boolean bebe) {
        this.bebe = bebe;
    }

    public boolean getColesterol() {
        return colesterol;
    }

    public void setColesterol(boolean colesterol) {
        this.colesterol = colesterol;
    }

    public boolean getDiabete() {
        return diabete;
    }

    public void setDiabete(boolean diabete) {
        this.diabete = diabete;
    }

    public boolean getDoencaCardiaca() {
        return doencaCardiaca;
    }

    public void setDoencaCardiaca(boolean doencaCardiaca) {
        this.doencaCardiaca = doencaCardiaca;
    }

    public List<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(List<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(List<String> alergias) {
        this.alergias = alergias;
    }
    
    public String imprimirDadosAdicionais() {
        String fumaStr = (this.fuma) ? "Fuma; " : "";
        String bebeStr = (this.bebe) ? "Bebe; " : "";
        String colesterolStr = (this.colesterol) ? "Colesterol; " : "";
        String diabeteStr = (this.diabete) ? "Diabete; " : "";
        String doencaCardiacaStr = (this.doencaCardiaca) ? "Doença Cardiaca; " : "";
        String cirurgiasStr = (this.cirurgias != null) ? this.cirurgias.toString() : List.of("").toString();
        String alergiasStr = (this.alergias != null) ? this.alergias.toString() : List.of("").toString();
        String res = fumaStr + bebeStr + colesterolStr + diabeteStr + doencaCardiacaStr;
        return "Dados adicionais do paciente:" + res + "Cirurgias: " + cirurgiasStr + "; " + "Alergias: " + alergiasStr + ";";
    }

}