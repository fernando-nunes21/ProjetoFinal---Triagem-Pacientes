package ProjetoFinal.TriagemPacientes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ServicoCadastros {

    public Paciente cadastroPaciente() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o nome do paciente:");
        String nomePaciente = scanner.next();
        System.out.println("Digite o CPF do paciente:");
        Integer cpfPaciente = scanner.nextInt();
        System.out.println("Digite a data de nascimento do paciente:");
        String dataNasc = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimentoPaciente = dateFormat.parse(dataNasc);
        System.out.println("Digite o numero do cartao sus do paciente:");
        Integer cartaoSusPaciente = scanner.nextInt();
        ArrayList<String> comorbidades = cadastrarComorbidades(scanner);
        Paciente paciente = new Paciente(nomePaciente,
                cpfPaciente,
                dataNascimentoPaciente,
                cartaoSusPaciente,
                comorbidades);
        return paciente;
    }

    public Acompanhante cadastroAcompanhante(Paciente paciente) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o nome do Acompanhante:");
        String nomeAcompanhante = scanner.next();
        System.out.println("Digite a relacao de parentesco com paciente: ");
        String relacaoParentesco = scanner.next();
        System.out.println("Digite o CPF do Acompanhante:");
        Integer cpfAcompanhante = scanner.nextInt();
        System.out.println("Digite a data de nascimento do Acompanhante:");
        String dataNasc = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimentoAcompanhante = dateFormat.parse(dataNasc);
        Acompanhante acompanhante = new Acompanhante(
                nomeAcompanhante,
                cpfAcompanhante,
                dataNascimentoAcompanhante,
                relacaoParentesco,
                paciente
        );
        return acompanhante;
    }

    public boolean pacienteMenorIdade(Paciente paciente) {
        int anoNascimento = paciente.dataNascimento.getYear() + 1900;
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int idadePaciente = anoAtual - anoNascimento;
        return idadePaciente < 18;
    }

    private ArrayList<String> cadastrarComorbidades(Scanner scanner) {
        Integer controleCadastro;
        ArrayList<String> comorbidades = new ArrayList<>();
        System.out.println(
                "Deseja cadastrar comorbidades do paciente? 1 - Sim, 0 - Nao");
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
