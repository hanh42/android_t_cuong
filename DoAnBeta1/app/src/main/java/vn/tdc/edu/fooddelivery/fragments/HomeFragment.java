package vn.tdc.edu.fooddelivery.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import tdc.edu.doanbeta1.R;

public class HomeFragment extends AbstractFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentLayout = null;
        fragmentLayout = inflater.inflate(R.layout.fragment_home, container, false);
        return fragmentLayout;
    }
}