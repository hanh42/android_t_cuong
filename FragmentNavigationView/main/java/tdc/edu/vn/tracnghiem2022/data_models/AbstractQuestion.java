package tdc.edu.vn.tracnghiem2022.data_models;

import android.content.Intent;

import java.util.ArrayList;

public abstract class AbstractQuestion {
    private String questionDescription;
    protected ArrayList<Integer> questionAnswers;
    protected ArrayList<Integer> questionCorrect;

    public abstract int getPoint();

    public String getQuestionDescription() {
        return questionDescription;
    }

    public ArrayList<Integer> getQuestionAnswers() {
        return questionAnswers;
    }

    public ArrayList<Integer> getQuestionCorrect() {
        return questionCorrect;
    }

    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public void setQuestionAnswers(Integer... questionAnswers) {
        for (Integer item: questionAnswers) {
            this.questionAnswers.add(item);
        }
    }

    public void setQuestionCorrect(Integer... questionCorrect) {
        for (Integer item: questionCorrect) {
            this.questionCorrect.add(item);
        }
    }

    @Override
    public String toString() {
        if (Questions.state == true)
            return "Cau " + (Questions.questions.indexOf(this) +1) + ":" +getPoint();
        else
            return "Cau " + (Questions.questions.indexOf(this) +1);
    }
}
