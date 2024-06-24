package bai1;

public class ToaDo {
    private int x; 
    private int y;
    private String ten;
    
    // Default constructor
    public ToaDo() {
        this.x = 0;
        this.y = 0;
        this.ten = "Khong xac dinh!";
    }
    
    // Parameterized constructor
    public ToaDo(int x, int y, String ten) {
        this.x = x; 
        this.y = y;
        this.ten = ten;
    }

    // Getter for x
    public int getX() {
        return x;
    }

    // Setter for x
    public void setX(int x) {
        this.x = x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // Setter for y
    public void setY(int y) {
        this.y = y;
    }

    // Getter for ten
    public String getTen() {
        return ten;
    }

    // Setter for ten
    public void setTen(String ten) {
        this.ten = ten;
    }

    // toString method
    @Override
    public String toString() {
        return ten + " (" + x + "," + y + ")";
    }
}
