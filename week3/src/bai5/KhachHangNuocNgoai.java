package bai5;

import java.time.LocalDate;

public class KhachHangNuocNgoai extends HoaDon {
	private String quocTich;

	public KhachHangNuocNgoai(String maKH, String hoTen, LocalDate ngayRaHoaDon, double soLuong, double donGia,
			String quocTich) {
		super(maKH, hoTen, ngayRaHoaDon, soLuong, donGia);
		this.quocTich = quocTich;
	}

	@Override
	public double tinhThanhTien() {
		return soLuong * donGia;
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-10s", quocTich);
	}
}
