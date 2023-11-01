package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public abstract class AbtracQuestion {
    private String quesionDescription;
    protected ArrayList<Integer> questionAnswers;
    protected ArrayList<Integer> questionCorrects;

    public String getQuesionDescription() {
        return quesionDescription;
    }

    public void setQuesionDescription(String quesionDescription) {
        this.quesionDescription = quesionDescription;
    }

    public ArrayList<Integer> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Integer... questionAnswers) {
        for (Integer item:questionAnswers){
            this.questionAnswers.add(item);
        }
    }

    public ArrayList<Integer> getQuestionCorrects() {
        return questionCorrects;
    }

    public void setQuestionCorrects(Integer... questionCorrects) {
        for (Integer item:questionCorrects){
            this.questionCorrects.add(item);
        }
    }

    public abstract int getPoint();

    @Override
    public String toString() {
        if(!Questions.state){
            return "Cau" + (Questions.questions.indexOf(this)+1);
        }
        else {
            return "Cau" + (Questions.questions.indexOf(this)+1) +":" + getPoint();
        }

    }
}
