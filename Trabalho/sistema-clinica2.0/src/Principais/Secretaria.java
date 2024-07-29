package Principais;
//GERENCIAR PACIENTES E CONSULTA FEITO
import Auxiliares.Buscas;
import java.util.ArrayList;
import clinica.tipos.TipoConsulta;
import clinica.tipos.TipoConvenio;
import java.util.List;

public class Secretaria {
    private String nome;
    private List<Paciente> pacientes;
    private List<Consulta> consultas;

    public Secretaria(String nome) {
        this.nome = nome;
        pacientes = new ArrayList<>();
        consultas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Paciente> getPacientes() {
        return new ArrayList<>(pacientes);
    }

    public void setPacientes(Paciente paciente) {
        pacientes.add(paciente);
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public void cadastraPaciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        Paciente novoPaciente = new Paciente(cpf, nome, dataNascimento, endereco, email, sms, tipoConvenio);
        if (cpf != null) {
            pacientes.add(novoPaciente);
            //System.out.println("Paciente cadastrado com sucesso");
            return;
        }
        System.out.println("Campo cpf vazio");
    }
    
    public void atualizaPaciente(String cpf, String nome, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        Paciente atualizaPaciente = Buscas.buscaPaciente(pacientes, cpf);
        int index = pacientes.indexOf(atualizaPaciente);
        if (index != -1) {
            pacientes.get(index).setNome(nome);
            pacientes.get(index).setEndereco(endereco);
            pacientes.get(index).setEmail(email);
            pacientes.get(index).setSms(sms);
            pacientes.get(index).setTipoConvenio(tipoConvenio);
            //System.out.println("Paciente atualizado com sucesso");
            return;
         }
        System.out.println("Paciente não encontrado");
    }

    public void removePaciente(String cpf) {
        Paciente removerPaciente = Buscas.buscaPaciente(pacientes, cpf);
        if (removerPaciente != null) {
            pacientes.remove(removerPaciente);
            return;
        }
        System.out.println("Paciente não encontrado");
    }
    
    public void cadastraConsulta(String data, String horario, String crm, String cpf, TipoConsulta tipoConsulta, List<Medico> medicos) {
        Paciente paciente = Buscas.buscaPaciente(pacientes, cpf);
        Medico medico = Buscas.buscaMedico(medicos, crm);
        
        if (paciente != null && medico != null) {
            Consulta novaConsulta = new Consulta(data, horario, medico, paciente, tipoConsulta);
            consultas.add(novaConsulta);
            medico.setConsulta(novaConsulta);
            //System.out.println("Consulta cadastrada com sucesso");
            return;
        }
        System.out.println("Paciente e/ou Médico não encontrado");
    }
    
    public void atualizaConsulta(String crm, String data, String horario, String dataNova, String horarioNovo, TipoConsulta tipoConsulta) {
        Consulta atualizarConsulta = Buscas.buscaConsulta(consultas, crm, data, horario);
        int index = consultas.indexOf(atualizarConsulta);
        if (index != -1) {
            consultas.get(index).setData(dataNova);
            consultas.get(index).setHorario(horarioNovo);
            consultas.get(index).setTipoConsulta(tipoConsulta);
            return;
        }
        System.out.println("Consulta não encontrada");
    }
    
    public void removeConsulta(String crm, String data, String horario) {
        Consulta consultaRemovida = Buscas.buscaConsulta(consultas, crm, data, horario);
        if (consultaRemovida != null) {
            consultas.remove(consultaRemovida);
            consultaRemovida.getMedico().getConsulta().remove(consultaRemovida);
            return;
        }
        System.out.println("Consulta não encontrada");
    }
    
    public List<Consulta> consultasDiaSeguinte(String dataAtual) {
        String[] partes = dataAtual.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);
        
        if (dia == 31){
            mes += 1;
            dia = 1;
        } else if (mes == 12 && dia == 31) {
            ano += 1;
            mes = 1;
        } else {
            dia+=1;
        }
                
        String prox_dia = String.format("%02d/%02d/%d", dia, mes, ano);
        List<Consulta> consultasDiaSeguinte = new ArrayList<>();
        
        // Adiciona as consultas dos pacientes que tem email ou celular
        for(Consulta x : consultas) {
            if (x.getData().equals(prox_dia)){
                if (x.getPaciente().getEmail() != null || x.getPaciente().getSms() != null)
                consultasDiaSeguinte.add(x);
            }
        }
        
        // Adiciona as consultas dos pacientes que nao tem email e celular
        for(Consulta x : consultas) {
            if (x.getData().equals(prox_dia)){
                if (x.getPaciente().getEmail() == null && x.getPaciente().getSms() == null)
                consultasDiaSeguinte.add(x);
            }
        }
        
        return consultasDiaSeguinte;
    }
    
    public void gerarRelatorioConsulta(String dataAtual){
        List<Consulta> consultasDiaSeguinte = this.consultasDiaSeguinte(dataAtual);
        for(Consulta x : consultasDiaSeguinte) {
            x.imprimirConsulta();
            System.out.println();
        }
    }     
}      

    


