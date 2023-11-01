package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class TrueFalseQuestionToggleButtomFragment extends AbstracsFragment {
    private TrueFalseQuestion question;
    private int questionID;
    private ToggleButton tgb1, tgb2, tgb3;

    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (TrueFalseQuestion) question;
    }

    @Override
    public void setQuestionAnwser(int questionID) {
        this.questionID =questionID;
        userInteractionProcessing(tgb1,tgb2,tgb3);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;

        fragmentLayout = inflater.inflate(R.layout.true_false_question_toggole_buttom,container,false);
        TextView txtViewCauHoi = fragmentLayout.findViewById(R.id.txtViewCauHoi);
        TextView tb1 = fragmentLayout.findViewById(R.id.tb1);
        TextView tb2 = fragmentLayout.findViewById(R.id.tb2);
        TextView tb3 = fragmentLayout.findViewById(R.id.tb3);
        tgb1 = fragmentLayout.findViewById(R.id.tgb1);
        tgb2 = fragmentLayout.findViewById(R.id.tgb2);
        tgb3 = fragmentLayout.findViewById(R.id.tgb3);


        //Set data
        txtViewCauHoi.setText(question.getQuestionDescription());
        tb1.setText(question.getQuetionChoices().get(0));
        tb2.setText(question.getQuetionChoices().get(1));
        tb3.setText(question.getQuetionChoices().get(2));
        return fragmentLayout;
    }
    private void userInteractionProcessing(ToggleButton tgb1, ToggleButton tgb2, ToggleButton tgb3) {

        Questions.questions.get(questionID).getQuestionAnswers().clear();
        if (tgb1.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }
        if (tgb2.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }
        if (tgb3.isChecked()) {
            Questions.questions.get(questionID).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionID).setQuestionAnswers(0);
        }

    }
}
