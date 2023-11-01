package tdc.edu.vn.quanlynhansu;

public class Persion {
    private String hoVaTen;
    private String bangCap;
    private String soThich;

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getBangCap() {
        return bangCap;
    }

    public void setBangCap(String bangCap) {
        this.bangCap = bangCap;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public Persion() {
    }

    public Persion(String hoVaTen, String bangCap, String soThich) {
        this.hoVaTen = hoVaTen;
        this.bangCap = bangCap;
        this.soThich = soThich;
    }

    @Override
    public String toString() {
        return hoVaTen + "#" + bangCap + "#" + soThich;
    }
}
