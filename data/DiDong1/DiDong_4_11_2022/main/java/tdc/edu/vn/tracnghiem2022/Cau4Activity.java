package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class Cau4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau4_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        TextView lblQuestion =(TextView)findViewById(R.id.lblQuestion);

        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        EditText edt3 = findViewById(R.id.edt3);
        Questions.init();
        TrueFalseQuestion question = (TrueFalseQuestion) Questions.questions.get(3);
        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoices().get(0));
        edt2.setText(question.getQuestionChoices().get(1));
        edt3.setText(question.getQuestionChoices().get(2));

        final ToggleButton tlb1 = findViewById(R.id.tlb1);
        final ToggleButton tlb2 = findViewById(R.id.tlb2);
        final ToggleButton tlb3 = findViewById(R.id.tlb3);
        final ToggleButton tlb4 = findViewById(R.id.tlb4);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau4Activity.this, Cau3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau4Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau4Activity.this, Cau5Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(tlb1,tlb2,tlb3,tlb4);
                startActivity(intent);
            }
        });
    }

    private void userInteractionProcessing(ToggleButton tlb1,ToggleButton tlb2,ToggleButton tlb3,ToggleButton tlb4){
        if (tlb1.isChecked()){
            Questions.questions.get(3).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(3).setQuestionAnswers(0);
        }
        if (tlb2.isChecked()){
            Questions.questions.get(3).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(3).setQuestionAnswers(0);
        }
        if (tlb3.isChecked()){
            Questions.questions.get(3).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(3).setQuestionAnswers(0);
        }
        if (tlb4.isChecked()){
            Questions.questions.get(3).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(3).setQuestionAnswers(0);
        }
    }
}
