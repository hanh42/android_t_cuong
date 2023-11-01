package tdc.edu.vn.tracnghiem2022.fragments;

import androidx.fragment.app.Fragment;

import tdc.edu.vn.tracnghiem2022.data_models.AbstractQuestion;

public abstract class AbstracsFragment extends Fragment {
    public abstract void setQuestion(AbstractQuestion question);
    public abstract void setQuestionAnwser(int questionID);
}
