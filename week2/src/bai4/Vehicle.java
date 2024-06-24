package bai4;

/**
 * @author Ho Truong Minh Phu
 *
 */
public class Vehicle {
	private String chuXe;
	private String loaiXe;
	private double triGia;
	private int dungTichXyLanh;
	
	public Vehicle() {
		this.chuXe ="Khong xac dinh!";
		this.loaiXe= "Khong xac dinh!";
		this.triGia = 0.0;
		this.dungTichXyLanh = 0;
	}

	
	
	
	/**
	 * @param chuXe
	 * @param loaiXe
	 * @param triGia
	 * @param dungTichXyLanh
	 */
	public Vehicle(String chuXe, String loaiXe, double triGia, int dungTichXyLanh) {
		setChuXe(chuXe);
		setLoaiXe(loaiXe);
		setTriGia(triGia);
		setDungTichXyLanh(dungTichXyLanh);
	}




	public String getChuXe() {
		return chuXe;
	}

	public void setChuXe(String chuXe) {
		if(chuXe != null && !chuXe.trim().isEmpty()) 
		{
		this.chuXe = chuXe;
		}
		else
		{
		this.chuXe = chuXe;
		}
	}

	public String getLoaiXe() {
		return loaiXe;
	}

	public void setLoaiXe(String loaiXe) {
		if(loaiXe != null && !loaiXe.trim().isEmpty()) 
		{
		this.loaiXe = loaiXe;
		}
		else
		{
		this.loaiXe = loaiXe;
		}
	}

	public double getTriGia() {
		return triGia;
	}

	public void setTriGia(double triGia) {
		if(triGia>=0) 
		{
			this.triGia =triGia;
		}
		else {
			this.triGia = triGia = 0.0;
		}
	}

	public int getDungTichXyLanh() {
		return dungTichXyLanh;
	}

	public void setDungTichXyLanh(int dungTichXyLanh) {
		if(dungTichXyLanh >=0 ) {
			this.dungTichXyLanh = dungTichXyLanh;
		}
		else {
			this.dungTichXyLanh = 0;
		}
	}
	
	public double tinhThueTruocBa() {
		if(dungTichXyLanh < 100) {
			return triGia * 0.01;
		}
		else if (dungTichXyLanh <= 200) {
			return triGia * 0.03;
		}
		else {
			return triGia * 0.05;
		}
	}




	@Override
	public String toString() {
		 return String.format("Chu xe: %s, Loai xe: %s, Tri gia: %.2f, Dung tich xy lanh: %d, Thue truoc ba: %.2f",
	                chuXe, loaiXe, triGia, dungTichXyLanh, tinhThueTruocBa());
	}
	
	
}
