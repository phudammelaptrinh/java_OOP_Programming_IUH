package bai1;

public class ChuyenXeNoiThanh extends ChuyenXe {
	private int soTuyen;
	private int soKmDiDuoc;

	public ChuyenXeNoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, int soTuyen, int soKmDiDuoc,
			double doanhThu) {
		super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
		this.soTuyen = soTuyen;
		this.soKmDiDuoc = soKmDiDuoc;
	}

	@Override
	public String toString() {
		return super.toString() + ", Số tuyến: " + soTuyen + ", Số km đi được: " + soKmDiDuoc;
	}
}
