package ProjetoFinal.TriagemPacientes;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    private static BancoAplicacao bancoAplicacao = new BancoAplicacao();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ServicoCadastros servicoCadastros = new ServicoCadastros();
        BancoAplicacao bancoAplicacao = new BancoAplicacao();
        Integer menuInput;
        do {
            exibirMenu();
            menuInput = scanner.nextInt();
            opcoesMenu(menuInput, servicoCadastros);
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

    private static void opcoesMenu(Integer opcao, ServicoCadastros cadastro) {
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
