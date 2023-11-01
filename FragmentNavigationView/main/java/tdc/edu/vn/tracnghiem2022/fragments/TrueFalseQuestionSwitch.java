package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class TrueFalseQuestionSwitch extends AbstracsFragment {
    private TrueFalseQuestion question;
    private int questionID;
    private Switch sw1,sw2,sw3;
    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (TrueFalseQuestion) question;
    }

    @Override
    public void setQuestionAnwser(int questionID) {
        this.questionID = questionID;
        userInteractionProcessing(sw1,sw2,sw3);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;

        fragmentLayout = inflater.inflate(R.layout.true_false_question_switch,container,false);
        TextView txtViewCauHoi = fragmentLayout.findViewById(R.id.txtViewCauHoi);
        TextView tb1 = fragmentLayout.findViewById(R.id.txt1);
        TextView tb2 = fragmentLayout.findViewById(R.id.txt2);
        TextView tb3 = fragmentLayout.findViewById(R.id.txt3);
        sw1 = fragmentLayout.findViewById(R.id.sw1);
        sw2 = fragmentLayout.findViewById(R.id.sw2);
        sw3 = fragmentLayout.findViewById(R.id.sw3);

        //Set data
        txtViewCauHoi.setText(question.getQuestionDescription());
        tb1.setText(question.getQuetionChoices().get(0));
        tb2.setText(question.getQuetionChoices().get(1));
        tb3.setText(question.getQuetionChoices().get(2));
        return fragmentLayout;
    }
    private void userInteractionProcessing(Switch sw1, Switch sw2, Switch sw3) {

        Questions.questions.get(questionID).getQuestionAnswers().clear();
        if (sw1.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }
        if (sw2.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }
        if (sw3.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }

    }
}
