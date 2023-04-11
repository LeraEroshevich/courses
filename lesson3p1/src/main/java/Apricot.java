public class Apricot extends Fruits  {
    public Apricot(double weight) {
        super(weight);
    }

    public double getCost() {
        return getWeight() * 4.0;
    }
}
