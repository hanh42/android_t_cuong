package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class MatchingQuestion extends AbtracQuestion {
    public ArrayList<String> getQuestionChoicesA() {
        return questionChoicesA;
    }

    public void setQuestionChoices(String... questionChoicesA) {
        for (String item:questionChoicesA){
            this.questionChoicesA.add(item);
        }
    }

    public MatchingQuestion() {
        questionCorrects = new ArrayList<Integer>();
        questionAnswers = new ArrayList<Integer>();
        questionChoicesA = new ArrayList<String>();
        questionChoicesB = new ArrayList<String>();
    }

    private ArrayList<String> questionChoicesA;

    public ArrayList<String> getQuestionChoicesB() {
        return questionChoicesB;
    }

    public void setQuestionChoicesB(String... questionChoicesB) {
        for (String item:questionChoicesB){
            this.questionChoicesB.add(item);
        }
    }

    private ArrayList<String> questionChoicesB;


    @Override
    public int getPoint() {
        return 0;
    }
}
