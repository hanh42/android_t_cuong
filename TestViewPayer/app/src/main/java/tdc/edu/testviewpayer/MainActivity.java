package tdc.edu.testviewpayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AdapterViewPayer adapterViewPayer;
    ViewPager custome_wapper;
    Button next, prev;
    LinearLayout center, main_layout;
    TextView txt_content;
    int[] mDot = new int[3];
    int currentPage = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduce_main);
        txt_content = findViewById(R.id.txt_content);
        adapterViewPayer = new AdapterViewPayer(this);
        custome_wapper = findViewById(R.id.viewpayer_id);
        custome_wapper.setAdapter(adapterViewPayer);
        prev = findViewById(R.id.left);
        next = findViewById(R.id.right);
        custome_wapper.addOnPageChangeListener(onPageChangeListener);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage < mDot.length - 1) {
                    custome_wapper.setCurrentItem(currentPage += 1);
                } else {

                }
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPage != 0) {
                    custome_wapper.setCurrentItem(currentPage -= 1);
                } else {

                }
            }
        });
    }


    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @SuppressLint("ResourceAsColor")
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            if (position == 0) {
                prev.setEnabled(false);
                prev.setVisibility(View.INVISIBLE);
                next.setText("");
            } else if (position == mDot.length - 1) {
                next.setText("Finish");
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
            } else {
                next.setText("");
                prev.setEnabled(true);
                prev.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };
}