package ProjetoFinal.TriagemPacientes;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static BancoAplicacao bancoAplicacao = new BancoAplicacao();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoCadastros servicoCadastros = new ServicoCadastros();
        ServicoTriagem servicoTriagem = new ServicoTriagem();
        Integer menuInput;
        do {
            exibirMenu();
            menuInput = scanner.nextInt();
            opcoesMenu(menuInput, servicoCadastros, servicoTriagem);
        } while (menuInput != 3);
    }

    private static void exibirMenu() {
        System.out.println("------------------------------------------");
        System.out.println("|       Triagem de Pacientes v1.0        |");
        System.out.println("|----------------------------------------|");
        System.out.println("| Digite 1 - Para registrar Paciente|    |");
        System.out.println("| Digite 2 - Para realizar Triagem       |");
        System.out.println("| Digite 3 - Para Sair                   |");
        System.out.println("------------------------------------------");
    }
    
    private static void menuTriagem(){
        System.out.println("------------------------------------------");
        System.out.println("|       Triagem de Pacientes v1.0        |");
        System.out.println("|----------------------------------------|");
        System.out.println("| Digite o codigo do paciente que deseja |");
        System.out.println("| Realizar a triagem:                    |");
        ArrayList<Paciente> pacientes = bancoAplicacao.getPacientes();
        int code = 0;
        for (Paciente paciente : pacientes){
            System.out.println("Cod. -> "+code+" Paciente: "+paciente.getNome());
            code++;
        }
        if(code == 0){
            System.out.println("| Nao existem pacientes registrados |");
            System.out.println("| Digite -1 para voltar              |");
        }
        System.out.println("------------------------------------------");
    }

    private static void opcoesMenu(Integer opcao, ServicoCadastros cadastro, 
            ServicoTriagem servicoTriagem) {
        switch (opcao) {
            case 1:
                try {
                Paciente paciente = cadastro.cadastroPaciente();
                bancoAplicacao.setPaciente(paciente);
                if (cadastro.pacienteMenorIdade(paciente)
                        || paciente.getComorbidades().size() > 0) {
                    try {
                        Acompanhante acompanhante
                                = cadastro.cadastroAcompanhante(paciente);
                        bancoAplicacao.setAcompanhate(acompanhante);
                    } catch (ParseException | IllegalArgumentException error) {
                        System.out.println("Aconteceu um problema -> "+
                                error.getMessage());
                    }
                }
            } catch (ParseException | IllegalArgumentException error) {
                System.out.println("Aconteceu um problema" +error.getMessage());
            }
            break;

            case 2:
                Scanner scanner = new Scanner(System.in);
                menuTriagem();
                Integer comando = scanner.nextInt();
                if (comando != -1){
                    try{
                        Paciente paciente = bancoAplicacao.getPacienteByCode(comando);
                        servicoTriagem.realizarTriagem(paciente);
                        bancoAplicacao.removePaciente(comando);
                        System.out.println("Triagem realizada com sucesso!");
                    } catch (NullPointerException error){
                        System.out.println("Codigo digitado é nulo - > "+
                                error.getMessage());
                    }
                }
                break;
            case 3:
                System.out.println("Finalizando...");
                break;
            default:
                System.out.println("Opcao invalida, Reiniciando...");
                break;
        }
    }

}
