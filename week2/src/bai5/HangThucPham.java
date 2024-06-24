package bai5;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HangThucPham {
    private final String maHang; // Mã hàng không thể sửa đổi sau khi khởi tạo
    private String tenHang;
    private double gia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    // Constructor mặc định
    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc de trong"); // Nếu mã hàng rỗng, ném ra lỗi
        }
        this.maHang = maHang;
        this.tenHang = "xxx"; // Gán giá trị mặc định
        this.gia = 0.0; // Gán giá trị mặc định
        this.ngaySanXuat = new Date(); // Ngày hiện tại
        this.ngayHetHan = new Date(); // Ngày hiện tại
    }

    // Constructor đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double gia, Date ngaySanXuat, Date ngayHetHan) {
        if (maHang == null || maHang.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma hang khong duoc de trong"); // Nếu mã hàng rỗng, ném ra lỗi
        }
        this.maHang = maHang;
        setTenHang(tenHang);
        setGia(gia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);
    }

    // Getter cho maHang
    public String getMaHang() {
        return maHang;
    }

    // Getter cho tenHang
    public String getTenHang() {
        return tenHang;
    }

    // Setter cho tenHang
    public void setTenHang(String tenHang) {
        if (tenHang != null && !tenHang.trim().isEmpty()) {
            this.tenHang = tenHang;
        } else {
            this.tenHang = "xxx"; // Gán giá trị mặc định
        }
    }

    // Getter cho gia
    public double getGia() {
        return gia;
    }

    // Setter cho gia
    public void setGia(double gia) {
        if (gia >= 0) {
            this.gia = gia;
        } else {
            this.gia = 0.0; // Gán giá trị mặc định
        }
    }

    // Getter cho ngaySanXuat
    public Date getNgaySanXuat() {
        return ngaySanXuat;
    }

    // Setter cho ngaySanXuat
    public void setNgaySanXuat(Date ngaySanXuat) {
        if (ngaySanXuat != null && ngaySanXuat.before(new Date())) {
            this.ngaySanXuat = ngaySanXuat;
        } else {
            this.ngaySanXuat = new Date(); // Gán giá trị mặc định
        }
    }

    // Getter cho ngayHetHan
    public Date getNgayHetHan() {
        return ngayHetHan;
    }

    // Setter cho ngayHetHan
    public void setNgayHetHan(Date ngayHetHan) {
        if (ngayHetHan != null && ngayHetHan.after(this.ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        } else {
            this.ngayHetHan = this.ngaySanXuat; // Gán giá trị mặc định
        }
    }

    // Phương thức kiểm tra sản phẩm đã hết hạn chưa
    public boolean isExpired() {
        return new Date().after(ngayHetHan);
    }

    // Phương thức toString
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat currencyFormat = new DecimalFormat("#,###.00 VND");
        return String.format("Ma hang: %s, Ten hang: %s, Gia: %s, Ngay san xuat: %s, Ngay het han: %s, Het han: %s",
                maHang, tenHang, currencyFormat.format(gia), dateFormat.format(ngaySanXuat), dateFormat.format(ngayHetHan), isExpired() ? "Co" : "Khong");
    }
}
