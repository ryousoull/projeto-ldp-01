public class Despesa {
     Double value;
     String desc;

     Despesa(Double value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String toString() {
        return String.format("%-10s | R$ %.2f", desc, value);
    }
}
