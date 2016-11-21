package com.ugosmoothie.ugovendingapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ugosmoothie.ugovendingapp.Fragments.LiquidSelectionFragment;
import com.ugosmoothie.ugovendingapp.Fragments.PaymentFragment;
import com.ugosmoothie.ugovendingapp.Fragments.SmoothieSelectionFragment;
import com.ugosmoothie.ugovendingapp.Fragments.SummaryFragment;
import com.ugosmoothie.ugovendingapp.Fragments.SupplementSelectionFragment;
import com.ugosmoothie.ugovendingapp.Fragments.SurveyFragment;

/**
 * Created by Michelle on 3/5/2016.
 */
public class SmoothiePagerAdapter extends FragmentStatePagerAdapter {

    public SmoothiePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SmoothieSelectionFragment();
        } else if (position == 1) {
            return new LiquidSelectionFragment();
        } else if (position == 2) {
            return new SupplementSelectionFragment();
        } else if (position == 3) {
            return new SummaryFragment();
        } else if (position == 4) {
            return new PaymentFragment();
        } else if (position == 5) {
            return new SurveyFragment();
        } else {
            return PurchaseSmoothieFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        return PurchaseSmoothieFragment.uGoFragmentMap.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        PurchaseSmoothieFragment.uGoFragment fragment = PurchaseSmoothieFragment.uGoFragmentMap.get(position);

        if (fragment != null) {
            return fragment.getDescription();
        } else {
            return null;
        }
    }
}
