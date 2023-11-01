package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;
import tdc.edu.vn.tracnghiem2022.data_models.TrueFalseQuestion;

public class TrueFalseQuestionAFragment extends AbstractFragment {
    private TrueFalseQuestion question;
    private int questionId;
    ToggleButton tlb1, tlb2, tlb3;

    @Override
    public void setQuestion(AbtracQuestion question) {
        this.question = (TrueFalseQuestion) question;
    }

    @Override
    public void setQuestionAnswer(int questionId) {
        Questions.questions.get(questionId).getQuestionAnswers().clear();
        if (tlb1.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (tlb2.isChecked()){
            Questions.questions.get(questionId).setQuestionAnswers(1);
        }
        else {
            Questions.questions.get(questionId).setQuestionAnswers(0);
        }
        if (tlb3.isChecked()){
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
        fragmentLayout = inflater.inflate(R.layout.multi_question_truefalse_a_fragment, container, false);

        TextView lblQuestion = (TextView) fragmentLayout.findViewById(R.id.lblQuestion);

        EditText edt1 = fragmentLayout.findViewById(R.id.edt1);
        EditText edt2 = fragmentLayout.findViewById(R.id.edt2);
        EditText edt3 = fragmentLayout.findViewById(R.id.edt3);

        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoices().get(0));
        edt2.setText(question.getQuestionChoices().get(1));
        edt3.setText(question.getQuestionChoices().get(2));

        tlb1 = fragmentLayout.findViewById(R.id.tlb1);
        tlb2 = fragmentLayout.findViewById(R.id.tlb2);
        tlb3 = fragmentLayout.findViewById(R.id.tlb3);

        return fragmentLayout;
    }
}
