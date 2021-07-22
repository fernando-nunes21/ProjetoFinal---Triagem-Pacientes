package ProjetoFinal.TriagemPacientes;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BancoAplicacao bancoAplicacao = new BancoAplicacao();
        Integer menuInput;
        do {
        exibirMenu();
        menuInput = scanner.nextInt();
        opcoesMenu(menuInput);
        } while(menuInput != 4);
    }
    
    private static void exibirMenu(){
        System.out.println("------------------------------------------");
        System.out.println("|       Triagem de Pacientes v1.0        |");
        System.out.println("|----------------------------------------|");
        System.out.println("| Digite 1 - Para registrar Paciente|    |");
        System.out.println("| Digite 2 - Para registrar Acompanhante |");
        System.out.println("| Digite 3 - Para realizar Triagem       |");
        System.out.println("| Digite 4 - Para Sair                   |");
        System.out.println("------------------------------------------");
    }
    
    private static void opcoesMenu(Integer opcao){
        switch(opcao){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                System.out.println("Finalizando...");
                break;
            default:
                System.out.println("Opcao invalida, Reiniciando...");
                break;
        }
    }
    
}
