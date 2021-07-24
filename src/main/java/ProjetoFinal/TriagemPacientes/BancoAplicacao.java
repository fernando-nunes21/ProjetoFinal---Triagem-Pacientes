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

    public Acompanhante getAcompanhante(Integer CPF) throws EscortNotFound {
        for (Acompanhante acompanhante : acompanhantes) {
            if (acompanhante.getCpf() == CPF) {
                return acompanhante;
            }
        }
        throw new EscortNotFound("Não encontrado acompanhante com este CPF");
    }

    public Acompanhante getAcompanhante(Paciente paciente) throws EscortNotFound {
        for (Acompanhante acompanhante : acompanhantes) {
            if (acompanhante.getPacienteAssociado().getCpf() == paciente.getCpf()) {
                return acompanhante;
            }
        }
        throw new EscortNotFound("Não encontrado acompanhante com este CPF");
    }
}
