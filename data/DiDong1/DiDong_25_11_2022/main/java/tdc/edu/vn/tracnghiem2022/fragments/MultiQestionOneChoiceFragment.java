package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MutilQuestionOneChoice;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.view_models.MyRadioGroup;

public class MultiQestionOneChoiceFragment extends AbstractFragment {
    private MutilQuestionOneChoice question;
    private int questionId;
    RadioButton radA, radB,radC,radD;
    @Override
    public void setQuestion(AbtracQuestion question) {
        this.question = (MutilQuestionOneChoice) question;
    }

    @Override
    public void setQuestionAnswer(int questionId) {
        Questions.questions.get(questionId).getQuestionAnswers().clear();
        if (radA.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (radB.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        if (radC.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(2);
        }
        if (radD.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(3);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.multi_question_one_choices_fragment,container, false);

        TextView lblQuestion =(TextView)fragmentLayout.findViewById(R.id.lblQuestion);
        radA =(RadioButton) fragmentLayout.findViewById(R.id.btnDA1);
        radB =(RadioButton) fragmentLayout.findViewById(R.id.btnDA2);
        radC =(RadioButton) fragmentLayout.findViewById(R.id.btnDA3);
        radD =(RadioButton) fragmentLayout.findViewById(R.id.btnDA4);

        lblQuestion.setText(question.getQuesionDescription());
        radA.setText(question.getQuestionChoices().get(0));
        radB.setText(question.getQuestionChoices().get(1));
        radC.setText(question.getQuestionChoices().get(2));
        radD.setText(question.getQuestionChoices().get(3));

        MyRadioGroup myRadioGroup = new MyRadioGroup(radA,radB,radC,radD);

        return fragmentLayout;
    }
}
