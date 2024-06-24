package bai1;

public class ChuyenXeNgoaiThanh extends ChuyenXe {
	private String noiDen;
	private int soNgayDiDuoc;

	public ChuyenXeNgoaiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, String noiDen, int soNgayDiDuoc,
			double doanhThu) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.noiDen = noiDen;
		this.soNgayDiDuoc = soNgayDiDuoc;
	}

	@Override
	public String toString() {
		return super.toString() + ", Nơi đến: " + noiDen + ", Số ngày đi được: " + soNgayDiDuoc;
	}
}
