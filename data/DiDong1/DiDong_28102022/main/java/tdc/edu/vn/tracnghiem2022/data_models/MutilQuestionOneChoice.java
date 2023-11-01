package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class MutilQuestionOneChoice extends AbtracQuestion {
    public ArrayList<String> getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(String... questionChoices) {
        for (String item:questionChoices){
            this.questionChoices.add(item);
        }
    }

    public MutilQuestionOneChoice() {
        questionCorrects = new ArrayList<Integer>();
        questionAnswers = new ArrayList<Integer>();
        questionChoices = new ArrayList<String>();
    }

    private ArrayList<String> questionChoices;


    @Override
    public int getPoint() {
        return 0;
    }
}
