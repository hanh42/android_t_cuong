package tdc.edu.appbanhangkhoapham.model;

public class LoaiSanPham {
    public int id;
    public String tenloaisannpham;
    private String hinhanhloaisanpham;

    public LoaiSanPham(int id, String tenloaisannpham, String hinhanhloaisanpham) {
        this.id = id;
        this.tenloaisannpham = tenloaisannpham;
        this.hinhanhloaisanpham = hinhanhloaisanpham;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenloaisannpham() {
        return tenloaisannpham;
    }

    public void setTenloaisannpham(String tenloaisannpham) {
        this.tenloaisannpham = tenloaisannpham;
    }

    public String getHinhanhloaisanpham() {
        return hinhanhloaisanpham;
    }

    public void setHinhanhloaisanpham(String hinhanhloaisanpham) {
        this.hinhanhloaisanpham = hinhanhloaisanpham;
    }

    @Override
    public String toString() {
        return "LoaiSanPham{" +
                "id=" + id +
                ", tenloaisannpham='" + tenloaisannpham + '\'' +
                ", hinhanhloaisanpham='" + hinhanhloaisanpham + '\'' +
                '}';
    }
}
