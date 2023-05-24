import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", 1));
        products.add(new Product("Pear", 2));
        products.add(new Product("Strawberry", 3));
        products.add(new Product("Watermelon", 4));
        products.add(new Product("Melon", 5));
        products.add(new Product("Peach", 6));
        products.add(new Product("Apricot", 7));
        products.add(new Product("Banana", 8));
        String firstProductName = products.get(0).getName();

        for (int i = products.size() - 3; i < products.size(); i++) {
            products.get(i).setName(firstProductName);
        }

        Map<String, Integer> productGroupsWithSum = products.stream()
            .collect(Collectors.groupingBy(Product::getName,
                            Collectors.summingInt(Product::getProductId)));

        for (Map.Entry<String, Integer> entry : productGroupsWithSum.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Sum of ProductId = " + entry.getValue());
        }
    }
}
