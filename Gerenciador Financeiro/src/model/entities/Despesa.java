package model.entities;

public class Despesa {
    public Double value;
    public String desc;

    public Despesa(Double value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public void exibirResumo() {
        System.out.printf("%-10s | R$ %.2f%n", desc, value);
    }
}
