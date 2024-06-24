package bai4;

import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
	private String loaiNha;
	private String diaChi;

	public GiaoDichNha(String maGD, LocalDate ngayGD, double donGia, double dienTich, String loaiNha, String diaChi) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}

	@Override
	public double tinhThanhTien() {
		if (loaiNha.equals("cao cấp")) {
			return dienTich * donGia;
		} else {
			return dienTich * donGia * 0.9;
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-10s %-20s", loaiNha, diaChi);
	}
}
