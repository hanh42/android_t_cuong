package vn.tdc.edu.fooddelivery.activities.admin;
import android.os.Bundle;
import tdc.edu.doanbeta1.R;
import vn.tdc.edu.fooddelivery.activities.AbstractActivity;
public class CategoryManagementActivity extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_category_management);
        createActionBar();
    }
}