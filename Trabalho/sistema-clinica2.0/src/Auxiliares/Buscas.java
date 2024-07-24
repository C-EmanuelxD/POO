/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Auxiliares;

import DadosPessoas.Prontuario;
import Principais.Consulta;
import Principais.Medico;
import Principais.Paciente;
import java.util.List;

/**
 *
 * @author Emanuel
 */
//Classe especifica para métodos de busca
public class Buscas {
    
    public Paciente buscaPaciente(List<Paciente> pacientes, String cpf) {
        for(Paciente x : pacientes) {
            if(x.getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }
    
    public Medico buscaMedico(List<Medico> medicos, String crm) {
        for(Medico x : medicos) {
            if(x.getCrm().equals(crm)) {
                return x;
            }
        }
        return null;
    }
    
    public Consulta buscaConsulta(List<Consulta> consultas, String cpf) {
        for(Consulta x : consultas) {
            if(x.getPaciente().getCpf().equals(cpf)) {
                return x;
            }
        }
        return null;
    }
    
    public Prontuario buscaProntuario(List<Prontuario> prontuarios, String data){
        for(Prontuario x : prontuarios){
            if(x.getData().equals(data)){
                return x;
            }
        }
        return null;
    }
    
}
