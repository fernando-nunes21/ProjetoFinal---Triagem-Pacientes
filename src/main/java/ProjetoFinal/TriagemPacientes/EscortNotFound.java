package ProjetoFinal.TriagemPacientes;

public class EscortNotFound extends Throwable{
    private String message;
    
    EscortNotFound(String message){
        this.message = message;
    }
}
