import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Movimentacao transactions;

    public static void main(String[] args) {
        imprimiTexto("Bem vindo ao seu Gerenciador Financeiro!");
        double saldoInicial = lerDouble("Digite o seu saldo inicial: ");
        sc.nextLine();

        transactions = new Movimentacao(saldoInicial);

        int opc;

        do {
            exibirMenu();
            opc = lerInt("Escolha: ");
            sc.nextLine();

            switch (opc) {
                case 1 -> cadastrarGastoNoMenu();
                case 2 -> exibirExtratoTotalNoMenu();
                case 3 -> removerGastoNoMenu();
                case 4 -> adicionarEntradaNoMenu();
                case 0 -> imprimiTexto("Programa encerrado.");
                default -> imprimiTexto("Erro: Digite uma opção válida!");
            }
        } while (opc != 0);

        sc.close();
    }

    static void cadastrarGastoNoMenu() {
        double value = lerDouble("Valor: ");
        sc.nextLine();
        String desc = lerTexto("Descrição: ");

        if (transactions.adicionarGasto(value, desc)) {
            imprimiTexto("Gasto adicionado com sucesso!");
        } else {
            imprimiTexto("Erro: Limite de transações atingido!");
        }
    }


    static void listarMovimentacoesNoMenu() {
        imprimiTexto("\n=====================================");
        if (transactions.qtdAtual == 0) {
            imprimiTexto("Nenhuma movimentação cadastrada.");
        } else {
            for (int i = 0; i < transactions.qtdAtual; i++) {
                imprimiTexto(transactions.historico[i].toString());
            }
        }
    }


    static void exibirExtratoTotalNoMenu() {

        listarMovimentacoesNoMenu();

        double totalGastos = transactions.obterTotalGastos();
        double saldoAtual = transactions.obterSaldoAtual();

        System.out.printf("Total de Gastos: R$ %.2f%n", totalGastos);
        System.out.printf("Saldo Restante: R$ %.2f%n", saldoAtual);
        imprimiTexto("=====================================");
    }

    static void removerGastoNoMenu() {
        if (transactions.qtdAtual == 0) {
            imprimiTexto("Nenhum gasto cadastrado para remover.");
            return;
        }

        imprimiTexto("Listagem do Extrato para Ver o Nome...");
        listarMovimentacoesNoMenu();
        String nomeProcurado = lerTexto("Digite o nome (descrição) do gasto que deseja remover: ");

        if (transactions.removerPorNome(nomeProcurado)) {
            imprimiTexto("Gasto '" + nomeProcurado + "' removido com sucesso!");
        } else {
            imprimiTexto("Gasto '" + nomeProcurado + "' não foi encontrado.");
        }
    }

    static void adicionarEntradaNoMenu() {
        double entrada = lerDouble("Digite o Valor da Entrada: ");
        sc.nextLine();

        transactions.adicionarEntrada(entrada);

        imprimiTexto("\nSaldo Atualizado com sucesso!");
        System.out.printf("Saldo Atual: R$ %.2f%n", transactions.obterSaldoAtual());
        imprimiTexto("--------------------------------");
    }

    static void exibirMenu() {
        imprimiTexto("\n--- GERENCIADOR FINANCEIRO ---");
        imprimiTexto("1. Adicionar Gasto");
        imprimiTexto("2. Ver Extrato");
        imprimiTexto("3. Remover Gasto por Nome");
        imprimiTexto("4. Adicionar Entrada");
        imprimiTexto("0. Sair");
        imprimiTexto("--------------------------------");
    }

    static double lerDouble(String msg) {
        System.out.print(msg);
        return sc.nextDouble();
    }

    static int lerInt(String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    static String lerTexto(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    static void imprimiTexto(String msg) {
        System.out.println(msg);
    }
}