public class Movimentacao {
    double saldo;
    Despesa[] historico;
    int qtdAtual;

    Movimentacao(double saldoInicial) {
        this.saldo = saldoInicial;
        this.historico = new Despesa[100];
        this.qtdAtual = 0;
    }


    boolean adicionarGasto(double value, String desc) {
        if (qtdAtual >= historico.length) {
            return false;
        }
        historico[qtdAtual] = new Despesa(value, desc);
        qtdAtual++;
        saldo -= value;
        return true;
    }

    void adicionarEntrada(double entrada) {
        saldo += entrada;
    }


    boolean removerPorNome(String nomeProcurado) {
        for (int i = 0; i < qtdAtual; i++) {
            if (historico[i].desc.equalsIgnoreCase(nomeProcurado)) {
                saldo += historico[i].value;

                for (int j = i; j < qtdAtual - 1; j++) {
                    historico[j] = historico[j + 1];
                }
                historico[qtdAtual - 1] = null;
                qtdAtual--;
                return true;
            }
        }
        return false;
    }


    double obterTotalGastos() {
        double total = 0;
        for (int i = 0; i < qtdAtual; i++) {
            total += historico[i].value;
        }
        return total;
    }


    double obterSaldoAtual() {
        return saldo;
    }
}