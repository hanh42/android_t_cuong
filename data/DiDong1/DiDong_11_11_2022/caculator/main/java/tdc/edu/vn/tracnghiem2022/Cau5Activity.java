package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class Cau5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau5_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        TextView lblQuestion =(TextView)findViewById(R.id.lblQuestion);
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        EditText edt3 = findViewById(R.id.edt3);

        TrueFalseQuestion question = (TrueFalseQuestion) Questions.questions.get(4);
        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoices().get(0));
        edt2.setText(question.getQuestionChoices().get(1));
        edt3.setText(question.getQuestionChoices().get(2));

        final Switch swi1 = findViewById(R.id.swt1);
        final Switch swi2 = findViewById(R.id.swt2);
        final Switch swi3 = findViewById(R.id.swt3);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau5Activity.this, Cau4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(swi1,swi2,swi3);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau5Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(swi1,swi2,swi3);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau5Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(swi1,swi2,swi3);
                startActivity(intent);
            }
        });
    }

    private void userInteractionProcessing(Switch swt1,Switch swt2,Switch swt3){
        Questions.questions.get(4).getQuestionAnswers().clear();
        if (swt1.isChecked()){
            Questions.questions.get(4).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(4).setQuestionAnswers(0);
        }
        if (swt2.isChecked()){
            Questions.questions.get(4).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(4).setQuestionAnswers(0);
        }
        if (swt3.isChecked()){
            Questions.questions.get(4).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(4).setQuestionAnswers(0);
        }
    }
}