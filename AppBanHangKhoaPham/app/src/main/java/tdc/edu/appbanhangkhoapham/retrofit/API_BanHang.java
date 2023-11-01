package tdc.edu.appbanhangkhoapham.retrofit;

import java.util.Observable;

import retrofit2.http.GET;
import tdc.edu.appbanhangkhoapham.model.LoaiSanPhamModel;

public interface API_BanHang {
    @GET("getloaisanpham.php")
     Observable<LoaiSanPhamModel> getLoaiSanPham();
}
