import java.util.HashMap;

public class Task2 {
    public static void main(String[] args) {
        HashMap<String, Product> toy = new HashMap<>();
        toy.put("Toy1", new Product("Toy1"));
        toy.put("Toy2", new Product("Toy2"));
        toy.put("Toy3", new Product("Toy3"));
        toy.put("Toy4", new Product("Toy4"));
        IProduct printer = (map) -> {
            for (HashMap.Entry<String, Product> entry : map.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        };
        System.out.println("Printing entrySet:");
        printer.iterateAndPrint(toy);
        IProduct keySetPrinter = (map) -> {
            for (String key : map.keySet()) {
                System.out.println("Key: " + key);
            }
        };
        System.out.println("Printing keySet:");
        keySetPrinter.iterateAndPrint(toy);
        IProduct valuesPrinter = (map) -> {
            for (Product product : map.values()) {
                System.out.println("Value: " + product);
            }
        };
        System.out.println("Printing values:");
        valuesPrinter.iterateAndPrint(toy);
    }
}
