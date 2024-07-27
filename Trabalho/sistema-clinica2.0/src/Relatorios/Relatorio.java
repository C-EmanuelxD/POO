package Relatorios;

import Principais.Medico;
import Principais.Paciente;
import DadosPessoas.Prontuario;

public abstract class Relatorio {
    protected String data;
    protected Paciente paciente;
    protected Medico medico;
    
    public void imprimir() {}
}
