package com.example.submission2.adapter;

import android.content.Context;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.submission2.R;
import com.example.submission2.fragmen.MovieFragment;
import com.example.submission2.fragmen.TvFragment;

public class SectionPagerAdapter extends FragmentPagerAdapter {


    @StringRes
    private static final int[] TAB_TITTLE = new int[]{R.string.movtab, R.string.tvtab};
    private final Context mContext;
    private MovieFragment movieFragment;
    private TvFragment tvFragment;


    public SectionPagerAdapter( Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        movieFragment = new MovieFragment();
        tvFragment = new TvFragment();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return new MovieFragment();
            case 1:
                return new TvFragment();
        default:
            return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITTLE[position]);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
