package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tdc.edu.vn.tracnghiem2022.data_models.MatchingQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.MutilQuestionOneChoice;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;
import tdc.edu.vn.tracnghiem2022.fragments.AbstractFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MatchingQuestionFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MultiQestionOneChoiceFragment;
import tdc.edu.vn.tracnghiem2022.fragments.MultiQuestionMultiChoiceFragment;
import tdc.edu.vn.tracnghiem2022.fragments.TrueFalseQuestionAFragment;
import tdc.edu.vn.tracnghiem2022.fragments.TrueFalseQuestionBFragment;

public class TNKQActivity extends AppCompatActivity {
    private int questionId;
    private AbstractFragment fragment = null;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tnkq_layout);

        Button btn_pre = findViewById(R.id.btn_pre);
        Button btn_mid = findViewById(R.id.btn_mid);
        Button btn_next = findViewById(R.id.btn_next);

        Questions.init();
        questionId = 0;

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setQuestionAnswer(questionId);
                if (questionId == 0) {
                    questionId = Questions.questions.size() - 1;
                } else {
                    questionId--;
                }
                updateUI();
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setQuestionAnswer(questionId);
                Intent intent = new Intent(TNKQActivity.this, KQActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.setQuestionAnswer(questionId);
                if (questionId == Questions.questions.size() - 1) {
                    questionId = 0;
                } else {
                    questionId++;
                }
                updateUI();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        setTitle("Cau so: " + (questionId + 1));
        if (getSupportFragmentManager().findFragmentByTag(questionId + "") != null) {
            fragment =(AbstractFragment) getSupportFragmentManager().findFragmentByTag(questionId + "");
        } else {
            if (Questions.questions.get(questionId) instanceof MultiQuestionMultiChoices) {
                fragment = new MultiQuestionMultiChoiceFragment();
            } else if (Questions.questions.get(questionId) instanceof MutilQuestionOneChoice) {
                fragment = new MultiQestionOneChoiceFragment();
            } else if (Questions.questions.get(questionId) instanceof MatchingQuestion) {
                fragment = new MatchingQuestionFragment();
            } else if (Questions.questions.get(questionId) instanceof TrueFalseQuestion) {
                if (questionId % 2 == 0) {
                    fragment = new TrueFalseQuestionBFragment();
                } else {
                    fragment = new TrueFalseQuestionAFragment();
                }
            }
        }
        if (fragment != null) {
            fragment.setQuestion(Questions.questions.get(questionId));
            transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainer, fragment, questionId + "");
            if (getSupportFragmentManager().findFragmentByTag(questionId + "") == null) {
                transaction.addToBackStack(null);
            }
            transaction.commit();
        }
    }

}
