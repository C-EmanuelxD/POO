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
            System.out.println("Paciente cadastrado com sucesso");
            return;
        }
        System.out.println("Campo cpf vazio");
    }
    
    public void atualizaPaciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        Paciente atualizaPaciente = Buscas.buscaPaciente(pacientes, cpf);
        if (atualizaPaciente != null) {
            atualizaPaciente.setNome(nome);
            atualizaPaciente.setDataNascimento(dataNascimento);
            atualizaPaciente.setEndereco(endereco);
            atualizaPaciente.setEmail(email);
            atualizaPaciente.setSms(sms);
            atualizaPaciente.setTipoConvenio(tipoConvenio);
            System.out.println("Paciente atualizado com sucesso");
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
            medico.setPaciente(paciente);
            System.out.println("Consulta cadastrada com sucesso");
            return;
        }
        System.out.println("Paciente e/ou Médico não encontrado");
    }
    
    public void atualizaConsulta(String cpf, String data, String horario, TipoConsulta tipoConsulta) {
        Consulta atualizarConsulta = Buscas.buscaConsulta(consultas, cpf);
        if (atualizarConsulta != null) {
            atualizarConsulta.setData(data);
            atualizarConsulta.setHorario(horario);
            atualizarConsulta.setTipoConsulta(tipoConsulta);
            return;
        }
        System.out.println("Consulta não encontrada");
    }
    
    public void removeConsulta(String cpf) {
        Consulta consultaRemovida = Buscas.buscaConsulta(consultas, cpf);
        if (consultaRemovida != null) {
            consultas.remove(consultaRemovida);
            return;
        }
        System.out.println("Consulta não encontrada");
    }
}
