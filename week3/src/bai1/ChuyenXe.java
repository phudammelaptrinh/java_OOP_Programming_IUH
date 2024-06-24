package bai1;

public class ChuyenXe {
	protected String maSoChuyen;
	protected String hoTenTaiXe;
	protected String soXe;
	protected double doanhThu;

	public ChuyenXe(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
		this.maSoChuyen = maSoChuyen;
		this.hoTenTaiXe = hoTenTaiXe;
		this.soXe = soXe;
		this.doanhThu = doanhThu;
	}

	@Override
	public String toString() {
		return "Mã số chuyến: " + maSoChuyen + ", Họ tên tài xế: " + hoTenTaiXe + ", Số xe: " + soXe + ", Doanh thu: "
				+ doanhThu;
	}

	public double getDoanhThu() {
		return doanhThu;
	}
}
