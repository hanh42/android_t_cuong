package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.MutilQuestionOneChoice;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.view_models.MyRadioGroup;

public class Cau2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau2_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        TextView lblQuestion =(TextView)findViewById(R.id.lblQuestion);
        final RadioButton radA =(RadioButton) findViewById(R.id.btnDA1);
        final RadioButton radB =(RadioButton) findViewById(R.id.btnDA2);
        final RadioButton radC =(RadioButton) findViewById(R.id.btnDA3);
        final RadioButton radD =(RadioButton) findViewById(R.id.btnDA4);

        Questions.init();
        MutilQuestionOneChoice question = (MutilQuestionOneChoice)Questions.questions.get(1);
        lblQuestion.setText(question.getQuesionDescription());
        radA.setText(question.getQuestionChoices().get(0));
        radB.setText(question.getQuestionChoices().get(1));
        radC.setText(question.getQuestionChoices().get(2));
        radD.setText(question.getQuestionChoices().get(3));

        MyRadioGroup myRadioGroup = new MyRadioGroup(radA,radB,radC,radD);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau2Activity.this, Cau1Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(radA,radB,radC,radD);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau2Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(radA,radB,radC,radD);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau2Activity.this, Cau3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(radA,radB,radC,radD);
                startActivity(intent);
            }
        });
    }

    private void userInteractionProcessing(RadioButton radA,RadioButton radB,RadioButton radC,RadioButton radD){
        Questions.questions.get(1).getQuestionAnswers().clear();
        if (radA.isChecked()){
            Questions.questions.get(1).setQuestionAnswers(0);
        }
        if (radB.isChecked()){
            Questions.questions.get(1).setQuestionAnswers(1);
        }
        if (radC.isChecked()){
            Questions.questions.get(1).setQuestionAnswers(2);
        }
        if (radD.isChecked()){
            Questions.questions.get(1).setQuestionAnswers(3);
        }
    }
}
