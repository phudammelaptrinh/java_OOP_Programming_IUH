package bai7;

public class ThucPham extends HangHoa {
	String nhaCungCap;
	String ngaySanXuat;
	int hanBaoQuan;

	public ThucPham(String maHang, String tenHang, int soLuongTon, double donGia, String nhaCungCap, String ngaySanXuat,
			int hanBaoQuan) {
		super(maHang, tenHang, soLuongTon, donGia);
		// TODO Auto-generated constructor stub
		this.nhaCungCap = nhaCungCap;
		this.ngaySanXuat = ngaySanXuat;
		this.hanBaoQuan = hanBaoQuan;
	}

	@Override
	public void hienThiThongTin() {
		System.out.printf("| %-10s | %-20s | %-10d | %-10.2f | %-15s | %-12s | %-10d |\n", maHang, tenHang, soLuongTon,
				donGia, nhaCungCap, ngaySanXuat, hanBaoQuan);
	}
}
