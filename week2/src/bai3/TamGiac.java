package bai3;

public class TamGiac {
	private double ma;
	private double mb;
	private double mc;
	public TamGiac(double ma, double mb, double mc) {
		if(kiemtra(ma,mb,mc)) {
			this.ma = ma;
			this.mb = mb;
			this.mc = mc;
		}
		else {
			this.ma = 0;
			this.mb = 0;
			this.mc =0 ;
		}
		
	}
	public double getMa() {
		return ma;
	}
	public void setMa(double ma) {
		if(kiemtra(ma,this.mb,this.mc)) 
		{
				this.ma = ma;
		}
	}
	public double getMb() {
		return mb;
	}
	public void setMb(double mb) {
		if(kiemtra(this.ma,mb,this.mc)) 
		{
				this.mb = mb;
		}
	}
	public double getMc() {
		return mc;
	}
	public void setMc(double mc) {
		if(kiemtra(this.ma,this.mb,mc)) 
		{
				this.mc = mc;
		}
	}
	
	private boolean kiemtra(double ma,double mb, double mc) {
		return ma > 0 && mb > 0 && mc >0 && (ma+mb>mc) && (ma + mc > mb) && (mb+mc)>ma;
	}
	
	public double tinhChuVi(){
		return  ma+mb+mc;
	}
	
	 public double tinhDienTich() {
	        double p = tinhChuVi() / 2;
	        return Math.sqrt(p * (p - ma) * (p - mb) * (p - mc));
	 
	 }
	public String kieuTamGiac() {
		if(ma == 0 || mb ==0 || mc == 0) {
			return "Khong phai la tam giac!";
		}
		if(ma == mb && mb == mc) {
			return "Tam Giac Deu!";
		}
		if(ma == mb && ma == mc || mb == mc) {
			return "Tam giac can!";
		}
		return"Tam giac thuong!";
	}
	
	 // toString method
    @Override
    public String toString() {
        return String.format("Cac canh: ma=%.2f, mb=%.2f, mc=%.2f - Kieu: %s - Chu vi: %.2f - Dien tich: %.2f",
                ma, mb, mc, kieuTamGiac(), tinhChuVi(), tinhDienTich());
    }
	
	
}
