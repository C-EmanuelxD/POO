package Relatorios;

import Principais.Medico;
import Principais.Paciente;

public abstract class Relatorio {
    protected String data;
    protected Paciente paciente;
    protected Medico medico;
    
    public abstract void imprimir(String pacienteNome, String medicoNome);
}
