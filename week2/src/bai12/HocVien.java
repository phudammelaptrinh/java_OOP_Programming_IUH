package bai12;

public class HocVien {
	private String hoTen;
	private String diaChi;
	private String sdt;
	
	public HocVien(String hoTen, String diaChi, String sdt) {
		
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public String getHoTen() {
		return hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public String getSdt() {
		return sdt;
	}
	
	@Override
    public String toString() {
        return String.format("%-20s %-30s %-15s", hoTen, diaChi, sdt);
    }
}
