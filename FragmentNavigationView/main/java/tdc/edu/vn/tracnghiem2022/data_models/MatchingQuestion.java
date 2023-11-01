package tdc.edu.vn.tracnghiem2022.data_models;

import java.util.ArrayList;

public class MatchingQuestion extends AbstractQuestion {
    private ArrayList<String> quetionChoicesA;
    private ArrayList<String> quetionChoicesB;

    public MatchingQuestion() {

        questionAnswers = new ArrayList<>();
        questionCorrect = new ArrayList<>();
        quetionChoicesA = new ArrayList<>();
        quetionChoicesB = new ArrayList<>();
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

    public ArrayList<String> getQuetionChoicesA() {
        return quetionChoicesA;
    }

    public void setQuetionChoicesA(String... quetionChoicesA) {
        for (String s: quetionChoicesA) {
            this.quetionChoicesA.add(s);
        }
    }
    public ArrayList<String> getQuetionChoicesB() {
        return quetionChoicesB;
    }

    public void setQuetionChoicesB(String... quetionChoicesB) {
        for (String s: quetionChoicesB) {
            this.quetionChoicesB.add(s);
        }
    }
}
