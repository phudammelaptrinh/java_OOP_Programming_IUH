package bai4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
	protected String maGD;
	protected LocalDate ngayGD;
	protected double donGia;
	protected double dienTich;
	protected static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public GiaoDich(String maGD, LocalDate ngayGD, double donGia, double dienTich) {
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	public abstract double tinhThanhTien();

	public LocalDate getNgayGD() {
		return ngayGD;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-12s %-10.2f %-10.2f %-15.2f", maGD, ngayGD.format(df), donGia, dienTich,
				tinhThanhTien());
	}
}
