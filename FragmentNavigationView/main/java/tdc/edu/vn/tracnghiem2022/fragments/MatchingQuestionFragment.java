package tdc.edu.vn.tracnghiem2022.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import tdc.edu.vn.tracnghiem2022.R;

import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.MatchingQuestion;
import tdc.edu.vn.tracnghiem2022.data_models.Questions;

public class MatchingQuestionFragment extends AbstracsFragment {
    private MatchingQuestion question;
    private int questionID;
    private Spinner spin1,spin2,spin3;
    @Override
    public void setQuestion(AbstractQuestion question) {
        this.question = (MatchingQuestion) question;
    }

    @Override
    public void setQuestionAnwser(int questionID) {
        this.questionID = questionID;
        userInteractionProcessing(spin1,spin2,spin3);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentLayout = null;

        fragmentLayout = inflater.inflate(R.layout.matching_question_fragment, container,false);
        TextView txtViewCauHoi = fragmentLayout.findViewById(R.id.txtViewCauHoi);
        TextView txt1 = fragmentLayout.findViewById(R.id.txt1);
        TextView txt2 = fragmentLayout.findViewById(R.id.txt2);
        TextView txt3 = fragmentLayout.findViewById(R.id.txt3);
        spin1 = fragmentLayout.findViewById(R.id.spin1);
        spin2 = fragmentLayout.findViewById(R.id.spin2);
        spin3 = fragmentLayout.findViewById(R.id.spin3);

        MatchingQuestion quetion = (MatchingQuestion) Questions.questions.get(2);
        //Set data
        txtViewCauHoi.setText(quetion.getQuestionDescription());
        txt1.setText(quetion.getQuetionChoicesA().get(0));
        txt2.setText(quetion.getQuetionChoicesA().get(1));
        txt3.setText(quetion.getQuetionChoicesA().get(2));


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,quetion.getQuetionChoicesB());
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);
        spin3.setAdapter(adapter);

        return fragmentLayout;
    }
    private void userInteractionProcessing(Spinner spinner1, Spinner spinner2, Spinner spinner3) {
        Questions.questions.get(questionID).getQuestionAnswers().clear();
        Questions.questions.get(questionID).setQuestionAnswers(spinner1.getSelectedItemPosition());
        Questions.questions.get(questionID).setQuestionAnswers(spinner2.getSelectedItemPosition());
        Questions.questions.get(questionID).setQuestionAnswers(spinner3.getSelectedItemPosition());

    }
}
