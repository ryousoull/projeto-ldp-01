package model.application;
import model.entities.Despesa;
import model.entities.Movimentacao;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Movimentacao transactions;

    public static void main() {

        imprimiTexto("Bem vindo ao seu Gerenciador Financeiro!");
        double saldoInicial = lerDouble("Digite o seu saldo inicial: ");
        transactions = new Movimentacao(saldoInicial);

        int opc;

        do {
            exibirMenu();
            opc = lerInt("Escolha: ");
            sc.nextLine();

            switch (opc) {
                case 1 -> cadastroMovimentacao();
                case 2 -> transactions.listarMovimentacao();
                case 3 -> transactions.calcularSaldoTotal();
                case 4 -> removerMovimentacaoPorNome();
                case 5 -> addEntrada();
                case 0 -> imprimiTexto("Programa encerrado.");
                default -> imprimiTexto("Erro: Digite uma opção válida!");
            }
        } while (opc != 0);

        sc.close();
    }


    public static void cadastroMovimentacao() {
        if (transactions.qtdAtual >= transactions.historico.length) {
            imprimiTexto("Limite de transações atingido!");
        } else {
            double value = lerDouble("Valor: ");
            sc.nextLine();
            String desc = lerTexto("Descrição: ");

            transactions.historico[transactions.qtdAtual] = new Despesa(value, desc);
            transactions.qtdAtual++;
            transactions.saldoInicial = transactions.saldoInicial - value;
            imprimiTexto("Gasto adicionado com sucesso!");
        }
    }

    public static void removerMovimentacaoPorNome() {
        if (transactions.qtdAtual == 0) {
            System.out.println("Nenhum gasto cadastrado para remover.");
        } else {
            System.out.println("Listagem do Extrato para Ver o Nome...");
            transactions.listarMovimentacao();
            String nomeProcurado = lerTexto("Digite o nome (descrição) do gasto que deseja remover: ");

            boolean indexProcurado = false;

            for (int i = 0; i < transactions.qtdAtual; i++) {
                if (transactions.historico[i].desc.equalsIgnoreCase(nomeProcurado)) {

                    indexProcurado = true;
                    transactions.saldoInicial = transactions.saldoInicial + transactions.historico[i].value;

                    for (int j = i; j < transactions.qtdAtual - 1; j++) {
                        transactions.historico[j] = transactions.historico[j + 1];
                    }

                    transactions.historico[transactions.qtdAtual - 1] = null;
                    transactions.qtdAtual--;

                    break;
                }
            }

            if (indexProcurado) {
                System.out.println("Gasto '" + nomeProcurado + "' removido(s) com sucesso!");
            } else {
                System.out.println("Gasto '" + nomeProcurado + "' não foi encontrado.");
            }
        }
    }

    public static void addEntrada () {
        double entrada = lerDouble("Digite o Valor da Entrada: ");
        transactions.saldoInicial = transactions.saldoInicial + entrada;
        imprimiTexto("\nSaldo Atual: " + transactions.saldoInicial);
        imprimiTexto("--------------------------------");
    }

    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR FINANCEIRO ---");
        System.out.println("1. Adicionar Gasto");
        System.out.println("2. Ver Extrato");
        System.out.println("3. Calcular Gasto Total e Saldo Atual");
        System.out.println("4. Remover Gasto por Nome");
        System.out.println("5. Adicionar Entreda");
        System.out.println("0. Sair");
        System.out.println("--------------------------------");
    }

    public static double lerDouble(String msg) {
        System.out.println(msg);
        return sc.nextDouble();
    }
    public static int lerInt(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }

    public static String lerTexto(String msg) {
        System.out.println(msg);
        return sc.nextLine();
    }

    public static void imprimiTexto(String msg) {
        System.out.println(msg);
    }

}