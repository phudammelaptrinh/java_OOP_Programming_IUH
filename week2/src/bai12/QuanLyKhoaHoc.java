package bai12;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;

public class QuanLyKhoaHoc {
    private List<KhoaHoc> dskh;

    public QuanLyKhoaHoc() {
        this.dskh = new ArrayList<>();
    }

    public boolean themKhoaHoc(KhoaHoc kh) {
        return dskh.add(kh);
    }

    public KhoaHoc timKhoaHoc(String tenKhoaHoc) {
        for (KhoaHoc kh : dskh) {
            if (kh.getTenKhoaHoc().equalsIgnoreCase(tenKhoaHoc)) {
                return kh;
            }
        }
        return null;
    }

    public List<KhoaHoc> khoaHocCuaHocVien(String hoTen) {
        List<KhoaHoc> ketqua = new ArrayList<>();
        for (KhoaHoc kh : dskh) {
            for (HocVien hv : kh.getDshv()) {
                if (hv.getHoTen().equalsIgnoreCase(hoTen)) {
                    ketqua.add(kh);
                }
            }
        }
        return ketqua;
    }

    public List<KhoaHoc> khoaHocChuaKetThuc(Date currentDate) {
        List<KhoaHoc> ketqua = new ArrayList<>();
        for (KhoaHoc kh : dskh) {
            if (kh.getNgayMoKhoa().before(currentDate)) {
                ketqua.add(kh);
            }
        }
        return ketqua;
    }

    public List<KhoaHoc> khoaHocChuaBatDau(Date currentDate) {
        List<KhoaHoc> ketqua = new ArrayList<>();
        for (KhoaHoc kh : dskh) {
            if (kh.getNgayMoKhoa().after(currentDate)) {
                ketqua.add(kh);
            }
        }
        return ketqua;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-20s %-15s %-10s\n", "Tên khóa học", "Ngày mở", "Thời gian"));
        sb.append("------------------------------------------------------\n");
        for (KhoaHoc kh : dskh) {
            sb.append(kh).append("\n");
        }
        return sb.toString();
    }
}
