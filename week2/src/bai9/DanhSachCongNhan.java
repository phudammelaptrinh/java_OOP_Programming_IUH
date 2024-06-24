package bai9;

import java.util.Arrays;

public class DanhSachCongNhan {
    private CongNhan[] cnl;
    private int dem;

    public DanhSachCongNhan(int n) {
        if (n > 0) {
            cnl = new CongNhan[n];
            dem = 0;
        } else {
            cnl = new CongNhan[0];
            dem = 0;
        }
    }

    public boolean them(CongNhan cn) {
        if (dem < cnl.length) {
            cnl[dem++] = cn;
            return true;
        }
        return false;
    }

    public void xuatThongTinALL() {
        int i = 0;
        while (i < dem) {
            System.out.println(cnl[i]);
            i++; // Moved increment inside the loop
        }
    }

    public int soLuongCongNhan() {
        return dem;
    }

    public void xuatCN200SP() {
        for (int i = 0; i < dem; i++) {
            if (cnl[i].getSoSP() > 200) { // Corrected method name to match CongNhan class
                System.out.println(cnl[i]);
            }
        }
    }

    public void sapXepTheoSoSPGiamDan() { // Corrected method name for proper naming
        Arrays.sort(cnl, 0, dem, (cn1, cn2) -> cn2.getSoSP() - cn1.getSoSP());
    }
}
