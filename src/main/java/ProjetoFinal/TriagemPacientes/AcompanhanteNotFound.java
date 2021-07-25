package ProjetoFinal.TriagemPacientes;

public class AcompanhanteNotFound extends Throwable{
    private String message;
    
    AcompanhanteNotFound(String message){
        this.message = message;
    }
}
