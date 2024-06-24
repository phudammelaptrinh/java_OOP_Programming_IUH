package bai8;

import java.util.Arrays;

public class CDList { // Ensure the class name matches the file name (CDList.java)
    private CD[] cds;
    private int dem;

    public CDList(int n) {
        if (n > 0) {
            cds = new CD[n];
            dem = 0;
        } else {
            cds = new CD[0];
            dem = 0;
        }
    }

    // Corrected method signature to include the return type
    public boolean themCD(CD cd) {
        if (dem < cds.length) {
            for (int i = 0; i < dem; i++) {
                if (cds[i].getMaCD() == cd.getMaCD()) {
                    return false;
                }
            }
            cds[dem++] = cd;
            return true;
        }
        return false;
    }

    public int soLuongCD() {
        return dem;
    }

    public double tongGiaThanh() {
        double tong = 0;
        int i = 0;
        while (i < dem) {
            tong += cds[i].getGiaThanh();
            i++; // Corrected increment of the index
        }
        return tong;
    }

    public String thongTinTatCaCD() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dem; i++) {
            sb.append(cds[i].toString()).append("\n");
        }
        return sb.toString();
    }

    public void sapXepTheoTuaCD() {
        Arrays.sort(cds, 0, dem, (cd1, cd2) -> cd1.getTuaCD().compareTo(cd2.getTuaCD()));
    }
}
