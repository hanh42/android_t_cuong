package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MultiQuestionMultiChoices;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class MultiQuestionMultiChoiceFragment extends AbstractFragment {
    private MultiQuestionMultiChoices question ;
    private int questionId;
    private CheckBox chkA, chkB , chkC , chkD;
    @Override
    public void setQuestion(AbtracQuestion question) {
        this.question = (MultiQuestionMultiChoices) question;
    }

    @Override
    public void setQuestionAnswer(int questionId) {
        Questions.questions.get(questionId).getQuestionAnswers().clear();
        if (chkA.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (chkB.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        if (chkC.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(2);
        }
        if (chkD.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(3);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.multi_question_multi_choices_fragment,container, false);

        TextView lblQuestion =(TextView)fragmentLayout.findViewById(R.id.lblQuestion);
        chkA =(CheckBox) fragmentLayout.findViewById(R.id.btnDA1);
        chkB =(CheckBox) fragmentLayout.findViewById(R.id.btnDA2);
        chkC =(CheckBox) fragmentLayout.findViewById(R.id.btnDA3);
        chkD =(CheckBox) fragmentLayout.findViewById(R.id.btnDA4);

        lblQuestion.setText(question.getQuesionDescription());
        chkA.setText(question.getQuestionChoices().get(0));
        chkB.setText(question.getQuestionChoices().get(1));
        chkC.setText(question.getQuestionChoices().get(2));
        chkD.setText(question.getQuestionChoices().get(3));

        return fragmentLayout;
    }
}
