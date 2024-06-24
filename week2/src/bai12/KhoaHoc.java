package bai12;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
public class KhoaHoc {
	private String tenKhoaHoc;
	private Date ngayMoKhoa;
	private String thoiGianHoc;
	private List<HocVien> dshv;
	public KhoaHoc(String tenKhoaHoc, Date ngayMoKhoa, String thoiGianHoc) {
		this.tenKhoaHoc = tenKhoaHoc;
		this.ngayMoKhoa = ngayMoKhoa;
		this.thoiGianHoc = thoiGianHoc;
		this.dshv = new ArrayList<>();
	}
	public String getTenKhoaHoc() {
		return tenKhoaHoc;
	}
	public Date getNgayMoKhoa() {
		return ngayMoKhoa;
	}
	public String getThoiGianHoc() {
		return thoiGianHoc;
	}
	public List<HocVien> getDshv() {
		return dshv;
	}
	public boolean themHocVien(HocVien hv) {
		if(dshv.size() < 20) {
			return dshv.add(hv);
		}
		return false;
	}
	 @Override
	    public String toString() {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        StringBuilder sb = new StringBuilder();
	        sb.append(String.format("%-20s %-15s %-10s\n", tenKhoaHoc, dateFormat.format(ngayMoKhoa), thoiGianHoc));
	        sb.append("Danh sách học viên:\n");
	        sb.append(String.format("%-20s %-30s %-15s\n", "Họ tên", "Địa chỉ", "Số điện thoại"));
	        for (HocVien hv : dshv) {
	            sb.append(hv).append("\n");
	        }
	        return sb.toString();
	    }
}
