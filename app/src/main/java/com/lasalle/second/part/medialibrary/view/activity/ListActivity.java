package com.lasalle.second.part.medialibrary.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.view.fragment.AddItemMovieFragment;
import com.lasalle.second.part.medialibrary.view.fragment.AddItemShowFragment;

public class ListActivity extends AbstractActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_list);

        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.activity_list_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        View view = bottomNavigationView.findViewById(R.id.activity_list_menu_tvshows);
        view.performClick();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.activity_list_menu_movies)
        {
            setFragmentContent(AddItemMovieFragment.newInstance());
        }
        else if(item.getItemId() == R.id.activity_list_menu_tvshows)
        {
            setFragmentContent(AddItemShowFragment.newInstance());
        }

        return true;
    }

    private void setFragmentContent(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_list_fragment_container, fragment);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.addToBackStack(null);
        ft.commit();
    }

}
