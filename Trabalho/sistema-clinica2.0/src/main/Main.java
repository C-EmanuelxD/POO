package main;

import Auxiliares.Buscas;
import DadosPessoas.Prontuario;
import Principais.Clinica;
import Principais.Medico;
import Principais.Paciente;
import Principais.Secretaria;
import clinica.tipos.TipoConsulta;
import clinica.tipos.TipoConvenio;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        sec.cadastraPaciente("231", "Antonio", "02/07/2001", "Mauricio Fé, 357", null, "9999-4444", TipoConvenio.PLANO);
        sec.cadastraPaciente("123", "José", "02/04/1965", "Alecrim Dourado, 321", null, "8842-3233", TipoConvenio.PARTICULAR);
        
        // cadastra consulta na secretaria, passando como parametro a lista de medicos que clinica possui
        sec.cadastraConsulta("02/03/2024", "09:30", "21234", "231", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("02/03/2024", "07:30", "21234", "123", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("02/03/2024", "10:30", "12345", "123", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.cadastraConsulta("05/03/2024", "11:30", "12345", "123", TipoConsulta.NORMAL, clinica.getMedicos());
        sec.atualizaConsulta("21234", "02/03/2024", "09:30", "02/03/2024", "17:00", TipoConsulta.NORMAL);
        
        // atualiza paciente
        sec.atualizaPaciente("123", "zé", "Alecrim Dourado, 220", "jose@gmail.com", "8842-3233", TipoConvenio.PLANO);
        
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
        
        med.cadastraDadosAdicionais("123", false, false, false, true, true, Arrays.asList("Apendicite", "Pedra no rim"), null);
        //sec.removeConsulta("21234", "02/03/2024", "17:00");
        clinica.imprimirSecretariaConsultas();
        
        Scanner sc = new Scanner(System.in).useDelimiter("\n"); // .useDelimiter("\n") para pegar Strings que tem espaço no input como endereco
        
        byte c = 0;
        do {
            System.out.println("Clinica " + clinica.getNome());
            menu(clinica, sc, c);
        } while(c != 0);
    }
    
    public static void menu(Clinica clinica, Scanner sc, byte c) {
        System.out.println("Selecione uma das opções de acesso abaixo: ");
        System.out.println("(0) Sair (1) Secretaria (2) Médico (3) Gerenciador de mensagens (4) Cadastrar médico (5) Imprimir médicos");
        c = sc.nextByte();
        System.out.println();
        switch (c){
            case 0 -> System.exit(c);
            case 1 -> menuSecretaria(clinica, sc);
            case 2 -> menuAcessoMedico(clinica, sc);
            case 3 -> menuGerenciadorMensagem(clinica, sc, c);
            case 4 -> menuCadastrarMedico(clinica, sc, c);
            case 5 -> menuImprimirMedicos(clinica, sc, c);
            default -> menu(clinica, sc, c);
        }
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
        System.out.println("(3) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuAcessoPacientes(clinica, medico, sc);
            case 2 -> menuGeraRelatorioMes(clinica, medico, sc);
            case 3 -> menu(clinica, sc, c);
            default -> menuMedico(clinica, medico, sc);
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
            menuPaciente(clinica, medico, paciente, sc); // acessa o menu do paciente buscado
        } else {
            System.out.println("Paciente não encontrado");
            menuMedico(clinica, medico, sc); // retorna para o menu anterior
        }
    }
    
    // menu do paciente que o medico tem o acesso
    public static void menuPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Paciente acessado: " + paciente.getNome());
        System.out.println("Selecione uma das opções: ");
        System.out.println("(1) Dados adicionais");
        System.out.println("(2) Prontuario");
        
        System.out.println("(3) Gerar receita");// falta
        System.out.println("(4) Gerar atestado");
        System.out.println("(5) Gerar declaração de acompanhamento");
        System.out.println("(6) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuDadosAdicionaisPaciente(clinica, medico, paciente, sc);
            case 2 -> menuProntuario(clinica, medico,paciente, sc);
            case 3 -> menuGerarReceita(clinica, medico, paciente, sc);
            case 4 -> menuGerarAtestado(clinica, medico, paciente, sc);
            case 5 -> menuGerarDeclaracaoAcomp(clinica, medico, paciente, sc);
            case 6 -> menuMedico(clinica, medico, sc);
            default -> menuPaciente(clinica, medico, paciente, sc);
        }
    }
    
    
    public static void menuGerarReceita(Clinica clinica, Medico medico, Paciente paciente, Scanner sc){
        Map<String, String> remedios = new HashMap<>();
        
        System.out.print("Insira a quantiade de remedio a ser receitado");
        byte c = sc.nextByte();
        sc.nextLine();
        System.out.println(c);
        for(int i = 0; i < c;i++ ){
            System.out.print("Insira o remedio: ");
            String remedio = sc.next();
            System.out.print("Insira a dosagem do remedio: ");
            String dosagem = sc.next();            
            remedios.put(remedio, dosagem);
        }
        System.out.print("Insira informacao extra: ");
        String infoExtra = sc.next();
        System.out.print("Digite a data: ");
        String data =sc.next();
        
        medico.geraReceita(remedios, infoExtra, data, paciente.getCpf());
        
    }
    
    
    public static void menuGerarAtestado(Clinica clinica, Medico medico, Paciente paciente, Scanner sc){
        System.out.println("Digite as informações do atestado:");
        System.out.print("Digite a data de inicio do atestado: ");
        String dataini = sc.next();
        System.out.print("Digite a data de fim do atestado: ");
        String datafim = sc.next();
        System.out.print("Digite a justificativa do atestado: ");
        String justificativa = sc.next();
        
        System.out.println();
        
        medico.geraAtestado(dataini, datafim, justificativa, paciente.getCpf());
        
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    
    public static void menuGerarDeclaracaoAcomp(Clinica clinica, Medico medico, Paciente paciente, Scanner sc){
        System.out.println("Digite as informações da Declaração de Acompanhamento:");
        System.out.print("Digite a justificativa: ");
        String justificativa = sc.next();
        System.out.print("Digite o nome do acompanhante: ");
        String acompanhante = sc.next();
        System.out.print("Digite a data: ");
        String data = sc.next();
        
        System.out.println();
        medico.geraDeclaracaoAcompanhamento(justificativa, acompanhante, data, paciente.getCpf());
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    
    // dados adicionais do paciente, cadastrar atualizar, remover e imprimir
    public static void menuDadosAdicionaisPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Dados adicionais de: " + paciente.getNome());
        System.out.println("Selecione uma das opções: ");
        System.out.println("(1) Cadastrar dados adicionais");
        System.out.println("(2) Atualizar dados adicionais");
        System.out.println("(3) Remover dados adicionais");
        System.out.println("(4) Imprimir dados adicionais");
        System.out.println("(5) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuCadastrarDadosAdicionaisPaciente(clinica, medico, paciente, sc);
            case 2 -> menuAtualizarDadosAdicionaisPaciente(clinica, medico,paciente, sc);
            case 3 -> menuRemoverDadosAdicionaisPaciente(clinica, medico, paciente, sc);
            case 4 -> menuImprimirDadosAdicionaisPaciente(clinica, medico, paciente, sc);
            case 5 -> menuPaciente(clinica, medico, paciente, sc);
            default -> menuDadosAdicionaisPaciente(clinica, medico, paciente, sc);
        }
        
        menuPaciente(clinica, medico, paciente, sc); // retorna pro menu anterior
    }
    
    public static void menuCadastrarDadosAdicionaisPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        
        if(paciente.getDadosAdicionais() == null) { 
            System.out.println("Insira os dados adicionais do paciente (escreva true para sim e false para não)");

            System.out.print("Fuma: ");
            boolean fuma = sc.nextBoolean();

            System.out.print("Bebe: ");
            boolean bebe = sc.nextBoolean();

            System.out.print("Diabetes: ");
            boolean diabetes = sc.nextBoolean();

            System.out.print("Doença Cardíaca: ");
            boolean doencaCardiaca = sc.nextBoolean();

            System.out.print("Colesterol: ");
            boolean colesterol = sc.nextBoolean();

            System.out.println("Insira as cirurgias anteriores (separadas por vírgula): ");
            String cirurgiasInput = sc.next();
            List<String> cirurgias = Arrays.asList(cirurgiasInput.split("\\s*,\\s*")); // Divide a entrada por vírgulas, removendo espaços em branco

            System.out.println("Insira as alergias (separadas por vírgula): ");
            String alergiasInput = sc.next();
            List<String> alergias = Arrays.asList(alergiasInput.split("\\s*,\\s*"));

            medico.cadastraDadosAdicionais(paciente.getCpf(), fuma, bebe, colesterol, diabetes, doencaCardiaca, cirurgias, alergias);
        } else {
            System.out.println("Os dados adicionais do paciente já estão cadastrados ");
        }
        
        System.out.println();
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    public static void menuAtualizarDadosAdicionaisPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        if(paciente.getDadosAdicionais() != null) {
            System.out.println("Insira os dados adicionais do paciente para atualizar os dados (escreva true para sim e false para não)");

            System.out.print("Fuma: ");
            boolean fuma = sc.nextBoolean();

            System.out.print("Bebe: ");
            boolean bebe = sc.nextBoolean();

            System.out.print("Diabetes: ");
            boolean diabetes = sc.nextBoolean();

            System.out.print("Doença Cardíaca: ");
            boolean doencaCardiaca = sc.nextBoolean();

            System.out.print("Colesterol: ");
            boolean colesterol = sc.nextBoolean();

            System.out.print("Cadastro de nova cirurgia: ");
            String cirurgiasInput = sc.next();

            System.out.print("Cadastro de nova alergia: ");
            String alergiasInput = sc.next();

            medico.atualizaDadosAdicionais(paciente.getCpf(), fuma, bebe, colesterol, diabetes, doencaCardiaca, cirurgiasInput, alergiasInput);
            System.out.println("Dados adicionais de " + paciente.getNome() + " atualizados\n");
        } else {
            System.out.println("Os dados adicionais do paciente ainda não foram cadastrados\n");
        }
        menuPaciente(clinica, medico, paciente, sc);
    }

    public static void menuRemoverDadosAdicionaisPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        medico.removeDadosAdicionais(paciente.getCpf());
        System.out.println("Os dados adicionais de " + paciente.getNome() + " foram removidos.\n");
        
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    public static void menuImprimirDadosAdicionaisPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        if (paciente.getDadosAdicionais() != null) {
            paciente.getDadosAdicionais().imprimirDadosAdicionais();
            System.out.println();
        } else {
            System.out.println("Dados adicionais não cadastrados\n");
        }
    }
    
    public static void menuProntuario(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Dados adicionais de: " + paciente.getNome());
        System.out.println("Selecione uma das opções: ");
        System.out.println("(1) Cadastrar prontuario");
        System.out.println("(2) Atualizar prontuario");
        System.out.println("(3) Remover prontuario");
        System.out.println("(4) Imprimir prontuario");
        System.out.println("(5) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuCadastrarProntuarioPaciente(clinica, medico, paciente, sc);
            case 2 -> menuAtualizarProntuarioPaciente(clinica, medico, paciente, sc);
            case 3 -> menuRemoverProntuarioPaciente(clinica, medico, paciente, sc);
            case 4 -> menuImprimirProntuarios(clinica, medico, paciente, sc);
            case 5 -> menuPaciente(clinica, medico, paciente, sc);
            default -> menuProntuario(clinica, medico, paciente, sc);
        }
        
        menuPaciente(clinica, medico, paciente, sc); // retorna pro menu anterior
    }
    
    public static void menuCadastrarProntuarioPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Insira os dados para o cadastro do prontuario:");
        System.out.print("Data: ");
        String data = sc.next();
        System.out.print("Sintomas: ");
        String sintomas = sc.next();
        System.out.print("Diagnostico: ");
        String diagnostico = sc.next();
        System.out.print("Prescrição: ");
        String prescricao = sc.next();
        
        medico.cadastraProntuario(paciente.getCpf(), sintomas, diagnostico, prescricao, data);
        System.out.println("Prontuario cadastrado.\n");
        
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    public static void menuAtualizarProntuarioPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Insira a data do prontuário buscado: ");
        System.out.print("Data: ");
        String data = sc.next();
        Prontuario pront = Buscas.buscaProntuario(paciente.getProntuarios(), data);
        if (!paciente.getProntuarios().isEmpty() && pront != null) {
            System.out.println("Sintomas: ");
            String sintomas = sc.next();
            System.out.print("Diagnostico: ");
            String diagnostico = sc.next();
            System.out.print("Prescrição: ");
            String prescricao = sc.next();
            medico.atualizaProntuario(paciente.getCpf(), data, diagnostico, prescricao, sintomas);
       } else {
            System.out.println("Nenhum prontuário encontrado nesta data\n");
        }
        
        menuPaciente(clinica, medico, paciente, sc);
    }

    public static void menuRemoverProntuarioPaciente(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.print("Insira a data do prontuário a ser removido: ");
        String data = sc.next();
        Prontuario prontRemovido = Buscas.buscaProntuario(paciente.getProntuarios(), data);
        if (prontRemovido != null) {
            medico.removeProntuario(paciente.getCpf(), data);
            System.out.println("Prontuário do dia "+ data + " foi removido");
        } else {
            System.out.println("Não existe prontuário para o dia: " + data);
        }
        
        menuPaciente(clinica, medico, paciente, sc);
    }
    
    public static void menuImprimirProntuarios(Clinica clinica, Medico medico, Paciente paciente, Scanner sc) {
        System.out.println("Prontuarios referentes ao paciente: " + paciente.getNome());
        if(!paciente.getProntuarios().isEmpty())
            paciente.imprimirProntuarios();
        else 
            System.out.println("Nenhum prontuário cadastrado\n");
        
        menuPaciente(clinica, medico, paciente, sc);
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
        System.out.println("(1) Pacientes");
        System.out.println("(2) Consultas");
        System.out.println("(3) Gerar relatório de consulta");
        System.out.println("(4) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuGerenciamentoPacientes(clinica, sc);
            case 2 -> menuGerenciamentoConsultas(clinica, sc);
            case 3 -> menuRelatorioConsultas(clinica, sc);
            case 4 -> menu(clinica, sc, c);
            default -> menuSecretaria(clinica, sc);
        }
    }
    
    public static void menuGerenciamentoPacientes(Clinica clinica, Scanner sc) {
        System.out.println("Selecione uma das operações");
        System.out.println("(1) Cadastrar paciente");
        System.out.println("(2) Atualizar paciente");
        System.out.println("(3) Remover paciente");
        System.out.println("(4) Imprimir pacientes");
        System.out.println("(5) Voltar");
        byte c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuCadastroPaciente(clinica, sc);
            case 2 -> menuAtualizaPaciente(clinica, sc);
            case 3 -> menuRemovePaciente(clinica, sc);
            case 4 -> menuImprimirPacientes(clinica, sc);
            case 5 -> menuSecretaria(clinica, sc);
            default -> menuGerenciamentoPacientes(clinica, sc);
        }
    }
    
    public static void menuGerenciamentoConsultas(Clinica clinica, Scanner sc) {
        System.out.println("Selecione uma das operações");
        System.out.println("(1) Cadastrar consulta");
        System.out.println("(2) Atualizar consulta");
        System.out.println("(3) Remover consulta");
        System.out.println("(4) Imprimir consultas");
        System.out.println("(5) Voltar");
        byte c;
        c = sc.nextByte();
        System.out.println();
        switch (c){
            case 1 -> menuCadastroConsulta(clinica, sc);
            case 2 -> menuAtualizaConsulta(clinica, sc);
            case 3 -> menuRemoveConsulta(clinica, sc);
            case 4 -> menuImprimirConsultas(clinica, sc);
            case 5 -> menuSecretaria(clinica, sc);
            default -> menuGerenciamentoConsultas(clinica, sc);
        }
    }
    public static void menuCadastroPaciente(Clinica clinica, Scanner sc) {
        System.out.print("Digite o nome: ");
        String nome = sc.next();
        System.out.print("Digite o cpf: ");
        String cpf = sc.next();
        System.out.print("Digite a data de nascimento: ");
        String dataNasc = sc.next();
        System.out.print("Digite o endereço: ");
        String endereco = sc.next();
        System.out.print("Digite o email: ");
        String email = sc.next();
        System.out.print("Digite o telefone: ");
        String sms = sc.next();
        System.out.print("Digite o convênio (PLANO ou PARTICULAR): ");
        String convenio = sc.next();
         
        if (convenio.toUpperCase().equals(TipoConvenio.PLANO.toString())) {
            clinica.getSecretaria().cadastraPaciente(cpf, nome, dataNasc, endereco, trataVazio(email), trataVazio(sms), TipoConvenio.PLANO);
        }else if (convenio.toUpperCase().equals(TipoConvenio.PARTICULAR.toString())) {
            clinica.getSecretaria().cadastraPaciente(cpf, nome, dataNasc, endereco, trataVazio(email), trataVazio(sms), TipoConvenio.PARTICULAR);
        } else {
            System.out.println("Erro no cadastro");
        }
        
        menuGerenciamentoPacientes(clinica, sc);
    }
    
    public static void menuAtualizaPaciente(Clinica clinica, Scanner sc) {
        System.out.println("Digite o cpf do paciente: ");
        String cpf = sc.next();
        Paciente paciente = Buscas.buscaPaciente(clinica.getSecretaria().getPacientes(), cpf);
        if (paciente != null) {
            System.out.println("Digite os novos dados: ");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Endereço: ");
            String endereco = sc.next();
            System.out.print("Email: ");
            String email = sc.next();
            System.out.print("Telefone: ");
            String sms = sc.next();
            System.out.print("Convênio: ");
            String convenio = sc.next();
            
            if (convenio.toUpperCase().equals(TipoConvenio.PLANO.toString())) {
                clinica.getSecretaria().atualizaPaciente(cpf, nome, endereco, trataVazio(email), trataVazio(sms), TipoConvenio.PLANO);
            } else if (convenio.toUpperCase().equals(TipoConvenio.PARTICULAR.toString())) {
                clinica.getSecretaria().atualizaPaciente(cpf, nome, endereco, trataVazio(email), trataVazio(sms), TipoConvenio.PARTICULAR);
            } else {
                System.out.println("Erro no cadastro");
            }
            
        } else {
            System.out.println("Paciente não encontrado");
        }
        
        menuSecretaria(clinica, sc);
    }
    
    public static void menuRemovePaciente(Clinica clinica, Scanner sc) {
        System.out.println("Digite o cpf do paciente: ");
        String cpf = sc.next();
        Paciente paciente = Buscas.buscaPaciente(clinica.getSecretaria().getPacientes(), cpf);
        if (paciente != null) {
            clinica.getSecretaria().removePaciente(cpf);
        } else {
            System.out.println("Paciente não encontrado");
        }
        
        menuSecretaria(clinica, sc);

    }
    
    public static void menuImprimirPacientes(Clinica clinica, Scanner sc) {
        System.out.println("Pacientes da clinica:");
        clinica.imprimirSecretariaPacientes();

        System.out.println();
        menuGerenciamentoPacientes(clinica, sc);
    }
    
    public static void menuCadastroConsulta(Clinica clinica, Scanner sc) {
        System.out.print("Digite a data: ");
        String data = sc.next();
        System.out.print("Digite o horario: ");
        String horario = sc.next();
        System.out.print("Digite o cpf do paciente: ");
        String cpf = sc.next();
        System.out.print("Digite o crm do médico: ");
        String crm = sc.next();
        System.out.print("Digite o tipo da consulta: ");
        String tipoConsulta = sc.next();
        
        if (tipoConsulta.toUpperCase().equals(TipoConsulta.NORMAL.toString())) {
            clinica.getSecretaria().cadastraConsulta(data, horario, crm, cpf, TipoConsulta.NORMAL, clinica.getMedicos());
        }else if (tipoConsulta.toUpperCase().equals(TipoConsulta.RETORNO.toString())) {
            clinica.getSecretaria().cadastraConsulta(data, horario, crm, cpf, TipoConsulta.RETORNO, clinica.getMedicos());
        } else {
            System.out.println("Erro no cadastro");
        }
        System.out.println();
        menuSecretaria(clinica, sc);
    }
    
    public static void menuAtualizaConsulta(Clinica clinica, Scanner sc) {
        System.out.println("Digite os dados para buscar a consulta: ");
        System.out.print("Digite a data da consulta: ");
        String data = sc.next();
        System.out.print("Digite o horario da consulta: ");
        String horario = sc.next();
        System.out.print("Digite o crm do médico: ");
        String crm = sc.next();
        
        System.out.println();
        System.out.println("Digite os dados para atualizar a consulta: ");
        System.out.print("Digite a data: ");
        String dataNova = sc.next();
        System.out.print("Digite o horario: ");
        String horarioNovo = sc.next();
        System.out.print("Digite o tipo da consulta: ");
        String tipoConsulta = sc.next();

        
        if (tipoConsulta.toUpperCase().equals(TipoConsulta.NORMAL.toString())) {
            clinica.getSecretaria().atualizaConsulta(crm, data, horario, dataNova, horarioNovo, TipoConsulta.NORMAL);
        } else if (tipoConsulta.toUpperCase().equals(TipoConsulta.RETORNO.toString())) {
            clinica.getSecretaria().atualizaConsulta(crm, data, horario, dataNova, horarioNovo, TipoConsulta.RETORNO);
        } else {
            System.out.println("Erro na atualização");
        }
        
        System.out.println();
        menuSecretaria(clinica, sc);
    }
    
    public static void menuRemoveConsulta(Clinica clinica, Scanner sc) {
        System.out.println("Digite os dados para buscar a consulta: ");
        System.out.print("Digite a data da consulta: ");
        String data = sc.next();
        System.out.print("Digite o horario da consulta: ");
        String horario = sc.next();
        System.out.print("Digite o crm do médico: ");
        String crm = sc.next();
        
        clinica.getSecretaria().removeConsulta(crm, data, horario);
        System.out.println("\nConsulta Removida\n");
        menuSecretaria(clinica, sc);
    
    }
 
    public static void menuImprimirConsultas(Clinica clinica, Scanner sc) {
        System.out.println("Consultas da clinica:");
        clinica.imprimirSecretariaConsultas();
        
        System.out.println();
        menuGerenciamentoConsultas(clinica, sc);
    }
    
    public static void menuRelatorioConsultas(Clinica clinica, Scanner sc) {
        System.out.println("Insira a data: ");
        String data = sc.next();
        System.out.println("Consultas relativas ao dia seguinte: ");
        
        clinica.getSecretaria().gerarRelatorioConsulta(data);
        
        
        System.out.println();
        menuSecretaria(clinica, sc);
    }
    
    public static void menuGerenciadorMensagem(Clinica clinica, Scanner sc, byte c) {
        System.out.println("Digite a data atual: ");
        String data = sc.next();
        System.out.println("Enviando emails aos pacientes...");
        clinica.getGerenciador().enviarEmail(data);
        System.out.println("\nEnviando Sms aos pacientes...");
        clinica.getGerenciador().enviarSMS(data);

        System.out.println();
        menu(clinica, sc, c);
    }
    
    public static void menuCadastrarMedico(Clinica clinica, Scanner sc, byte c) {
        System.out.println("Cadastro de novo médico: ");
        System.out.print("Nome: ");
        String nome = sc.next();
        System.out.print("Crm: ");
        String crm = sc.next();
        System.out.print("Especialidade: ");
        String especialidade = sc.next();
        clinica.cadastraMedico(crm, nome, especialidade);
        
        System.out.println();
        menu(clinica, sc, c);
    }
    
    public static void menuImprimirMedicos(Clinica clinica, Scanner scanner, byte c) {
        System.out.println("Médicos da clinica "+ clinica.getNome());
        clinica.imprimirMedicos();
        
        menu(clinica, scanner, c);
    }
    
    //método para teste e retorno de strings vazias
    public static String trataVazio(String str){
        if(str.isEmpty()){
            return null;
        }else{
            return str;
        }
    }
}
