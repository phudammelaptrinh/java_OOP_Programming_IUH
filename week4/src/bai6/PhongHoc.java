package bai6;

public abstract class PhongHoc {
	private String maPhong;
	private String dayNha;
	private double dienTich;
	private int soBongDen;

	public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
		this.maPhong = maPhong;
		this.dayNha = dayNha;
		this.dienTich = dienTich;
		this.soBongDen = soBongDen;
	}

	public String getMaPhong() {
		return maPhong;
	}

	public String getDayNha() {
		return dayNha;
	}

	public double getDienTich() {
		return dienTich;
	}

	public int getSoBongDen() {
		return soBongDen;
	}

	public abstract boolean kiemTraDatChuan();

	@Override
	public String toString() {
		return "PhongHoc{" + "maPhong='" + maPhong + '\'' + ", dayNha='" + dayNha + '\'' + ", dienTich=" + dienTich
				+ ", soBongDen=" + soBongDen + '}';
	}
}
