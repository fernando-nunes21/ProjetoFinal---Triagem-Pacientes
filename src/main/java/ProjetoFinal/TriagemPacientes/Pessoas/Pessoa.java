package ProjetoFinal.TriagemPacientes.Pessoas;

import java.util.Date;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Date dataNascimento;

    public Date getDataNascimento(){
        return this.dataNascimento;
    }

    public String getNome(){
        return this.nome;
    }
}
