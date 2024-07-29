package main;

import Auxiliares.Buscas;
import Principais.Clinica;
import Principais.Medico;
import Principais.Paciente;
import Principais.Secretaria;
import clinica.tipos.TipoConsulta;
import clinica.tipos.TipoConvenio;
import java.util.Arrays;
import java.util.Scanner;

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
        Medico med = Buscas.buscaMedico(clinica.getMedicos(), "21234");
        
        // cadastrando os pacientes na secretaria
        sec.cadastraPaciente("231.345.123-54", "Antonio", "02/07/2001", "Mauricio Fé, 357", null, null, TipoConvenio.PLANO);
        sec.cadastraPaciente("123.456.789-10", "José", "02/04/1965", "Alecrim Dourado, 321", null, "8842-3233", TipoConvenio.PARTICULAR);
        
        // cadastra consulta na secretaria, passando como parametro a lista de medicos que clinica possui
        sec.cadastraConsulta("02/03/2024", "09:30", "21234", "231.345.123-54", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("02/03/2024", "07:30", "21234", "123.456.789-10", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("02/03/2024", "10:30", "12345", "123.456.789-10", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("05/03/2024", "11:30", "12345", "123.456.789-10", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.atualizaConsulta("21234", "02/03/2024", "09:30", "02/03/2024", "17:00", TipoConsulta.NORMAL);
        
        
        // atualiza paciente
        sec.atualizaPaciente("123.456.789-10", "zé", "Alecrim Dourado, 220", "jose@gmail.com", "8842-3233", TipoConvenio.PLANO);
        
        System.out.println("Gerando relatorios de consulta no dia seguinte: ");
        sec.gerarRelatorioConsulta("01/03/2024");
        
        System.out.println();
        System.out.println("Imprimindo consultas cadastradas em Secretaria:");
        clinica.imprimirSecretariaConsultas();
        
        System.out.println();
        System.out.println("Imprimindo pacientes cadastrados em Secretaria:");
        clinica.imprimirSecretariaPacientes();
        
        System.out.println();
        System.out.println("Imprimindo os medicos da Clinica e seus respectivos pacientes:");
        clinica.imprimirMedicosPacientes();
        
        Scanner sc = new Scanner(System.in);
        med.cadastraDadosAdicionais("123.456.789-10", false, false, false, true, true, Arrays.asList("Apendicite", "Pedra no rim"), null);

          byte c;

          do {
              System.out.println("Selecione uma das opções de acesso abaixo: ");
              System.out.println("(0) Sair (1) Secretaria (2) Médico");
              c = sc.nextByte();
              switch (c){
                  case 1 -> menuSecretaria(clinica, sc);
                  case 2 -> menuAcessoMedico(clinica, sc);
              }
          } while(c != 0);
    }
    
    // menu para acessar medico, digita o crm para acessar a "conta" do medico
    public static void menuAcessoMedico(Clinica clinica, Scanner sc) {
        System.out.println("Insira o crm para entrar: ");
        String crm = sc.next();
        
        Medico medico = Buscas.buscaMedico(clinica.getMedicos(), crm);
        if (medico != null) {
            menuMedico(clinica, medico, sc);
        } else {
            System.out.println("Medico não encontrado");
        }
    }
    
    // menu do medico com acesso aos pacientes e relatorios
    public static void menuMedico(Clinica clinica, Medico medico, Scanner sc) {
        System.out.println();
        System.out.println("Bem vindo, Dr. " + medico.getNome());
        System.out.println("Selecione uma das opções");
        System.out.println("(1) Buscar paciente");
        System.out.println("(2) Gerar relatório pacientes atendidos no mês");
        System.out.println("(3) Sair");
        byte c;
        c = sc.nextByte();
        switch (c){
            case 1 -> menuAcessoPacientes(clinica, medico, sc);
            case 2 -> menuGeraRelatorioMes(clinica, medico, sc);
            case 3 -> System.out.println("Saindo...\n");
        }
        
    }   
    
    // menu do medico para a imprimir, buscar e acessar a ficha de um paciente
    public static void menuAcessoPacientes(Clinica clinica, Medico medico, Scanner sc) {
        System.out.println("Pacientes:");
        medico.imprimirPacientes();
        
        System.out.println();
        System.out.println("Digite o cpf do paciente que deseja acessar");
        String cpf = sc.next();
        
        Paciente paciente = Buscas.buscaPacienteConsulta(medico.getConsulta(), cpf);
        if (paciente != null) {
            System.out.println();
            menuPaciente(medico, paciente, sc); // acessa o menu do paciente buscado
        } else {
            System.out.println("Paciente não encontrado");
            menuMedico(clinica, medico, sc); // retorna para o menu anterior
        }
    }
    
    // menu do paciente que o medico tem o acesso
    public static void menuPaciente(Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Paciente acessado: " + paciente.getNome());
        System.out.println("Selecione uma das opções: ");
        System.out.println("(1) Dados adicionais");
        System.out.println("(2) Prontuario");
        
        System.out.println("(3) Gerar receita");
        System.out.println("(4) Gerar atestado");
        System.out.println("(5) Gerar declaração de acompanhamento");
        System.out.println("(6) Sair");
        byte c;
        c = sc.nextByte();
        switch (c){
            case 1 -> menuDadosAdicionaisPaciente(medico, paciente, sc);
            case 2 -> menuProntuario(medico,paciente, sc);
            case 6 -> System.out.println("Saindo...\n");
        }
    }
    
    // dados adicionais do paciente, cadastrar atualizar, remover e imprimir
    public static void menuDadosAdicionaisPaciente(Medico medico, Paciente paciente, Scanner sc) {
        if (paciente.getDadosAdicionais() != null) {
            paciente.getDadosAdicionais().imprimirDadosAdicionais();
            
            System.out.println();
        } else {
            System.out.println("Dados adicionais não cadastrados\n");
        }
        
        menuPaciente(medico, paciente, sc); // retorna pro menu anterior
    }
    
    public static void menuProntuario(Medico medico, Paciente paciente, Scanner sc) {
        if (paciente.getProntuarios() != null) { // ainda tem que implementar a impressao do prontuario
            System.out.println();
        } else {
            System.out.println("Prontuarios não cadastrados");
        }
        
        menuPaciente(medico, paciente, sc); // retorna pro menu anterior
    }
    
    public static void menuGeraRelatorioMes(Clinica clinica, Medico medico, Scanner sc) {
        System.out.println("Digite o mês (Formato: 0x)");
        String data = sc.next();
        System.out.println("Paciente atendidos: ");
        medico.pacienteMes(data);
        
        System.out.println();
        menuMedico(clinica, medico, sc); // retorna pro menu anterior
    }
    
    public static void menuSecretaria(Clinica clinica, Scanner sc) {
        System.out.println("Selecione uma das operações");
        System.out.println("(1) Cadastrar paciente");
        System.out.println("(2) Atualizar paciente");
        System.out.println("(3) Remover paciente");
        System.out.println("(4) Cadastrar consulta");
        System.out.println("(5) Atualizar consulta");
        System.out.println("(6) Remover consulta");
        System.out.println("(7) Gerar relatório de consulta");
        
        byte c;
        c = sc.nextByte();
        switch (c){
            case 1 -> menuCadastroPaciente(clinica, sc);
            case 2 -> menuAtualizaPaciente(clinica, sc);
            case 3 -> menuRemovePaciente(clinica, sc);
            case 4 -> menuCadastroConsulta(clinica, sc);
            case 5 -> menuAtualizaConsulta(clinica, sc);
            case 6 -> menuRemoveConsulta(clinica, sc);
        }
    }
    
    public static void menuCadastroPaciente(Clinica clinica, Scanner sc) {}
    
    public static void menuAtualizaPaciente(Clinica clinica, Scanner sc) {}
    
    public static void menuRemovePaciente(Clinica clinica, Scanner sc) {}
    
    public static void menuCadastroConsulta(Clinica clinica, Scanner sc) {}
    
    public static void menuAtualizaConsulta(Clinica clinica, Scanner sc) {}
    
    public static void menuRemoveConsulta(Clinica clinica, Scanner sc) {}
}
