package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionOneChoices;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuetionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class MultiQuestionMultiChoicesFragment extends AbstracsFragment {
    private MultiQuetionMultiChoices question;
    private int questionID;
    private CheckBox cbA, cbB,cbC,cbD;

    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (MultiQuetionMultiChoices) question;
    }

    @Override
    public void setQuestionAnwser(int questionID) {
        this.questionID = questionID;
        userInteractionProcessing(cbA, cbB, cbC,cbD);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout;

        fragmentLayout = inflater.inflate(R.layout.multi_quetion_multi_choices_fragment, container, false);

        TextView lblQuestion = fragmentLayout.findViewById(R.id.lblQuestion);
        cbA = fragmentLayout.findViewById(R.id.cbA);
        cbB = fragmentLayout.findViewById(R.id.cbB);
        cbC = fragmentLayout.findViewById(R.id.cbC);
        cbD = fragmentLayout.findViewById(R.id.cbD);


        //Set data
        lblQuestion.setText(question.getQuestionDescription());
        cbA.setText(question.getQuetionChoices().get(0));
        cbB.setText(question.getQuetionChoices().get(1));
        cbC.setText(question.getQuetionChoices().get(2));
        cbD.setText(question.getQuetionChoices().get(3));
        return fragmentLayout;
    }
    private void userInteractionProcessing(CheckBox cbA, CheckBox cbB, CheckBox cbC, CheckBox cbD) {
        Questions.questions.get(questionID).getQuestionAnswers().clear();
        if (cbA.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(0);
        if (cbB.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(1);
        if (cbC.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(2);
        if (cbD.isChecked())
            Questions.questions.get(questionID).setQuestionAnswers(3);
    }
}
