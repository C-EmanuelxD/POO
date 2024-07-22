package clinica.secretaria;

import java.util.ArrayList;
import clinica.pessoas.Medico;
import clinica.pessoas.Paciente;
import clinica.tipos.TipoConsulta;
import clinica.tipos.TipoConvenio;
import java.util.List;

public class Secretaria {
    private String nome;
    private List<Paciente> pacientes;
    private List<Consulta> consultas;
    private List<Medico> medicos;

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

    public List<Consulta> getConsulta() {
        return consultas;
    }

    public void setConsulta(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    public List<Medico> getMedicos() {
        return medicos;
    }
    
    public Paciente buscaPaciente(String cpf) {
        for(Paciente x : pacientes) {
            if(x.getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }
    
    public Medico buscaMedico(String crm) {
        for(Medico x : medicos) {
            if(x.getCrm().equals(crm)) {
                return x;
            }
        }
        return null;
    }
    
    public Consulta buscaConsulta(String cpf) {
        for(Consulta x : consultas) {
            if(x.getPaciente().getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }

    public void cadastraPaciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        Paciente novoPaciente = new Paciente(cpf, nome, dataNascimento, endereco, email, sms, tipoConvenio);
        pacientes.add(novoPaciente);
    }
    
    public void atualizaPaciente(String cpf, String nome, String dataNascimento, String endereco, String email, String sms, TipoConvenio tipoConvenio) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                paciente.setNome(nome);
                paciente.setDataNascimento(dataNascimento);
                paciente.setEndereco(endereco);
                paciente.setEmail(email);
                paciente.setSms(sms);
                paciente.setTipoConvenio(tipoConvenio);
                System.out.println("Paciente atualizado com sucesso.");
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }
    

    public void removePaciente(String cpf) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(cpf)) {
                pacientes.remove(paciente);
                return;
            }
        }
        System.out.println("Paciente não encontrado.");
    }
    
    public void cadastraConsulta(String data, String horario, String crm, String cpf, TipoConsulta tipoConsulta) {
        Paciente paciente = buscaPaciente(cpf);
        Medico medico = buscaMedico(crm);
        Consulta novaConsulta = new Consulta(data, horario, medico, paciente, tipoConsulta);
        consultas.add(novaConsulta);
    }
    
    public void atualizaConsulta(String cpf, String data, String horario, TipoConsulta tipoConsulta) {
        for(Consulta x : consultas) {
            if(x.getPaciente().getCpf().equals(cpf)) {
                x.setData(data);
                x.setHorario(horario);
                x.setTipoConsulta(tipoConsulta);
            }
        }
    }
    
    public void removeConsulta(String cpf) {
        Consulta consultaRemovida = buscaConsulta(cpf);
        consultas.remove(consultaRemovida);
    }
}
