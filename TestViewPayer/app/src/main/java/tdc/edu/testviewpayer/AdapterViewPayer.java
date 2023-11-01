package tdc.edu.testviewpayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterViewPayer extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public AdapterViewPayer(Context context) {
        this.context = context;
    }

    public int[] ImageArray = {
            R.drawable.pic1,
            R.drawable.sakura,
            R.drawable.up
    };

    public String[] ContentArray =
            {
                    "バットマンは架空の人物であり、アーティストのボブ・ケインと作家のビル・フィンガーによって作成され" +
                            "た漫画本のスーパーヒーローです.バットマンは最初に Detective Comics #27 に登場し、" +
                            "その後数多くの DC Comics の出版物に登場しています。",
                    "スパイダーマンは、マーベル コミックが発行するコミックに登場する架空のスーパーヒーローです。" +
                            "このキャラクターは、ライターのスタン・リーとライター兼アーティストのスティーブ・ディッコによっ" +
                            "て作成され、アメイジング・ファンタジー #15 に初登場しました。",
                    "スーパーマンは、DC コミックスが発行する同名の有名なアメリカン コミック シリーズに登場する架空のスーパー" +
                            " ヒーロー キャラクターです。スーパーマンは、1933 年にアメリカの作家ジェリー シーゲルとカナダ生まれのア" +
                            "ーティスト ジョー シャスターによって当時オハイオ州クリーブランドに住んでいた高校生によって作成されました。"
            };

    @Override
    public int getCount() {
        return ImageArray.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.introduce_item,container,false);
        ImageView imageView = view.findViewById(R.id.image_view);
        TextView textView = view.findViewById(R.id.txt_content);
        imageView.setImageResource(ImageArray[position]);
        textView.setText(ContentArray[position]);
        container.addView(view);
        return view;
    };

    //    //content.
//    Context context;
//    //Layoutinflater.
//    LayoutInflater layoutInflater;
//
//    public AdapterViewPayer(Context context) {
//        this.context = context;
//    }
//
//    public int[] ImageArray = {
//            R.drawable.pic1,
//            R.drawable.sakura,
//            R.drawable.up
//    };
//
//    public String[] ContentArray =
//            {
//                    "バットマンは架空の人物であり、アーティストのボブ・ケインと作家のビル・フィンガーによって作成され" +
//                            "た漫画本のスーパーヒーローです.バットマンは最初に Detective Comics #27 に登場し、" +
//                            "その後数多くの DC Comics の出版物に登場しています。",
//                    "スパイダーマンは、マーベル コミックが発行するコミックに登場する架空のスーパーヒーローです。" +
//                            "このキャラクターは、ライターのスタン・リーとライター兼アーティストのスティーブ・ディッコによっ" +
//                            "て作成され、アメイジング・ファンタジー #15 に初登場しました。",
//                    "スーパーマンは、DC コミックスが発行する同名の有名なアメリカン コミック シリーズに登場する架空のスーパー" +
//                            " ヒーロー キャラクターです。スーパーマンは、1933 年にアメリカの作家ジェリー シーゲルとカナダ生まれのア" +
//                            "ーティスト ジョー シャスターによって当時オハイオ州クリーブランドに住んでいた高校生によって作成されました。"
//            };
//
//    @Override
//    public int getCount() {
//        return ImageArray.length;
//    }
//
//    //return view  == (relativelayout) object;
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == (RelativeLayout) object;
//    }
//
//    @NonNull
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup container, int position) {
//        //Definition layout
//        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//        //Definition view
//        View view = layoutInflater.inflate(R.layout.introduce_item, container, false);
//        ImageView imageView = view.findViewById(R.id.image_view);
//        TextView textView = view.findViewById(R.id.txt_content);
//        imageView.setImageResource(ImageArray[position]);
//        textView.setText(ContentArray[position]);
//        container.addView(view);
//        return view;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        container.removeView((RelativeLayout) object);
//    }
}
