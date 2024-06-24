package bai5;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test5 {
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Tạo ba đối tượng HangThucPham
        try {
            HangThucPham htp1 = new HangThucPham("001", "Sua", 20000, dateFormat.parse("01/01/2023"), dateFormat.parse("01/01/2024"));
            HangThucPham htp2 = new HangThucPham("002", "Banh mi", 15000, dateFormat.parse("01/01/2023"), dateFormat.parse("31/12/2022")); // Ngày hết hạn không hợp lệ
            HangThucPham htp3 = new HangThucPham("003", "Nuoc ngot", 10000, dateFormat.parse("01/05/2023"), dateFormat.parse("01/05/2024"));

            // In danh sách các mặt hàng
            System.out.println("Danh sach hang thuc pham:");
            System.out.printf("%-15s %-20s %-20s %-20s %-20s %-10s\n", "Ma hang", "Ten hang", "Gia", "Ngay san xuat", "Ngay het han", "Het han");
            System.out.println(htp1);
            System.out.println(htp2);
            System.out.println(htp3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
