package ProjetoFinal.TriagemPacientes.Servicos;

import ProjetoFinal.TriagemPacientes.Erros.RespostaIncorreta;
import ProjetoFinal.TriagemPacientes.Pessoas.Paciente;

public interface TriagemInterface {
    void realizarTriagem(Paciente paciente) throws RespostaIncorreta;
}
