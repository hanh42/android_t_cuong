package tdc.edu.appbanhangkhoapham.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import tdc.edu.appbanhangkhoapham.R;
import tdc.edu.appbanhangkhoapham.model.LoaiSanPham;

public class LoaiSanPhamAdapter extends BaseAdapter {
    List<LoaiSanPham> loaiSanPhamArrayAdapter;
    Context context;

    public LoaiSanPhamAdapter(List<LoaiSanPham> loaiSanPhamArrayAdapter, Context context) {
        this.loaiSanPhamArrayAdapter = loaiSanPhamArrayAdapter;
        this.context = context;
    }

    @Override
    public int getCount() {
        return loaiSanPhamArrayAdapter.size();
    }

    @Override
    public Object getItem(int i) {
        return loaiSanPhamArrayAdapter.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder {
        TextView textViewLSP;
        ImageView imageViewLSP;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_lisview_loaisanpham, null);
            viewHolder.textViewLSP = view.findViewById(R.id.tenloai_sp);
            viewHolder.imageViewLSP = view.findViewById(R.id.img_loaisp);
            view.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) view.getTag();
            LoaiSanPham loaiSanPham = (LoaiSanPham) getItem(i);
            viewHolder.textViewLSP.setText(loaiSanPham.getTenloaisannpham());
            Glide.with(context).load(loaiSanPhamArrayAdapter.get(i).getHinhanhloaisanpham()).into(viewHolder.imageViewLSP);

        }
        return view;
    }

}
