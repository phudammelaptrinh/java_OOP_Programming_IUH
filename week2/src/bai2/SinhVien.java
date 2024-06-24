package bai2;

public class SinhVien {
	private int msv; 
	private String hoTen;
	private float diemLT;
	private float diemTH;
	
	public SinhVien() {
		this.msv = 1;
		this.hoTen = "Khong xac dinh!";
		this.diemLT = 0.0f;
		this.diemTH = 0.0f;
	}
	
	

	public SinhVien(int msv, String hoTen, float diemLT, float diemTH) {
		super();
		this.msv = msv;
		this.hoTen = hoTen;
		this.diemLT = diemLT;
		this.diemTH = diemTH;
	}
	
	


	public int getMsv() {
		return msv;
	}

	public void setMsv(int msv) {
		this.msv = msv;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public float getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(float diemLT) {
		this.diemLT = diemLT;
	}

	public float getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(float diemTH) {
		this.diemTH = diemTH;
	}

	public float tinhDiemTB() {
		return (diemLT+diemTH)/2;
	}
	 @Override
	    public String toString() {
	        return String.format("%-10d %-20s %-10.2f %-10.2f %-10.2f", msv, hoTen, diemLT, diemTH, tinhDiemTB());
	    }
}
	
	
	
