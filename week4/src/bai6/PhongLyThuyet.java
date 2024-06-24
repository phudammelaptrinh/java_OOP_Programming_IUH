package bai6;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	@Override
	public boolean kiemTraDatChuan() {
		return getDienTich() >= 10 && getSoBongDen() >= 1 && coMayChieu;
	}

	@Override
	public String toString() {
		return super.toString() + ", coMayChieu=" + coMayChieu;
	}
}
