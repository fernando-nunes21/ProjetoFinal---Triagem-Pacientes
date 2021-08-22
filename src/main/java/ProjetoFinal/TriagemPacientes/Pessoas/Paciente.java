package ProjetoFinal.TriagemPacientes.Pessoas;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Pessoa{
    private Integer cartaoSus;
    private ArrayList<String> comorbidades;

    public Paciente(String nome, String cpf, Date dataNascimento,
            Integer cartaoSus, ArrayList<String> comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cartaoSus = cartaoSus;
        this.comorbidades = comorbidades;
    }

    public ArrayList<String> getComorbidades() {
        return comorbidades;
    }

    public String getNome() {
        return nome.toUpperCase();
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }
}
