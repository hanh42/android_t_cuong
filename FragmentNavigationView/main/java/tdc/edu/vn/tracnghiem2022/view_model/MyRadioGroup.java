package tdc.edu.vn.tracnghiem2022.view_model;

import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

public class MyRadioGroup {
    private ArrayList<RadioButton> radioButtons;
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ((RadioButton) v).setChecked(true);

            for (RadioButton btn: radioButtons) {
                if (btn.getId() != v.getId()){
                    btn.setChecked(false);
                }
            }
        }
    };
    public MyRadioGroup(RadioButton... radioButtons) {
        this.radioButtons = new ArrayList<RadioButton>();
        for (RadioButton btn: radioButtons) {
            btn.setOnClickListener(onClick);
            this.radioButtons.add(btn);
        }
    }
}
