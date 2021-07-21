package ProjetoFinal.TriagemPacientes;

import java.util.Date;

public class Paciente extends Pessoa{
    private Integer cartaoSus;
    private String[] comorbidades;

    public Paciente(String nome, Integer cpf, Date dataNascimento, 
            Integer cartaoSus, String[] comorbidades) {
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

    public String[] getComorbidades() {
        return comorbidades;
    }

    public void setComorbidades(String[] comorbidades) {
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
