package ProjetoFinal.TriagemPacientes;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BancoAplicacao {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Acompanhante> acompanhante = new ArrayList<>();

    public void cadastroPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o nome do paciente:");
        String nomePaciente = scanner.next();
        System.out.println("Digite o CPF do paciente:");
        Integer cpfPaciente = scanner.nextInt();
        System.out.println("Digite a data de nascimento do paciente:");
        String dataNasc = scanner.next();
        DateFormat dataNascPaciente = DateFormat.getInstance();
        try {
            Date dataNascimentoPaciente = dataNascPaciente.parse(dataNasc);
            System.out.println("Digite o numero do cartao sus do paciente:");
            Integer cartaoSusPaciente = scanner.nextInt();
            ArrayList<String> comorbidades = cadastrarComorbidades(scanner);
            Paciente paciente = new Paciente(nomePaciente,
                    cpfPaciente,
                    dataNascimentoPaciente,
                    cartaoSusPaciente,
                    comorbidades);
            pacientes.add(paciente);
        } catch (ParseException error) {
            System.out.println(error.getMessage());
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }

    private ArrayList<String> cadastrarComorbidades(Scanner scanner) {
        Integer controleCadastro = 0;
        ArrayList<String> comorbidades = new ArrayList<>();
        System.out.println(
                "Deseja cadastrar comorbidades do paciente? 1 - Sim, 0 - Não");
        controleCadastro = scanner.nextInt();
        while (controleCadastro == 1) {
            System.out.println("Descreva a comorbidade: ");
            String descricaoComorbidade = scanner.next();
            comorbidades.add(descricaoComorbidade);
            System.out.println(
                    "Deseja continuar cadastrando comorbidades do paciente? "
                    + "1 - Sim, 0 - Não");
            controleCadastro = scanner.nextInt();
        }
        return comorbidades;
    }
}
