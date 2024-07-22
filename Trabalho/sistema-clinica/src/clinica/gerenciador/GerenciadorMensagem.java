package clinica.gerenciador;

import clinica.secretaria.Consulta;
import java.util.List;

public class GerenciadorMensagem {
    private List<Consulta> consultas;

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }
}
