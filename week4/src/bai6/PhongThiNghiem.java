package bai6;

public class PhongThiNghiem extends PhongHoc {
	private String chuyenNganh;
	private int sucChua;
	private boolean coBonRua;

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, String chuyenNganh,
			int sucChua, boolean coBonRua) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.chuyenNganh = chuyenNganh;
		this.sucChua = sucChua;
		this.coBonRua = coBonRua;
	}

	@Override
	public boolean kiemTraDatChuan() {
		return getDienTich() >= 10 && getSoBongDen() >= 1 && coBonRua;
	}

	@Override
	public String toString() {
		return super.toString() + ", chuyenNganh='" + chuyenNganh + '\'' + ", sucChua=" + sucChua + ", coBonRua="
				+ coBonRua;
	}
}
