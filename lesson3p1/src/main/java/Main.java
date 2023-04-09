public class Main {
    public static void main(String[] args) {
        Fruits[] fruits = {
                new Apple(0.5),
                new Pear(1.2),
                new Apricot(2.3)
        };

        double totalCost = 0.0;
        for (Fruits fruit : fruits) {
            totalCost = totalCost + fruit.getCost();
        }
        System.out.println("Total cost of fruits: " + totalCost);
    }
}
