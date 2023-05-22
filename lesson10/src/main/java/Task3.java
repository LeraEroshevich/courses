import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task3 {
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
        int firstProductId = products.get(0).getProductId();

        for (int i = products.size() - 3; i < products.size(); i++) {
            products.get(i).setProductId(firstProductId);
        }

        Map<Integer, List<String>> productGroupsWithNames =
            products.stream().collect(Collectors.groupingBy(Product::getProductId, Collectors.mapping(Product::getName, Collectors.toList())));

        for (Map.Entry<Integer, List<String>> entry : productGroupsWithNames.entrySet()) {
            System.out.println("ProductId: " + entry.getKey() + ", Names: " + entry.getValue());
        }
    }

}
