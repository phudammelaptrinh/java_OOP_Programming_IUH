package bai5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HoaDon {
	protected String maKH;
	protected String hoTen;
	protected LocalDate ngayRaHoaDon;
	protected double soLuong;
	protected double donGia;
	protected static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public HoaDon(String maKH, String hoTen, LocalDate ngayRaHoaDon, double soLuong, double donGia) {
		this.maKH = maKH;
		this.hoTen = hoTen;
		this.ngayRaHoaDon = ngayRaHoaDon;
		this.soLuong = soLuong;
		this.donGia = donGia;
	}

	public abstract double tinhThanhTien();

	public LocalDate getNgayRaHoaDon() {
		return ngayRaHoaDon;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-12s %-10.2f %-10.2f %-15.2f", maKH, hoTen, ngayRaHoaDon.format(df), soLuong,
				donGia, tinhThanhTien());
	}
}
