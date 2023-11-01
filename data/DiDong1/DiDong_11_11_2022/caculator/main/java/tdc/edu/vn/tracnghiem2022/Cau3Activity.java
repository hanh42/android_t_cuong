package tdc.edu.vn.tracnghiem2022;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import tdc.edu.vn.tracnghiem2022.data_models.MatchingQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class Cau3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cau3_layout);

        Button btn_pre = findViewById(R.id.btn_pre) ;
        Button btn_mid = findViewById(R.id.btn_mid) ;
        Button btn_next = findViewById(R.id.btn_next) ;
        TextView lblQuestion =(TextView)findViewById(R.id.lblQuestion);
        EditText edt1 = findViewById(R.id.edt1);
        EditText edt2 = findViewById(R.id.edt2);
        EditText edt3 = findViewById(R.id.edt3);

        final Spinner spn1 = findViewById(R.id.spn1);
        final Spinner spn2 = findViewById(R.id.spn2);
        final Spinner spn3 = findViewById(R.id.spn3);

        MatchingQuestion question = (MatchingQuestion) Questions.questions.get(2);
        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoicesA().get(0));
        edt2.setText(question.getQuestionChoicesA().get(1));
        edt3.setText(question.getQuestionChoicesA().get(2));

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,question.getQuestionChoicesB());
        spn1.setAdapter(spinAdapter);
        spn2.setAdapter(spinAdapter);
        spn3.setAdapter(spinAdapter);

        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau3Activity.this, Cau2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(spn1,spn2,spn3);
                startActivity(intent);
            }
        });

        btn_mid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau3Activity.this, Cau6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(spn1,spn2,spn3);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cau3Activity.this, Cau4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                userInteractionProcessing(spn1,spn2,spn3);
                startActivity(intent);
            }
        });
    }

    private void userInteractionProcessing(Spinner spn1, Spinner spn2,Spinner spn3){
        Questions.questions.get(2).getQuestionAnswers().clear();
        Questions.questions.get(2).setQuestionAnswers(spn1.getSelectedItemPosition());
        Questions.questions.get(2).setQuestionAnswers(spn2.getSelectedItemPosition());
        Questions.questions.get(2).setQuestionAnswers(spn3.getSelectedItemPosition());
    }

}
