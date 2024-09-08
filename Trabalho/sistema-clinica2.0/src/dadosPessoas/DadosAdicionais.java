package dadosPessoas;
//NAO FEITO AINDA

import java.util.Arrays;
import java.util.List;

public class DadosAdicionais {
    private boolean fuma;
    private boolean bebe;
    private boolean colesterol;
    private boolean diabete;
    private boolean doencaCardiaca;
    private List<String> cirurgias;
    private List<String> alergias;

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
