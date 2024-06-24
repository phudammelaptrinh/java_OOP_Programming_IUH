package bai7;

public class HangDienMay extends HangHoa {
	int congSuat;
	int dienAp;

	public HangDienMay(String maHang, String tenHang, int soLuongTon, double donGia, int congSuat, int dienAp) {
		super(maHang, tenHang, soLuongTon, donGia);
		this.congSuat = congSuat;
		this.dienAp = dienAp;
	}

	@Override
	public void hienThiThongTin() {
		System.out.printf("| %-10s | %-20s | %-10d | %-10.2f | %-10d | %-10d |\n", maHang, tenHang, soLuongTon, donGia,
				congSuat, dienAp);
	}

}
