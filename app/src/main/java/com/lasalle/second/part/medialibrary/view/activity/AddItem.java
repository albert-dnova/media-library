package com.lasalle.second.part.medialibrary.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.view.adapter.AddItemTabLayoutAdapter;

public class AddItem extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_add_item);

        enableToolbarHomeButton();

        TabLayout tabLayout = (TabLayout) findViewById(R.id.activity_add_item_tablayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.activity_add_item_view_pager);

        viewPager.setAdapter(new AddItemTabLayoutAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(viewPager);
    }
}
