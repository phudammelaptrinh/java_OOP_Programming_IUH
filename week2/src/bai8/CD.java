package bai8;

public class CD {
    private int maCD;
    private String tuaCD;
    private int soBaiHat;
    private double giaThanh;

    // Constructor, getters, setters, and toString method as previously defined

    public CD() {
        this.maCD = 999999;
        this.tuaCD = "chưa xác định";
        this.soBaiHat = 1;
        this.giaThanh = 1.0;
    }

    public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
        if (maCD > 0) this.maCD = maCD;
        else this.maCD = 999999;

        if (tuaCD != null && !tuaCD.isEmpty()) this.tuaCD = tuaCD;
        else this.tuaCD = "chưa xác định";

        if (soBaiHat > 0) this.soBaiHat = soBaiHat;
        else this.soBaiHat = 1;

        if (giaThanh > 0) this.giaThanh = giaThanh;
        else this.giaThanh = 1.0;
    }

    // Getter and Setter methods
    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        if (maCD > 0) this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        if (tuaCD != null && !tuaCD.isEmpty()) this.tuaCD = tuaCD;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        if (giaThanh > 0) this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return "CD{" +
                "maCD=" + maCD +
                ", tuaCD='" + tuaCD + '\'' +
                ", soBaiHat=" + soBaiHat +
                ", giaThanh=" + giaThanh +
                '}';
    }
}
