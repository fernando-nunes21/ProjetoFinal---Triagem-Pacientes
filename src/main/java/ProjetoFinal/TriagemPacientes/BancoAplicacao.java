package ProjetoFinal.TriagemPacientes;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BancoAplicacao {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Acompanhante> acompanhantes = new ArrayList<>();

    public Paciente getPacienteByCode(Integer codigo){
        return pacientes.get(codigo);
    }
    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public ArrayList<Acompanhante> getAcompanhantes() {
        return acompanhantes;
    }

    public void setAcompanhantes(ArrayList<Acompanhante> acompanhantes) {
        this.acompanhantes = acompanhantes;
    }
    
    public void setPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public Paciente getPaciente(Integer CPF) throws PacientNotFound {
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf() == CPF) {
                return paciente;
            }
        }
        throw new PacientNotFound("Não encontrado paciente com CPF inserido");
    }

    public void setAcompanhate(Acompanhante acompanhante) {
        this.acompanhantes.add(acompanhante);
    }

    public Acompanhante getAcompanhante(Integer CPF) throws AcompanhanteNotFound {
        for (Acompanhante acompanhante : acompanhantes) {
            if (acompanhante.getCpf() == CPF) {
                return acompanhante;
            }
        }
        throw new AcompanhanteNotFound("Não encontrado acompanhante com este CPF");
    }

    public Acompanhante getAcompanhante(Paciente paciente) throws AcompanhanteNotFound {
        for (Acompanhante acompanhante : acompanhantes) {
            if (acompanhante.getPacienteAssociado().getCpf() == paciente.getCpf()) {
                return acompanhante;
            }
        }
        throw new AcompanhanteNotFound("Não encontrado acompanhante com este CPF");
    }
      
    public void removePaciente(int code){
        Paciente paciente = this.pacientes.get(code);
        Integer pacienteCpf = paciente.getCpf();
        int codeAcompanhante = -1;
        for (int i=0;i<acompanhantes.size();i++){
           if(acompanhantes.get(i).getPacienteAssociado().getCpf() == pacienteCpf){
                codeAcompanhante = i;
            } 
        }
        if(codeAcompanhante >-1){
          acompanhantes.remove(codeAcompanhante);  
        }
        pacientes.remove(code);
    }
}
