package model.application;
import model.entities.Movimentacao;


import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static final int LIMITE_TRANSACOES = 100;

    static Movimentacao [] historico = new Movimentacao[LIMITE_TRANSACOES];
    static int qtdAtual = 0;



    public static void main() {

        imprimiTexto("Bem vindo ao seu Gerenciador Financeiro!");
        double saldoInicial = lerDouble("Digite o seu saldo inicial: ");

        int opc;

        do {
            exibirMenu();
            opc = lerInt("Escolha: ");
            sc.nextLine();


            switch (opc) {
                case 1:
                    cadastroMovimentacao();
                    break;
                case 2:
                    listarMovimentacao();
                    break;
                case 3:
                    calcularSaldoTotal(saldoInicial);
                    break;
                case 4:
                    removerMovimentacaoPorNome();
                    break;
                default:
                    imprimiTexto("Erro: Digite uma opção válida!");
            }
        } while (opc != 0);
        imprimiTexto("Programa encerrado.");
        sc.close();
    }



    public static void cadastroMovimentacao() {
        if (qtdAtual >= LIMITE_TRANSACOES) {
            imprimiTexto("Limite de transações atingido!");
            return;
        }

        double value = lerDouble("Valor: ");
        sc.nextLine();
        String desc = lerTexto("Descrição: ");

        historico[qtdAtual] = new Movimentacao(value, desc);
        qtdAtual++;
        imprimiTexto("Gasto adicionado com sucesso!");
    }


    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR FINANCEIRO ---");
        System.out.println("1. Adicionar Gasto");
        System.out.println("2. Ver Extrato");
        System.out.println("3. Calcular Gasto Total e Saldo Atual");
        System.out.println("4. Remover Gasto por Nome.");
        System.out.println("0. Sair");
        System.out.println("--------------------------------");

    }

    public static void listarMovimentacao () {
        imprimiTexto("\n=====================================");
        for (int i = 0; i < qtdAtual; i++) {
            historico[i].exibirResumo();
        }
        imprimiTexto("=====================================");
    }

    public static void calcularSaldoTotal(double saldoInicial) {
        double total = 0;
        for (int i = 0; i < qtdAtual; i++) {
            total += historico[i].value;
        }
        System.out.println("\n==========================");
        System.out.printf("Total de Gastos: R$ %.2f%n", total);
        System.out.printf("Saldo Restante: R$ %.2f%n", saldoInicial - total);
        System.out.println("==========================");
    }

    public static void removerMovimentacaoPorNome() {
        if (qtdAtual == 0) {
            System.out.println("Nenhum gasto cadastrado para remover.");
        }

        System.out.println("Listagem do Extrato para Ver o Nome...");
        listarMovimentacao();
        String nomeProcurado = lerTexto("Digite o nome (descrição) do gasto que deseja remover: ");


        boolean indexProcurado = false;
        for (int i = 0; i < qtdAtual; i++) {
            if(historico[i].desc.equalsIgnoreCase(nomeProcurado)) {
                indexProcurado = true;
                for (int j = i; j < qtdAtual -1 ; j++) {
                    historico[j] = historico[j+1];
                }
            }
        }
        if (indexProcurado) {
            historico[qtdAtual-1] = null;
            qtdAtual--;
            System.out.println("Gasto '" + nomeProcurado + "' removido com sucesso!");
        } else {
            System.out.println("Gasto '" + nomeProcurado + "' não foi encontrado.");
        }


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


