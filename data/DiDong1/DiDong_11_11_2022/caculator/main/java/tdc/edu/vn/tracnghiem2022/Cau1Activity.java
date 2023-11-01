package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class Cau1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau1_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        TextView lblQuestion =(TextView)findViewById(R.id.lblQuestion);
        final CheckBox chkA =(CheckBox) findViewById(R.id.btnDA1);
        final CheckBox chkB =(CheckBox) findViewById(R.id.btnDA2);
        final CheckBox chkC =(CheckBox) findViewById(R.id.btnDA3);
        final CheckBox chkD =(CheckBox) findViewById(R.id.btnDA4);

        Questions.init();
        MultiQuestionMultiChoices question = (MultiQuestionMultiChoices)Questions.questions.get(0);
        lblQuestion.setText(question.getQuesionDescription());
        chkA.setText(question.getQuestionChoices().get(0));
        chkB.setText(question.getQuestionChoices().get(1));
        chkC.setText(question.getQuestionChoices().get(2));
        chkD.setText(question.getQuestionChoices().get(3));


        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau1Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(chkA,chkB,chkC,chkD);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau1Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(chkA,chkB,chkC,chkD);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau1Activity.this, Cau2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(chkA,chkB,chkC,chkD);
                startActivity(intent);
            }
        });
    }

    private void userInteractionProcessing(CheckBox chkA,CheckBox chkB,CheckBox chkC,CheckBox chkD){
        Questions.questions.get(0).getQuestionAnswers().clear();
        if (chkA.isChecked()){
            Questions.questions.get(0).setQuestionAnswers(0);
        }
        if (chkB.isChecked()){
            Questions.questions.get(0).setQuestionAnswers(1);
        }
        if (chkC.isChecked()){
            Questions.questions.get(0).setQuestionAnswers(2);
        }
        if (chkD.isChecked()){
            Questions.questions.get(0).setQuestionAnswers(3);
        }
    }

}
