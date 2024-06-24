package bai7;

public class HangSanhSu extends HangHoa {
	String xuatXu;
	String nhaSanXuat;

	public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String xuatXu, String nhaSanXuat) {
		super(maHang, tenHang, soLuongTon, donGia);
		this.xuatXu = xuatXu;
		this.nhaSanXuat = nhaSanXuat;
	}

	@Override
	public void hienThiThongTin() {
		System.out.printf("| %-10s | %-20s | %-10d | %-10.2f | %-15s | %-15s |\n", maHang, tenHang, soLuongTon, donGia,
				xuatXu, nhaSanXuat);
	}

}
