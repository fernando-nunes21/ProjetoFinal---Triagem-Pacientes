package ProjetoFinal.TriagemPacientes.Servicos;

import ProjetoFinal.TriagemPacientes.Erros.RespostaIncorreta;
import ProjetoFinal.TriagemPacientes.Pessoas.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicoTriagem implements TriagemInterface{
    
    private ArrayList<String> sintomasCovid = new ArrayList<>();
    
    public void realizarTriagem(Paciente paciente) throws RespostaIncorreta {
        ArrayList<String> respostas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Area de Triagem");
        System.out.println("Por favor, responda o questionario com sim ou nao: ");
        System.out.println(paciente.getNome()+" sente falta de ar?");
        respostas.add(scanner.next().toLowerCase());
        System.out.println(paciente.getNome()+" sente dor de cabeca?");
        respostas.add(scanner.next().toLowerCase());
        System.out.println(paciente.getNome()+" sente tosse?");
        respostas.add(scanner.next().toLowerCase());
        System.out.println(paciente.getNome()+" sente dor de garganta?");
        respostas.add(scanner.next().toLowerCase());
        System.out.println(paciente.getNome()+" teve febre alta?");
        respostas.add(scanner.next().toLowerCase());
        validarRespostas(respostas);
        validarTriagem();
        
    }   
    
    private void validarRespostas(ArrayList<String> respostas) throws RespostaIncorreta {
        for(String resposta : respostas){
            if(resposta.equals("sim")){
                sintomasCovid.add(resposta);
            }
            else if(!resposta.equals("nao")){
                throw new RespostaIncorreta("Conteudo da resposta nao corresponde a sim ou nao. ->" +
                        " Mensagem : "+resposta);
            }
        }
    }
    
    private void validarTriagem(){
        if(sintomasCovid.size()>2){
            System.out.println("PROCURE ATENDIMENTO ESPECIALIZADO");
        } else{
            System.out.println("Aguarde sua chamada na sala de espera");
        }
    }
}
