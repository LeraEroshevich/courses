public class Apple extends Fruits {
    public Apple(double weight) {
        super(weight);
    }

    public double getCost() {
        return getWeight() * 2.5;
    }

}
