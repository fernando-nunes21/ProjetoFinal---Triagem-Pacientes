package ProjetoFinal.TriagemPacientes;

public class PacientNotFound extends Throwable {
    private String message;
    
    PacientNotFound(String message){
        this.message = message;
    }
}
