public class Movimentacao {
     double saldoInicial;
     Despesa[] historico;
     int qtdAtual;

     Movimentacao(double saldoInicial) {
        this.saldoInicial = saldoInicial;
        this.historico = new Despesa[100];
        this.qtdAtual = 0;
    }

     void listarMovimentacao () {
        System.out.println("\n=====================================");
        for (int i = 0; i < qtdAtual; i++) {
            System.out.println(historico[i]);
        }
        System.out.println("=====================================");
    }

     void calcularSaldoTotal() {
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
