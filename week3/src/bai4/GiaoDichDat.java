package bai4;

import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
	private String loaiDat;

	public GiaoDichDat(String maGD, LocalDate ngayGD, double donGia, String loaiDat, double dienTich) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	@Override
	public double tinhThanhTien() {
		if (loaiDat.equals("A")) {
			return dienTich * donGia * 1.5;
		} else {
			return dienTich * donGia;
		}
	}

	@Override
	public String toString() {
		return super.toString() + String.format(" %-7s", loaiDat);
	}
}
