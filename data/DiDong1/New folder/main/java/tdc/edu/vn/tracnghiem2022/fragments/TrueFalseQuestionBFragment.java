package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class TrueFalseQuestionBFragment extends AbstractFragment {
    private TrueFalseQuestion question;
    private int questionId;
    Switch swt1, swt2, swt3;

    @Override
    public void setQuestion(AbtracQuestion question) {
        this.question = (TrueFalseQuestion) question;
    }

    @Override
    public void setQuestionAnswer(int questionId) {
        Questions.questions.get(questionId).getQuestionAnswers().clear();
        if (swt1.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (swt2.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (swt3.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.multi_question_truefalse_b_fragment, container, false);

        TextView lblQuestion = (TextView) fragmentLayout.findViewById(R.id.lblQuestion);
        EditText edt1 = fragmentLayout.findViewById(R.id.edt1);
        EditText edt2 = fragmentLayout.findViewById(R.id.edt2);
        EditText edt3 = fragmentLayout.findViewById(R.id.edt3);

        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoices().get(0));
        edt2.setText(question.getQuestionChoices().get(1));
        edt3.setText(question.getQuestionChoices().get(2));

        swt1 = fragmentLayout.findViewById(R.id.swt1);
        swt2 = fragmentLayout.findViewById(R.id.swt2);
        swt3 = fragmentLayout.findViewById(R.id.swt3);

        return fragmentLayout;
    }
}
