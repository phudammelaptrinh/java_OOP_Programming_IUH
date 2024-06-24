package bai7;

public class HinhTron {
	private ToaDo tam;
	private double banKinh;
	
	
	public HinhTron(ToaDo tam, double banKinh) {
		
		this.tam = tam;
		this.banKinh = banKinh;
	}
	
	public HinhTron() {
		this.tam = new ToaDo();
		this.banKinh = 0;
	}

	public ToaDo getTam() {
		return tam;
	}

	public void setTam(ToaDo tam) {
		this.tam = tam;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	@Override
	public String toString() {
		return "Hinh trong co  [tam=" + tam + ",  va ban kinh=" + banKinh + "]";
	}
	
	public double tinhChuVi() {
		return 2*Math.PI*banKinh;
	}
	
	public double tinhDienTich() {
		return Math.PI *banKinh*banKinh;
	}
	
}
