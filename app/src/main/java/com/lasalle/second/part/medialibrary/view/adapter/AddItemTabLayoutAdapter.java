package com.lasalle.second.part.medialibrary.view.adapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.view.fragment.AddItemMovieFragment;
import com.lasalle.second.part.medialibrary.view.fragment.AddItemShowFragment;

public class AddItemTabLayoutAdapter extends FragmentPagerAdapter {

    private final static int TV_SHOWS_TAB_POSITION = 0;
    private final static int MOVIE_TAB_POSITION = 1;
    private final static int NUMBER_OF_TABS = 2;

    private AppCompatActivity activity;

    public AddItemTabLayoutAdapter(FragmentManager fm, AppCompatActivity  owner) {
        super(fm);
        activity = owner;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == TV_SHOWS_TAB_POSITION)
        {
            return AddItemShowFragment.newInstance();
        }
        else if(position == MOVIE_TAB_POSITION)
        {
            return AddItemMovieFragment.newInstance();
        }

        throw new RuntimeException("Tab not found");
    }

    @Override
    public int getCount() {
        return NUMBER_OF_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == TV_SHOWS_TAB_POSITION)
        {
            return activity.getString(R.string.add_item_activity_tv_show);
        }
        else if(position == MOVIE_TAB_POSITION)
        {
            return activity.getString(R.string.add_item_activity_movies);
        }

        return super.getPageTitle(position);
    }
}
