package main;

import Principais.Clinica;
import Principais.Consulta;
import Principais.Medico;
import Principais.Paciente;
import Principais.Secretaria;
import clinica.tipos.TipoConsulta;
import clinica.tipos.TipoConvenio;

public class Main {
    public static void main(String[] args) {
        // instanciando secretaria e clinica
        Clinica clinica = new Clinica("Saude & Cia", new Secretaria("Vanessa"));
        Secretaria sec = clinica.getSecretaria();
        
        // cadastrando os medicos na clinica
        clinica.cadastraMedico("21234", "Roberto", "Ortopedista");
        clinica.cadastraMedico("12345", "Paulo", "Pneumologista");
        clinica.cadastraMedico("45678", "César", "Cardiologista");
        clinica.cadastraMedico("00000", "Rogério", "Neurologista");
        clinica.cadastraMedico("11111", "Fábio", "Oftalmologista");
        
        // cadastrando os pacientes na secretaria
        sec.cadastraPaciente("231.345.123-54", "Antonio", "02/07/2001", "Mauricio Fé, 357", "jorgefe@gmail.com", "99238-8341", TipoConvenio.PLANO);
        sec.cadastraPaciente("123.456.789-10", "José", "02/04/1965", "Alecrim Dourado, 321", null, "8842-3233", TipoConvenio.PARTICULAR);
        
        // cadastra consulta na secretaria, passando como parametro a lista de medicos que clinica possui
        sec.cadastraConsulta("02/03/2024", "09:30", "21234", "231.345.123-54", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("24/02/2024", "07:30", "21234", "123.456.789-10", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("15/03/2024", "10:30", "12345", "123.456.789-10", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.atualizaConsulta("123.456.789-10", "24/02/2024", "10:30", TipoConsulta.NORMAL);
        System.out.println("Gerando relatorios de consulta no dia seguinte: ");
        sec.gerarRelatorioConsulta("01/03/2024");
        
        System.out.println();
        System.out.println("Imprimindo consultas cadastradas em Secretaria:");
        for(Consulta obj : sec.getConsultas()) {
            obj.imprimirConsulta();
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Imprimindo pacientes cadastrados em Secretaria:");
        for(Paciente obj : sec.getPacientes()) {
            obj.imprimirPaciente();
        }
        
        System.out.println();
        System.out.println("Imprimindo os medicos da Clinica e seus respectivos pacientes:");
        for(Medico obj : clinica.getMedicos()) {
            System.out.print("Doutor -> ");
            obj.imprimirMedico();
            
            System.out.println("Pacientes:");
            obj.imprimirPacientes();
            
            System.out.println();
        }
     
    }
}
