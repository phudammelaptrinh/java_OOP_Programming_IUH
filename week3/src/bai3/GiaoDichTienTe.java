package bai3;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GiaoDichTienTe extends GiaoDich {
	private Date ngayGD;
	private double tiGia;
	private String loaiTienTe;

	public GiaoDichTienTe(String maGD, Date ngayGD, int soLuong, double donGia, double tiGia, String loaiTienTe) {
		super(maGD, donGia, soLuong);
		this.ngayGD = ngayGD;
		this.tiGia = tiGia;
		this.loaiTienTe = loaiTienTe;

	}

	@Override
	public double tinhThanhTien() {
		if (loaiTienTe.equalsIgnoreCase("USD") || loaiTienTe.equalsIgnoreCase("Euro")) {
			return soLuong * donGia * tiGia;
		} else {
			return soLuong * donGia;
		}
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return String.format("%s, Ngày giao dịch: %s, Tỉ giá: %,.2f, Loại tiền tệ: %s, Thành tiền: %,.2f",
				super.toString(), sdf.format(ngayGD), tiGia, loaiTienTe, tinhThanhTien());
	}
}
