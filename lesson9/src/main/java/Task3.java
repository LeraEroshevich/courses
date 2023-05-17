import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Task3 {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1232345"));
        products.add(new Product("test"));
        products.add(new Product("Product"));
        products.add(new Product("Testing"));
        Supplier<StringBuilder> supplier = () -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Product product : products) {
                String name = product.getName();
                if (!name.isEmpty()) {
                    stringBuilder.append(name).append(" ");
                }
            }
            return stringBuilder;
        };
        StringBuilder result = supplier.get();
        System.out.println(result);
    }
}
