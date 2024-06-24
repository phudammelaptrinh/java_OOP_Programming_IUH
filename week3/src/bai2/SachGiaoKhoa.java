package bai2;

import java.util.Date;

//public abstract class SachGiaoKhoa extends Sach {
//	private String tinhTrang;
//
//	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
//		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
//		// TODO Auto-generated constructor stub
//		this.tinhTrang = tinhTrang;
//	}
//
//	@Override
//	public double tinhThanhTien() {
//		// TODO Auto-generated method stub
//		if (tinhTrang.equalsIgnoreCase("mới")) {
//			return soLuong * donGia;
//		} else {
//			return soLuong * donGia * 0.5;
//		}
//	}
//
//	@Override
//	public String toString() {
//		return super.toString() + "Tình trang : " + tinhTrang;
//	}
//
//}
//
//
public class SachGiaoKhoa extends Sach {
	private String tinhTrang;

	public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
		this.tinhTrang = tinhTrang;
	}

	@Override
	public double tinhThanhTien() {
		if (tinhTrang.equalsIgnoreCase("mới")) {
			return soLuong * donGia;
		} else {
			return soLuong * donGia * 0.5;
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", Tình trạng: " + tinhTrang;
	}
}
