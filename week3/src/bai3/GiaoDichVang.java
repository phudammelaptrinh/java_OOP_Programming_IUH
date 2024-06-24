package bai3;

public class GiaoDichVang extends GiaoDich {
	private String loaiVang;

	public GiaoDichVang(String maGD, double donGia, int soLuong, String loaiVang) {
		super(maGD, donGia, soLuong);
		this.loaiVang = loaiVang;
	}

	@Override
	public double tinhThanhTien() {

		return soLuong * donGia;
	}

	@Override
	public String toString() {
		return String.format("%s, Loại vàng: %s, Thành tiền: %,.2f", super.toString(), loaiVang, tinhThanhTien());
	}

}
