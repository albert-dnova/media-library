package com.lasalle.second.part.medialibrary.view.activity;

import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.view.fragment.ListItemFragment;

public class ListActivity extends AbstractActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_list);

        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.activity_list_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        View view = bottomNavigationView.findViewById(R.id.activity_list_menu_movies);
        view.performClick();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.activity_list_menu_movies)
        {
            setFragmentContent(ListItemFragment.newInstance(ListItemFragment.ItemType.MOVIES));
        }
        else if(item.getItemId() == R.id.activity_list_menu_tvshows)
        {
            setFragmentContent(ListItemFragment.newInstance(ListItemFragment.ItemType.TV_SHOWS));
        }

        return true;
    }

    private void setFragmentContent(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.activity_list_fragment_container, fragment);
        ft.commit();
    }

}
