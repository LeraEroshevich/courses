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
        products.get(1).getProductId();
        products.get(products.size() - 1).setName(products.get(0).getName());
        products.get(products.size() - 1).setName(products.get(0).getName());

        List<String> sortedUniqueNames =
            products.stream().filter(p -> p.getProductId() != 0).sorted((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName())).map(Product::getName).distinct()
                .collect(Collectors.toList());

        for (int i = sortedUniqueNames.size() - 1; i >= 0; i--) {
            System.out.println(sortedUniqueNames.get(i));

        }
    }
}
