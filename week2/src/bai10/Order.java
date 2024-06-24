package bai10;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class Order {
    private int orderID;
    private Date orderDate;
    private List<OrderDetail> lineItems;

    public Order(int orderID, Date orderDate) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.lineItems = new ArrayList<>();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void addLineItem(Product product, int quantity) {
        this.lineItems.add(new OrderDetail(product, quantity));
    }

    public double calcTotalCharge() {
        double total = 0;
        for (OrderDetail item : lineItems) {
            total += item.calcTotalPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        sb.append(String.format("Ma HD: %d\n", orderID));
        sb.append(String.format("Ngay lap hoa don: %s\n", dateFormat.format(orderDate)));
        sb.append(String.format("%-4s | %-10s | %-20s | %-10s | %-8s | %-12s\n", "STT", "Ma SP", "Mo ta", "Don gia", "S Luong", "Thanh tien"));
        
        int stt = 1;
        for (OrderDetail item : lineItems) {
            sb.append(String.format("%-4d | %s\n", stt++, item));
        }
        
        sb.append(String.format("Tong tien thanh toan: %,.0f VND", calcTotalCharge()));
        return sb.toString();
    }
}
