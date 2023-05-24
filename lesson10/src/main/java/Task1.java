import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple", 1));
        products.add(new Product("Pear", 2));
        products.add(new Product("Strawberry", 3));
        products.add(new Product("Watermelon", 4));

        products.get(1).setProductId(0);

        String firstName = products.get(0).getName();
        products.get(products.size() - 1).setName(firstName);

        products.stream()
            .filter(p -> p.getProductId() != 0)
            .map(Product::getName)
            .distinct()
            .sorted(String::compareToIgnoreCase)
            .forEach(name -> System.out.println(new StringBuilder(name).reverse()));
    }
}

