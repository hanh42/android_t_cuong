package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class TrueFalseQuestion extends AbstractQuestion {
    private ArrayList<String> quetionChoices;

    public TrueFalseQuestion() {

        questionAnswers = new ArrayList<>();
        questionCorrect = new ArrayList<>();
        quetionChoices = new ArrayList<>();
    }

    @Override
    public int getPoint() {
        int point = 0;

        if (questionAnswers.size() == questionCorrect.size()) {
            for (int i = 0; i < questionCorrect.size(); i++) {
                if (questionCorrect.get(i) != questionAnswers.get(i)) {
                    return point;
                }
            }
            point = 1;
        }
        return point;
    }

    public ArrayList<String> getQuetionChoices() {
        return quetionChoices;
    }

    public void setQuetionChoices(String... quetionChoices) {
        for (String s: quetionChoices) {
            this.quetionChoices.add(s);
        }
    }
}
