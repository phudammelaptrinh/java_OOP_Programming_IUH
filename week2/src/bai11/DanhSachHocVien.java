package bai11;

import java.util.ArrayList;
import java.util.List;

public class DanhSachHocVien {
    private List<HocVien> hocVienList;

    public DanhSachHocVien() {
        this.hocVienList = new ArrayList<>();
    }

    public void themHocVien(HocVien hv) {
        hocVienList.add(hv);
    }

    public int soHocVienLamLuanVan() {
        int count = 0;
        for (HocVien hv : hocVienList) {
            if (hv.isThesis()) {
                count++;
            }
        }
        return count;
    }

    public int soHocVienThiTotNghiep() {
        int count = 0;
        for (HocVien hv : hocVienList) {
            if (hv.isGraduationExam()) {
                count++;
            }
        }
        return count;
    }

    public int soHocVienThiLai() {
        int count = 0;
        for (HocVien hv : hocVienList) {
            if (hv.isRetakeExam()) {
                count++;
            }
        }
        return count;
    }

    public void xuatThongTinHocVien() {
        for (HocVien hv : hocVienList) {
            System.out.println(hv);
        }
    }
}
