package Application;

import Entities.Movimentacao;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static final int LIMITE_TRANSACOES = 100;

    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Movimentacao[] historico = new Movimentacao[LIMITE_TRANSACOES];

        System.out.print("Digite o seu saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        int opc, contador = 0;

        do {
            exibirMenu();
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    if (contador < LIMITE_TRANSACOES) {
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();
                        historico[contador] = new Movimentacao(valor, desc);
                        contador++;
                    } else {
                        System.out.println("Limite de transações atingido!");
                    }
                    break;
                case 2:
                    listarMovimentacao(historico, contador);
                    break;
                case 3:
                    double totalGastos = calcularGasto(historico, contador);
                    double saldo_atualizado = saldoInicial - totalGastos;
                    System.out.println("\n==========================");
                    System.out.printf("Saldo Inicial:   R$ %.2f%n", saldoInicial);
                    System.out.printf("Total de Gastos: R$ %.2f%n", totalGastos);
                    System.out.printf("Saldo Atual:     R$ %.2f%n", saldo_atualizado);
                    System.out.println("==========================");
                    break;
            }
        } while (opc != 0);
        System.out.println("Programa encerrado.");
        sc.close();
    }


    public static void exibirMenu() {
        System.out.println("\n--- GERENCIADOR FINANCEIRO ---");
        System.out.println("1. Adicionar Gasto");
        System.out.println("2. Ver Extrato");
        System.out.println("3. Calcular Saldo Total");
        System.out.println("0. Sair");
        System.out.println("--------------------------------");
        System.out.print("Escolha: ");

    }

    public static void listarMovimentacao(Movimentacao[] vect, int total) {
        System.out.println("==========================");
        for (int i = 0; i < total; i++) {
            vect[i].exibirResumo();
        }
        System.out.println("==========================");
    }

    public static double calcularGasto(Movimentacao[] vect, int total) {
        double aux = 0;
        System.out.println("\n");
        for (int i = 0; i < total; i++) {
            aux += vect[i].getValue();
        }
        return aux;
    }
}


