package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionOneChoices;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.view_model.MyRadioGroup;

public class MultiQuestionOneChocesFragment extends AbstracsFragment {
    private MultiQuestionOneChoices question;
    private RadioButton rad1,rad2, rad3,rad4;
    private int questionID;
    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (MultiQuestionOneChoices) question;
    }

    @Override
    public void setQuestionAnwser(int questionID) {
        this.questionID = questionID;
        userInteractionProcessing(rad1,rad2,rad3,rad4);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.multi_quetion_one_choices_fragment, container, false);
        TextView lblQuestion = fragmentLayout.findViewById(R.id.txtViewCauHoi);
        rad1 = fragmentLayout.findViewById(R.id.rad1);
        rad2 = fragmentLayout.findViewById(R.id.rad2);
        rad3 = fragmentLayout.findViewById(R.id.rad3);
        rad4 = fragmentLayout.findViewById(R.id.rad4);
        MyRadioGroup radioGroup = new MyRadioGroup(rad1,rad2,rad3,rad4);



        //Set data
        lblQuestion.setText(question.getQuestionDescription());
        rad1.setText(question.getQuetionChoices().get(0));
        rad2.setText(question.getQuetionChoices().get(1));
        rad3.setText(question.getQuetionChoices().get(2));
        rad4.setText(question.getQuetionChoices().get(3));

        return fragmentLayout;
    }
    private void userInteractionProcessing(RadioButton radA, RadioButton radB,RadioButton radC, RadioButton radD) {
        Questions.questions.get(questionID).getQuestionAnswers().clear();
        if (radA.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(0);
        if (radB.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(1);
        if (radC.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(2);
        if (radD.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(3);
    }
}
