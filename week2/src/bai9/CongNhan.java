package bai9;

public class CongNhan {
    private String mHo;
    private String mTen;
    private int mSoSP;

    // Default constructor
    public CongNhan() {
        this.mHo = "";
        this.mTen = "";
        this.mSoSP = 0;
    }

    // Parameterized constructor
    public CongNhan(String mHo, String mTen, int mSoSP) {
        this.mHo = mHo;
        this.mTen = mTen;
        this.mSoSP = (mSoSP > 0) ? mSoSP : 0;
    }

    // Getter and Setter methods
    public String getHo() {
        return mHo;
    }

    public void setHo(String mHo) {
        this.mHo = mHo;
    }

    public String getTen() {
        return mTen;
    }

    public void setTen(String mTen) {
        this.mTen = mTen;
    }

    public int getSoSP() {
        return mSoSP;
    }

    public void setSoSP(int mSoSP) {
        if (mSoSP > 0) {
            this.mSoSP = mSoSP;
        }
    }

    // Method to calculate salary
    public double tinhLuong() {
        double donGia;
        if (mSoSP >= 1 && mSoSP <= 199) {
            donGia = 0.5;
        } else if (mSoSP >= 200 && mSoSP <= 399) {
            donGia = 0.55;
        } else if (mSoSP >= 400 && mSoSP <= 599) {
            donGia = 0.6;
        } else {
            donGia = 0.65;
        }
        return mSoSP * donGia;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
                "Ho='" + mHo + '\'' +
                ", Ten='" + mTen + '\'' +
                ", SoSP=" + mSoSP +
                ", Luong=" + tinhLuong() +
                '}';
    }
}
