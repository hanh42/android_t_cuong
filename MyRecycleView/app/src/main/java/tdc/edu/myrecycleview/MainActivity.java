package tdc.edu.myrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import tdc.edu.myrecycleview.model.Person;
import tdc.edu.myrecycleview.my_recycle_view.MyRecycleView;

public class MainActivity extends AppCompatActivity {
    private int selectedRow = -1;
    private int backColor;
    private LinearLayout previouslayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView listView = findViewById(R.id.RecyclerView_ID);
        ArrayList<Person> personArrayList = new ArrayList<>();
        Person person1 = new Person("Chu dinh hanh1", "choi xe");
        Person person2 = new Person("Chu dinh hanh2", "choi xe");
        Person person3 = new Person("Chu dinh hanh3", "choi xe");
        Person person4 = new Person("Chu dinh hanh4", "choi xe");
        Person person5 = new Person("Chu dinh hanh5", "choi xe");
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        personArrayList.add(person4);
        personArrayList.add(person5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(layoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        MyRecycleView myRecycleView = new MyRecycleView(this, R.layout.customize_recyclerview_item, personArrayList);
        listView.setAdapter(myRecycleView);
        myRecycleView.set_onRecycleViewItemClickListener(new MyRecycleView.OnRecycleViewItemClickListener() {
            @Override
            public void onItemClickListener(int p, View cardView) {
                if (selectedRow == -1) {
                    selectedRow = p;
                    LinearLayout linearLayout = cardView.findViewById(R.id.LinearLayout_ID);
                    backColor = linearLayout.getSolidColor();
                    previouslayout = linearLayout;
                    linearLayout.setBackground(getResources().getDrawable(R.color.black,getTheme()));
                }else{
                    if(selectedRow == p){
                        previouslayout.setBackgroundColor(backColor);
                        selectedRow = -1;
                    }else{
                        selectedRow = p;
                        previouslayout.setBackgroundColor(backColor);
                        LinearLayout linearLayout = cardView.findViewById(R.id.LinearLayout_ID);
                        backColor = linearLayout.getSolidColor();
                        previouslayout = linearLayout;
                        linearLayout.setBackground(getResources().getDrawable(R.color.black,getTheme()));

                    }
                }
            }
        });

    }
}