import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome = "Alex Ramos Ribeiro";
        String tipoDeConta = "Conta Corrente";
        int agencia = 1;
        int conta = 5403;
        int digito = 8;
        double saldo = 2000;
        double valorDaOperacao;
        int opcao = 0;

        String dadosDoCliente = """
                ----------------------------------------
                DADOS DO CLIENTE:
                Nome: %s
                Tipo de Conta: %s
                Agência: %04d   Número da conta: %05d-%d
                Saldo atual: R$ %.2f
                ----------------------------------------"""
                .formatted(nome, tipoDeConta, agencia, conta, digito, saldo);

        String operacoes = """
                OPERAÇÕES DISPONÍVEIS:
                [1] Consultar o Saldo
                [2] Depositar dinheiro
                [3] Sacar dinheiro
                [4] Sair
                Digite a opção desejada: """;

        System.out.println(dadosDoCliente);

        while (opcao != 4) {
            System.out.println(operacoes);
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("CONSULTA DO SALDO");
                    System.out.println(String.format("O saldo disponível é de: R$ %.2f.",saldo));
                    break;
                case 2:
                    System.out.println("DEPÓSITO");
                    System.out.println("Digite o valor: ");
                    valorDaOperacao = sc.nextDouble();
                    if (valorDaOperacao > 0) {
                        saldo += valorDaOperacao;
                        System.out.println(String.format("Operação realizada! O novo saldo disponível é de: R$ %.2f", saldo));
                    } else {
                        System.out.println("Valor da operação inválido!");
                    }
                    break;
                case 3:
                    System.out.println("SAQUE");
                    System.out.println("Digite o valor: ");
                    valorDaOperacao = sc.nextDouble();
                    if (valorDaOperacao <= saldo && valorDaOperacao > 0) {
                        saldo -= valorDaOperacao;
                        System.out.println(String.format("Operação realizada! O novo saldo disponível é de: R$ %.2f.",saldo));
                    } else if (valorDaOperacao <= 0) {
                        System.out.println("Valor da operação inválido!");
                    } else {
                        System.out.println("Não foi possível fazer o saque. Saldo insuficiente.");
                    }
                    break;
                case 4:
                    System.out.println("Obrigado por utilizar nossos serviços. Até breve!");
                    break;
                default:
                    System.out.println("Digite uma opção válida!");
            }
        }
    }
}