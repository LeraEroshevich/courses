public class Product {
    private String name;

    public Product() {

    }

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "this is product";
    }
}
