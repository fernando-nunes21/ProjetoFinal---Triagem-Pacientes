package ProjetoFinal.TriagemPacientes;

import java.util.ArrayList;
import java.util.Scanner;

public class ServicoTriagem {
    
    private ArrayList<String> sintomasCovid = new ArrayList<>();
    
    public void realizarTriagem(Paciente paciente){
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
    
    private void validarRespostas(ArrayList<String> respostas){
        for(String resposta : respostas){
            if(resposta.equals("sim")){
                sintomasCovid.add(resposta);
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
