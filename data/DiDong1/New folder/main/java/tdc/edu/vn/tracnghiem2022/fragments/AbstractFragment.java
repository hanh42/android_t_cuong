package tdc.edu.vn.tracnghiem2022.fragments;

import android.support.v4.app.Fragment;

import tdc.edu.vn.tracnghiem2022.data_models.AbtracQuestion;

public abstract class AbstractFragment extends Fragment {
    public abstract void setQuestion(AbtracQuestion question);

    public abstract void setQuestionAnswer(int questionId);
}
