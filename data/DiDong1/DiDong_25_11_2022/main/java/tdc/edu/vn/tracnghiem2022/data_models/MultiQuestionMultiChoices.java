package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class MultiQuestionMultiChoices extends AbtracQuestion {
    public ArrayList<String> getQuestionChoices() {
        return questionChoices;
    }

    public void setQuestionChoices(String... questionChoices) {
        for (String item:questionChoices){
            this.questionChoices.add(item);
        }
    }

    public MultiQuestionMultiChoices() {
        questionCorrects = new ArrayList<Integer>();
        questionAnswers = new ArrayList<Integer>();
        questionChoices = new ArrayList<String>();
    }

    private ArrayList<String> questionChoices;

    @Override
    public int getPoint() {

        int point = 0;
        if(questionAnswers.size() == questionCorrects.size()){
            for (int i = 0; i < questionCorrects.size(); i++){
                if(questionCorrects.get(i) != questionAnswers.get(i)){
                    return point;
                }
            }
            point = 1;
        }
        return point;
    }
}
