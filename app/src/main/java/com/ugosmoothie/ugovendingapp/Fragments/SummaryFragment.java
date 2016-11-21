package com.ugosmoothie.ugovendingapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ugosmoothie.ugovendingapp.Data.CurrentSelection;
import com.ugosmoothie.ugovendingapp.PurchaseSmoothie;
import com.ugosmoothie.ugovendingapp.R;

/**
 * Created by Michelle on 3/14/2016.
 */
public class SummaryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.summary_view, container, false);

        final TextView selectedSmoothie = (TextView) rootView.findViewById(R.id.selectedSmoothieTextView);

        if (CurrentSelection.getInstance().getCurrentSmoothie() != null) {
            selectedSmoothie.setText(CurrentSelection.getInstance().getCurrentSmoothie().toString());
        }

        Button button = (Button) rootView.findViewById(R.id.confirmPurchaseButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmPurchase();
            }
        });
        return rootView;
    }

    public void confirmPurchase() {

        ((PurchaseSmoothie) getActivity()).GetUGoViewPager().setCurrentItem(4);
    }
}