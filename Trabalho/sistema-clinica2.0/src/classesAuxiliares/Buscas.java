/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classesAuxiliares;

import dadosPessoas.Prontuario;
import atoresSecundários.Consulta;
import atoresPrincipais.Medico;
import atoresSecundários.Paciente;
import java.util.List;

/**
 *
 * @author Emanuel
 */
//Classe especifica para métodos de busca
public class Buscas {
    
    public static Paciente buscaPaciente(List<Paciente> pacientes, String cpf) {
        for(Paciente x : pacientes) {
            if(x.getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }
    
    public static Medico buscaMedico(List<Medico> medicos, String crm) {
        for(Medico x : medicos) {
            if(x.getCrm().equals(crm)) {
                return x;
            }
        }
        return null;
    }
    
    public static Consulta buscaConsulta(List<Consulta> consultas, String crm, String data, String horario) {
        for(Consulta x : consultas) {
            if(x.getMedico().getCrm().equals(crm) && x.getData().equals(data) && x.getHorario().equals(horario)) {
                return x;
            }
        }
        return null;
    }
    
    public static Consulta buscaConsulta(List<Consulta> consultas, String cpf) {
        for(Consulta x : consultas) {
            if(x.getPaciente().getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }
    
    
    public static Prontuario buscaProntuario(List<Prontuario> prontuarios, String data){
        for(Prontuario x : prontuarios){
            if(x.getData().equals(data)){
                return x;
            }
        }
        return null;
    }
    
    public static Paciente buscaPacienteConsulta(List<Consulta> consultas, String cpf){
        for(Consulta x : consultas) {
            if(x.getPaciente().getCpf().equals(cpf)) {
                Paciente y = x.getPaciente();
                return y;
            }
            
        }
        return null;
    }
    
    
    
}
