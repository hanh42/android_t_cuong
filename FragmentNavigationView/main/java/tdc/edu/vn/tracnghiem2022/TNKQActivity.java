package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ListView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import java.io.Console;

import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MatchingQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionOneChoices;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuetionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;
import tdc.edu.vn.tracnghiem2022.fragments.AbstracsFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MatchingQuestionFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MultiQuestionMultiChoicesFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MultiQuestionOneChocesFragment;
import tdc.edu.vn.tracnghiem2022.fragments.TrueFalseQuestionSwitch;
import tdc.edu.vn.tracnghiem2022.fragments.TrueFalseQuestionToggleButtomFragment;
import tdc.edu.vn.tracnghiem2022.R;

public class TNKQActivity extends AppCompatActivity {
    private int questionID;
    private AbstracsFragment fragment;
    private FragmentTransaction transaction;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        Questions.init();
        questionID = 0;

        FrameLayout frameLayout = findViewById(R.id.drawerMainLayout);
        getLayoutInflater().inflate(R.layout.screen1, frameLayout);

        Button btnBack = findViewById(R.id.btnBack);
        Button btnNext = findViewById(R.id.btnNext);
        Button btnTinhDiem = findViewById(R.id.btnTinhDiem);
        ListView listView = findViewById(R.id.questionList);
        ArrayAdapter<AbstractQuestion> adapter = new ArrayAdapter<AbstractQuestion>(this,android.R.layout.simple_list_item_1,Questions.questions);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragment.setQuestionAnwser(questionID);
                questionID = position;
                drawerLayout.closeDrawer(Gravity.START);
                updateUI();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setQuestionAnwser(questionID);
                if (questionID == 0) {
                    questionID = Questions.questions.size() - 1;
                }
                else {
                    questionID--;
                }
                updateUI();

            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setQuestionAnwser(questionID);
                if (questionID == Questions.questions.size() - 1) {
                    questionID = 0;
                }
                else {
                    questionID++;
                }
                updateUI();
            }
        });
        btnTinhDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Questions.state = true;
                fragment.setQuestionAnwser(questionID);
                Intent intent = new Intent(TNKQActivity.this, KetQuaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout , R.string.drawerOpen , R.string.drawerClose);
        drawerLayout.addDrawerListener(drawerToggle);
        //Doongf booj
        drawerToggle.syncState();
    }

    //ToggleButton processing


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void userInteractionProcessing(CheckBox cbA, CheckBox cbB, CheckBox cbC, CheckBox cbD) {
        Questions.questions.get(0).getQuestionAnswers().clear();
        if (cbA.isChecked())
            Questions.questions.get(0).setQuestionAnswers(0);
        if (cbB.isChecked())
            Questions.questions.get(0).setQuestionAnswers(1);
        if (cbC.isChecked())
            Questions.questions.get(0).setQuestionAnswers(2);
        if (cbD.isChecked())
            Questions.questions.get(0).setQuestionAnswers(3);
    }

    private void updateUI(){
        setTitle("Cau: " + (questionID + 1));

        if (getSupportFragmentManager().findFragmentByTag(questionID+"") != null){
            fragment = (AbstracsFragment) getSupportFragmentManager().findFragmentByTag(questionID+"");
        }
        else {

            if (Questions.questions.get(questionID) instanceof MultiQuetionMultiChoices){
                fragment = new MultiQuestionMultiChoicesFragment();
            }
            if (Questions.questions.get(questionID) instanceof MultiQuestionOneChoices){
                fragment = new MultiQuestionOneChocesFragment();
            }
            if (Questions.questions.get(questionID) instanceof MatchingQuestion){
                fragment = new MatchingQuestionFragment();
            }
            if (Questions.questions.get(questionID) instanceof TrueFalseQuestion){

                if (questionID % 2 == 0)
                    fragment = new TrueFalseQuestionSwitch();
                else
                    fragment = new TrueFalseQuestionToggleButtomFragment();
            }
        }

        if (fragment != null){
            fragment.setQuestion(Questions.questions.get(questionID));
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment, questionID+"");
            if (getSupportFragmentManager().findFragmentByTag(questionID+"") == null){
                transaction.addToBackStack(questionID+"");
            }
            transaction.commit();
        }
    }
}
