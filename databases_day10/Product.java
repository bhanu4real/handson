package databases_day10;

public class Product {
    int productid;
    String productname;
    String description;
    double price;

    public Product(int productid, String productname, String description, double price) {
        this.productid = productid;
        this.productname = productname;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "EntityProduct{" +
                "productid=" + productid +
                ", productname='" + productname + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

}

