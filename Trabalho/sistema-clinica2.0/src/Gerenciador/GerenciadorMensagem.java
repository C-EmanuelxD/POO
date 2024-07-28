package Gerenciador;

import Principais.Consulta;
import Principais.Secretaria;
import java.util.ArrayList;
import java.util.List;

//não feito ainda
public class GerenciadorMensagem {
    private Secretaria secretaria;
    
    public GerenciadorMensagem(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }
    
    public void enviarEmail(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
    }
    
    public void enviarSMS(String dataAtual) {
        List<Consulta> consultasMensagem = secretaria.consultasDiaSeguinte(dataAtual);
    }
    
    
}
