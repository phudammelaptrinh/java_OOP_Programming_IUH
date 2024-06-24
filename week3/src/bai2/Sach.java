package bai2;

import java.util.Date;

public abstract class Sach {
	protected String maSach;
	protected Date ngayNhap;
	protected double donGia;
	protected int soLuong;
	protected String nhaXuatBan;

	public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
		this.maSach = maSach;
		this.ngayNhap = ngayNhap;
		this.donGia = donGia;
		this.soLuong = soLuong;
		this.nhaXuatBan = nhaXuatBan;
	}

	public abstract double tinhThanhTien();

	@Override
	public String toString() {
		return "Mã sách" + maSach + ", Ngày nhập : " + ngayNhap + ", Đơn giá : " + donGia + ", Số lượng : " + soLuong
				+ ", Nhà xuất bản : " + nhaXuatBan;
	}

	public double getDonGia() {
		return donGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

}
