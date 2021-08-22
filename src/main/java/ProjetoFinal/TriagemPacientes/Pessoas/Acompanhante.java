package ProjetoFinal.TriagemPacientes.Pessoas;

import java.util.Date;

public class Acompanhante extends Pessoa {

    private String parentescoPaciente;
    private Paciente pacienteAssociado;

    public Acompanhante(String nome, String cpf, Date dataNascimento,
            String parentescoPaciente, Paciente pacienteAssociado) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.parentescoPaciente = parentescoPaciente;
        this.pacienteAssociado = pacienteAssociado;
    }

    public Paciente getPacienteAssociado() {
        return pacienteAssociado;
    }

    public String getNome() {
        return nome.toLowerCase();
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

}
