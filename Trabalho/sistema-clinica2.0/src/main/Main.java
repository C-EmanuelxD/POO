package main;

import Principais.Medico;
import Principais.Paciente;
import Principais.Secretaria;
import clinica.tipos.TipoConvenio;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Medico> medicos = new ArrayList<>();
        Secretaria sec = new Secretaria("Saúde & Cia");
        
        sec.cadastraPaciente("231.345.123-54", "Jorge", "02/07/2001", "Mauricio Fé, 357", "jorgefe@gmail.com", "99238-8341", TipoConvenio.PLANO);
        sec.cadastraPaciente("123.456.789-10", "José", "02/04/1965", "Alecrim Dourado, 321", "jose@gmail.com", "8842-3233", TipoConvenio.PARTICULAR);
        
        sec.removePaciente("123.456.789-10");
        for(Paciente x : sec.getPacientes()) {
            x.imprimirPaciente();
        }
    }
}
