package ProjetoFinal.TriagemPacientes.Servicos;

import ProjetoFinal.TriagemPacientes.Erros.AcompanhanteMenorIdade;
import ProjetoFinal.TriagemPacientes.Erros.ErroCPFJaCadastrado;
import ProjetoFinal.TriagemPacientes.Pessoas.Acompanhante;
import ProjetoFinal.TriagemPacientes.Pessoas.Paciente;

import java.text.ParseException;
import java.util.Date;

public interface CadastrosInterface {
    Paciente cadastroPaciente() throws ParseException, ErroCPFJaCadastrado;
    Acompanhante cadastroAcompanhante(Paciente paciente) throws ParseException, ErroCPFJaCadastrado, AcompanhanteMenorIdade;
    boolean verificaMenorIdade(Date dataNascimento);
}
