public class Pear extends Fruits {
    public Pear(double weight) {
        super(weight);
    }

    public double getCost() {
        return getWeight() * 3.0;
    }
}
