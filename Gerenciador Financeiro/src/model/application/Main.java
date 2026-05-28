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

        System.out.println("Bem vindo ao seu Gerenciador Financeiro!");
        double saldoInicial = lerNumero("Digite o seu saldo inicial: ");

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
                default:
                    System.out.println("Erro: Digite uma opção válida!");
            }
        } while (opc != 0);
        System.out.println("Programa encerrado.");
        sc.close();
    }



    public static void cadastroMovimentacao() {
        if (qtdAtual >= LIMITE_TRANSACOES) {
            System.out.println("Limite de transações atingido!");
            return;
        }

        double value = lerNumero("Valor: ");
        sc.nextLine();
        String desc = lerTexto("Descrição: ");

        historico[qtdAtual] = new Movimentacao(value, desc);
        qtdAtual++;
        System.out.println("Gasto adicionado com sucesso!");
    }


    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR FINANCEIRO ---");
        System.out.println("1. Adicionar Gasto");
        System.out.println("2. Ver Extrato");
        System.out.println("3. Calcular Gasto Total e Slado Atual");
        System.out.println("0. Sair");
        System.out.println("--------------------------------");

    }

    public static void listarMovimentacao () {
        System.out.println("=====================================");
        for (int i = 0; i < qtdAtual; i++) {
            historico[i].exibirResumo();
        }
        System.out.println("=====================================");
    }

    public static void calcularSaldoTotal(double saldoInicial) {
        double total = 0;
        for (int i = 0; i < qtdAtual; i++) {
            total += historico[i].value;
        }
        System.out.println("==========================");
        System.out.printf("Total de Gastos: R$ %.2f%n", total);
        System.out.printf("Saldo Restante: R$ %.2f%n", saldoInicial - total);
        System.out.println("==========================");
    }

    public static double lerNumero(String msg) {
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

}


