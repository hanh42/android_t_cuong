package tdc.edu.whetherforecast.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import tdc.edu.whetherforecast.R;

public class MySlideIntroduceAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public MySlideIntroduceAdapter(Context context) {
        this.context = context;
    }

    public int[] slider_images = {
            R.drawable.strawberry,
            R.drawable.blueberry,
            R.drawable.grapes
    };


    public String[] slide_Heading = {
            "スライ1",
            "スライ2",
            "スライ3"
    };


    public String[] slide_string = {
            "バットマンは架空の人物であり、アーティストのボブ・ケインと作家のビル・フィンガーによって作成された漫画本のスーパーヒーローです.バットマンは最初に Detective Comics #27 に登場し、その後数多くの DC Comics の出版物に登場しています。",
            "スパイダーマンは、マーベル コミックが発行するコミックに登場する架空のスーパーヒーローです。このキャラクターは、ライターのスタン・リーとライター兼アーティストのスティーブ・ディッコによって作成され、アメイジング・ファンタジー #15 に初登場しました。",
            "スーパーマンは、DC コミックスが発行する同名の有名なアメリカン コミック シリーズに登場する架空のスーパー ヒーロー キャラクターです。スーパーマンは、1933 年にアメリカの作家ジェリー シーゲルとカナダ生まれのアーティスト ジョー シャスターによって当時オハイオ州クリーブランドに住んでいた高校生によって作成されました。"
    };

    @Override
    public int getCount() {
        return slide_Heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.introduce_page2, container, false);
        ImageView imageView = view.findViewById(R.id.ImageView_Main_ID);
        TextView txt_heading = view.findViewById(R.id.txt_heading);
        TextView txt_content = view.findViewById(R.id.txt_content);

        imageView.setImageResource(slider_images[position]);
        txt_heading.setText(slide_Heading[position]);
        txt_content.setText(slide_string[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
