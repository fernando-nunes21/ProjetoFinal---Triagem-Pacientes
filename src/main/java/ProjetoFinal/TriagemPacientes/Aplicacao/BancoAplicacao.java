package ProjetoFinal.TriagemPacientes.Aplicacao;

import ProjetoFinal.TriagemPacientes.Pessoas.Acompanhante;
import ProjetoFinal.TriagemPacientes.Pessoas.Paciente;

import java.util.ArrayList;

public class BancoAplicacao {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Acompanhante> acompanhantes = new ArrayList<>();

    public Paciente getPacienteByCode(Integer codigo){
        return pacientes.get(codigo);
    }
    
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPaciente(Paciente paciente) {
        this.pacientes.add(paciente);
    }

    public Paciente getPaciente(String CPF){
        for (Paciente paciente : pacientes) {
            if (paciente.getCpf().equals(CPF)) {
                return paciente;
            }
        }
        return null;
    }

    public void setAcompanhate(Acompanhante acompanhante) {
        this.acompanhantes.add(acompanhante);
    }

    public Acompanhante getAcompanhante(String CPF){
        for (Acompanhante acompanhante : acompanhantes) {
            if (acompanhante.getCpf().equals(CPF)) {
                return acompanhante;
            }
        }
        return null;
    }
      
    public void removePaciente(int code){
        Paciente paciente = this.pacientes.get(code);
        String pacienteCpf = paciente.getCpf();
        int codeAcompanhante = -1;
        for (int i=0;i<acompanhantes.size();i++){
           if(acompanhantes.get(i).getPacienteAssociado().getCpf().equals(pacienteCpf)){
                codeAcompanhante = i;
            } 
        }
        if(codeAcompanhante >-1){
          acompanhantes.remove(codeAcompanhante);  
        }
        pacientes.remove(code);
    }
}
