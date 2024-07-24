package Relatorios;

import Principais.Paciente;
import java.util.List;

public class Receita extends Relatorio {
    private List<String> remedios;

    public List<String> getRemedios() {
        return remedios;
    }

    public String getData() {
        return data;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
