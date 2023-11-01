package tdc.edu.vn.tracnghiem2022.view_models;

import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MyRadioGroup {
    private ArrayList<RadioButton> radioButtons;
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((RadioButton) v).setChecked(true);
            for (RadioButton button:radioButtons) {
                if(button.getId() != v.getId()){
                    button.setChecked(false);
                }
            }
        }
    };

    public MyRadioGroup(RadioButton... radioButtons) {
        this.radioButtons = new ArrayList<RadioButton>();
        for (RadioButton button: radioButtons){
            button.setOnClickListener(onClick);
            this.radioButtons.add(button);
        }
    }
}
