package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import tdc.edu.vn.tracnghiem2022.R;
import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MatchingQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class MatchingQuestionFragment extends AbstractFragment {
    private MatchingQuestion question;
    private int questionId;
    Spinner spn1, spn2, spn3;

    @Override
    public void setQuestion(AbtracQuestion question) {
        this.question = (MatchingQuestion) question;
    }

    @Override
    public void setQuestionAnswer(int questionId) {
        Questions.questions.get(questionId).getQuestionAnswers().clear();
        Questions.questions.get(questionId).setQuestionAnswers(spn1.getSelectedItemPosition());
        Questions.questions.get(questionId).setQuestionAnswers(spn2.getSelectedItemPosition());
        Questions.questions.get(questionId).setQuestionAnswers(spn3.getSelectedItemPosition());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.multi_question_matching_fragment, container, false);

        TextView lblQuestion = (TextView) fragmentLayout.findViewById(R.id.lblQuestion);
        EditText edt1 = fragmentLayout.findViewById(R.id.edt1);
        EditText edt2 = fragmentLayout.findViewById(R.id.edt2);
        EditText edt3 = fragmentLayout.findViewById(R.id.edt3);

        spn1 = fragmentLayout.findViewById(R.id.spn1);
        spn2 = fragmentLayout.findViewById(R.id.spn2);
        spn3 = fragmentLayout.findViewById(R.id.spn3);

        lblQuestion.setText(question.getQuesionDescription());
        edt1.setText(question.getQuestionChoicesA().get(0));
        edt2.setText(question.getQuestionChoicesA().get(1));
        edt3.setText(question.getQuestionChoicesA().get(2));

        ArrayAdapter<String> spinAdapter = new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_spinner_item, question.getQuestionChoicesB());
        spn1.setAdapter(spinAdapter);
        spn2.setAdapter(spinAdapter);
        spn3.setAdapter(spinAdapter);

        return fragmentLayout;
    }
}
