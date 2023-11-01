package tdc.edu.appbanhangbeta10.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import tdc.edu.appbanhangbeta10.R;
import tdc.edu.appbanhangbeta10.adapter.SliderAdapter;

public class IntroducePageActivity1 extends AppCompatActivity {

    private Button prev, next;
    private ViewPager mSliderViewPaper;
    private LinearLayout mDoLayout;
    private SliderAdapter sliderAdapter;
    private TextView[] mDot;
    private int curentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introducepage_1);
        anhXa();
        sliderAdapter = new SliderAdapter(this);
        mSliderViewPaper.setAdapter(sliderAdapter);


        addDotIndicator(0);
        mSliderViewPaper.addOnPageChangeListener(viewListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mDot.length-1 > curentPage){
                    mSliderViewPaper.setCurrentItem(curentPage+=1);
                }else{
                    Intent intent = new Intent(IntroducePageActivity1.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSliderViewPaper.setCurrentItem(curentPage-=1);
            }
        });
    }

    public void anhXa() {
        prev = findViewById(R.id.btn_prev);
        next = findViewById(R.id.btn_next);
        mSliderViewPaper = findViewById(R.id.mSliderViewPaper);
        mDoLayout = findViewById(R.id.mDolayout);
    }

    public void addDotIndicator(int positions) {
        mDot = new TextView[3];
        mDoLayout.removeAllViews();
        for (int i = 0; i < mDot.length; i++) {
            mDot[i] = new TextView(this);
            mDot[i].setText(Html.fromHtml("&#8226;"));
            mDot[i].setTextSize(40);
            mDot[i].setTextColor(getResources().getColor(R.color.black));
            mDoLayout.addView(mDot[i]);
        }
        if (mDot.length > 0) {
            mDot[positions].setTextColor(getResources().getColor(R.color.purple_200));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            addDotIndicator(position);
            if (position == 0) {
                next.setEnabled(true);
                prev.setEnabled(false);
                prev.setText("");
                prev.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

            } else if (mDot.length-1 == position) {
                next.setEnabled(true);
                next.setVisibility(View.VISIBLE);
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
                next.setText("FINISH");
            } else {
                next.setText("NEXT");
                prev.setEnabled(true);
                next.setEnabled(true);
                prev.setText("PREVIOUS");
                prev.setVisibility(View.VISIBLE);
                next.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}