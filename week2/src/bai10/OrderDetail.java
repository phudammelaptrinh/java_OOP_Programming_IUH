package bai10;

public class OrderDetail {
    private Product product;
    private int quantity;

    public OrderDetail(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double calcTotalPrice() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %10.0f VND | %8d | %12.0f VND",
                product.getProductID(), product.getDescription(), product.getPrice(), quantity, calcTotalPrice());
    }
}
