package ProjetoFinal.TriagemPacientes;

import java.util.Date;

public class Acompanhante extends Pessoa {

    private String parentescoPaciente;
    private Paciente pacienteAssociado;

    public Acompanhante(String nome, Integer cpf, Date dataNascimento,
            String parentescoPaciente, Paciente pacienteAssociado) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.parentescoPaciente = parentescoPaciente;
        this.pacienteAssociado = pacienteAssociado;
    }

    public String getParentescoPaciente() {
        return parentescoPaciente;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public String getNome() {
        return nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

}
