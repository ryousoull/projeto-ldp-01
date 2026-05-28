package model.entities;

public class Movimentacao {
    public double saldoInicial;
    public Despesa[] historico;
    public int qtdAtual;

    public Movimentacao(double saldoInicial) {
        this.saldoInicial = saldoInicial;
        this.historico = new Despesa[100];
        this.qtdAtual = 0;
    }

    public void listarMovimentacao () {
        System.out.println("\n=====================================");
        for (int i = 0; i < qtdAtual; i++) {
            historico[i].exibirResumo();
        }
        System.out.println("=====================================");
    }

    public void calcularSaldoTotal() {
        double total = 0;
        for (int i = 0; i < qtdAtual; i++) {
            total += historico[i].value;
        }
        System.out.println("\n==========================");
        System.out.printf("Total de Gastos: R$ %.2f%n", total);
        System.out.printf("Saldo Restante: R$ %.2f%n", saldoInicial);
        System.out.println("==========================");
    }
}
