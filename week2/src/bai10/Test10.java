package bai10;
import java.util.Date;

public class Test10 {
    public static void main(String[] args) {
        // Create some products
        Product p1 = new Product("sp1", "Nuoc tuong", 8000);
        Product p2 = new Product("sp2", "Gao", 18000);
        Product p3 = new Product("sp3", "Duong", 10000);
        Product p4 = new Product("sp4", "Gao", 18000);

        // Create an order
        Order order = new Order(1, new Date());

        // Add line items to the order
        order.addLineItem(p1, 10);
        order.addLineItem(p2, 5);
        order.addLineItem(p3, 1);
        order.addLineItem(p4, 1);

        // Print order details
        System.out.println(order);
    }
}
