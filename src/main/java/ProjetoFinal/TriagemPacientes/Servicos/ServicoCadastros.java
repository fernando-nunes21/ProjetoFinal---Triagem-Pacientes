package ProjetoFinal.TriagemPacientes.Servicos;

import ProjetoFinal.TriagemPacientes.Aplicacao.Main;
import ProjetoFinal.TriagemPacientes.Erros.AcompanhanteMenorIdade;
import ProjetoFinal.TriagemPacientes.Erros.ErroCPFJaCadastrado;
import ProjetoFinal.TriagemPacientes.Pessoas.Acompanhante;
import ProjetoFinal.TriagemPacientes.Pessoas.Paciente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ServicoCadastros implements CadastrosInterface{

    public Paciente cadastroPaciente() throws ParseException, ErroCPFJaCadastrado {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o nome do paciente:");
        String nomePaciente = scanner.nextLine();
        System.out.println("Digite o CPF do paciente:");
        String cpfPaciente = scanner.next();
        System.out.println("Digite a data de nascimento do paciente:");
        String dataNasc = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimentoPaciente = dateFormat.parse(dataNasc);
        System.out.println("Digite o numero do cartao sus do paciente:");
        Integer cartaoSusPaciente = scanner.nextInt();
        ArrayList<String> comorbidades = cadastrarComorbidades(scanner);
        if(Main.bancoAplicacao.getPaciente(cpfPaciente) != null){
            throw new ErroCPFJaCadastrado("CPF Já consta na base de dados cadastrado");
        }
        return new Paciente(nomePaciente,
                cpfPaciente,
                dataNascimentoPaciente,
                cartaoSusPaciente,
                comorbidades);
    }

    public Acompanhante cadastroAcompanhante(Paciente paciente) throws ParseException, ErroCPFJaCadastrado, AcompanhanteMenorIdade {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, digite o nome do Acompanhante:");
        String nomeAcompanhante = scanner.next();
        System.out.println("Digite a relacao de parentesco com paciente: ");
        String relacaoParentesco = scanner.next();
        System.out.println("Digite o CPF do Acompanhante:");
        String cpfAcompanhante = scanner.next();
        System.out.println("Digite a data de nascimento do Acompanhante:");
        String dataNasc = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimentoAcompanhante = dateFormat.parse(dataNasc);
        if(verificaMenorIdade(dataNascimentoAcompanhante.getYear())){
            throw new AcompanhanteMenorIdade("Este acompanhante é menor de Idade, e isso nao é permitido");
        }
        if(Main.bancoAplicacao.getAcompanhante(cpfAcompanhante) != null){
            throw new ErroCPFJaCadastrado("CPF Já consta na base de dados cadastrado");
        }
        return new Acompanhante(
                nomeAcompanhante,
                cpfAcompanhante,
                dataNascimentoAcompanhante,
                relacaoParentesco,
                paciente
        );
    }

    public boolean verificaMenorIdade(Date dataNascimento){
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        int idadePaciente = anoAtual - (dataNascimento.getYear() + 1900);
        return idadePaciente < 18;
    }

    public boolean verificaMenorIdade(Integer anoNascimento){
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return (anoAtual - anoNascimento) < 18;
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
                    + "1 - Sim, 0 - N�o");
            controleCadastro = scanner.nextInt();
        }
        return comorbidades;
    }
}
