package model.application;

import model.entities.Movimentacao;
import model.utilities.Uteis;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static final int LIMITE_TRANSACOES = 100;

    static void main() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Uteis util = new Uteis();
        Movimentacao[] historico = new Movimentacao[LIMITE_TRANSACOES];

        System.out.print("Digite o seu saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        int opc, contador = 0;

        do {
            util.exibirMenu();
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
                    util.listarMovimentacao(historico, contador);
                    break;
                case 3:
                    util.mostrarSaldoAtual(historico, contador, saldoInicial);
                    break;
            }
        } while (opc != 0);
        System.out.println("Programa encerrado.");
        sc.close();
    }
}


