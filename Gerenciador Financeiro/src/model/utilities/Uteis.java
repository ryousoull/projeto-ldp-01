package model.utilities;

import model.entities.Movimentacao;

public class Uteis {

    public Uteis (){
    }

    public void exibirMenu() {
        System.out.println("\n--- GERENCIADOR FINANCEIRO ---");
        System.out.println("1. Adicionar Gasto");
        System.out.println("2. Ver Extrato");
        System.out.println("3. Calcular Saldo Total");
        System.out.println("0. Sair");
        System.out.println("--------------------------------");
        System.out.print("Escolha: ");

    }

    public void listarMovimentacao(Movimentacao[] vect, int total) {
        System.out.println("==========================");
        for (int i = 0; i < total; i++) {
            vect[i].exibirResumo();
        }
        System.out.println("==========================");
    }

    public double calcularGasto(Movimentacao[] vect, int total) {
        double aux = 0;
        for (int i = 0; i < total; i++) {
            aux += vect[i].getValue();
        }
        return aux;
    }

    public double calcularSaldo(Movimentacao[] vect, int total, double saldoInicial) {
        double totalGastos = calcularGasto(vect, total);
        return saldoInicial - totalGastos;
    }

    public void mostrarSaldoAtual (Movimentacao[] vect, int total, double saldoInicial) {
        System.out.println("============================");
        System.out.printf("Saldo Inicial:   R$ %.2f%n", saldoInicial);
        System.out.printf("Total de Gastos: R$ %.2f%n", calcularGasto(vect,total));
        System.out.printf("Saldo Atual:     R$ %.2f%n", calcularSaldo(vect,total,saldoInicial));
        System.out.println("==========================");
    }
}
