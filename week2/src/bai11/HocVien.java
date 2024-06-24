package bai11;

import java.util.Arrays;

public class HocVien {
	private String hoTen;
	private int namSinh;
	private double[] diem;
	private static final String[] MON_HOC = {
		"Nhập môn lập trình",
		"Kỹ thuật lập trình",
		"OOP",
		"Phát triển ứng dụng",
		"Công nghệ mới",
	};
	public HocVien(String hoTen, int namSinh) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.diem = new double[5];//
		
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getNamSinh() {
		return namSinh;
	}
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}
	public double[] getDiem() {
		return diem;
	}
	public void setDiem(double[] diem) {
		if(diem.length== 5) {
			this.diem = diem;
		}
		else {
			throw new IllegalArgumentException("Nhập điểm 5 môn!");
		}
	}

	public void setDiemMonHoc(int index, double diem) {
		if(index >= 0 && index < 5) {
			this.diem[index] = diem;
		}
		else {
			throw new IllegalArgumentException("Chỉ số môn học không hợp lệ !");
		}
	}
	
	public double tinhDiemTrungBinh() {
		double tong= 0;
		for(double d: diem) {
			tong +=d;
		}
		return tong/diem.length;
	}
	
	public boolean isThesis() {
		double dtb = tinhDiemTrungBinh();
		if(dtb>7) {
			for(double d:diem) {
				if(d< 5) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	public boolean isGraduationExam() {
		double dtb = tinhDiemTrungBinh();
		if(dtb <= 7) {
			for(double d : diem) {
				if(d<5) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public boolean isRetakeExam() {
		for(double d: diem) {
			if(d<5) {
				return true;
			}
		}
		return false;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("HocVien{")
	          .append("hoTen='").append(hoTen).append('\'')
	          .append(", namSinh=").append(namSinh)
	          .append(", diem=").append(Arrays.toString(diem))
	          .append(", monHoc=");
	        
	        for (int i = 0; i < MON_HOC.length; i++) {
	            sb.append(MON_HOC[i]).append(": ").append(diem[i]);
	            if (i < MON_HOC.length - 1) {
	                sb.append(", ");
	            }
	        }
	        
	        sb.append('}');
	        return sb.toString();
	    }
	
}
