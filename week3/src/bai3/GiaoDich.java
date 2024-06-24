package bai3;

public abstract class GiaoDich {
	protected String maGD;
	protected double donGia;
	protected int soLuong;

	public GiaoDich(String maGD, double donGia, int soLuong) {
		this.maGD = maGD;
		this.donGia = donGia;
		this.soLuong = soLuong;
	}

	public abstract double tinhThanhTien();

	@Override
	public String toString() {
		return String.format("Mã giao dịch: %s, Đơn giá: %,.2f, Số lượng: %d", maGD, donGia, soLuong);
	}

	public double getDonGia() {
		return donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

}
