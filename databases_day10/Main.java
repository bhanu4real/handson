package databases_day10;

public class Main {
    public static void main(String[] args) {
        ProductStore ps= new ProductStore();

        try {
            ps.addProduct(new Product(108,"Table","Study table",9800));
        } catch (ProductAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(ps.getAllProducts());
        ps.updateProduct(new Product(101,"Television","A 52 inch smart tv",45000));

        Product p1 = new Product(1, "Phone", "Smartphone", 699.99);
        Product p2 = new Product(2, "Tablet", "Android Tablet", 299.99);

        try {
            ps.addTwoProducts(p1, p2);
            System.out.println("Products added successfully");
        } catch (ProductNotAddedException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
