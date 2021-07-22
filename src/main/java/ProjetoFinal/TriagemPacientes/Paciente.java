package ProjetoFinal.TriagemPacientes;

import java.util.ArrayList;
import java.util.Date;

public class Paciente extends Pessoa{
    private Integer cartaoSus;
    private ArrayList<String> comorbidades;

    public Paciente(String nome, Integer cpf, Date dataNascimento, 
            Integer cartaoSus, ArrayList<String> comorbidades) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.cartaoSus = cartaoSus;
        this.comorbidades = comorbidades;
    }

    public Integer getCartaoSus() {
        return cartaoSus;
    }

    public void setCartaoSus(Integer cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public ArrayList<String> getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(ArrayList<String> comorbidades) {
        this.comorbidades = comorbidades;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
