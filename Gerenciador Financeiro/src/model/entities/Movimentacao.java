package model.entities;

public class Movimentacao {
    private Double value;
    private String desc;

    public Movimentacao(Double value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void exibirResumo() {
        System.out.printf("%-10s | R$ %.2f%n", desc, value);
    }
}
