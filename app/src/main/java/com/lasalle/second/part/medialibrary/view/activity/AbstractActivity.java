package com.lasalle.second.part.medialibrary.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;

import com.lasalle.second.part.medialibrary.MediaLibraryApplication;
import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;

public class AbstractActivity extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState, int layoutResourceId) {
        super.onCreate(savedInstanceState);

        setContentView(layoutResourceId);

        Toolbar toolbar = (Toolbar) findViewById(R.id.common_toolbar);
        setSupportActionBar(toolbar);
    }

    protected void enableToolbarHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public LibraryManager getLibraryManager() {
        return ((MediaLibraryApplication) getApplication()).getLibraryManager();
    }

    public void displayWaiting() {
        LinearLayout progressBarHolder = (LinearLayout) findViewById(R.id.common_waiting_container);
        AlphaAnimation inAnimation = new AlphaAnimation(0f, 1f);
        inAnimation.setDuration(200);
        progressBarHolder.setAnimation(inAnimation);
        progressBarHolder.setVisibility(View.VISIBLE);
    }

    public void hideWaiting() {
        LinearLayout progressBarHolder = (LinearLayout) findViewById(R.id.common_waiting_container);
        AlphaAnimation outAnimation = new AlphaAnimation(1f, 0f);
        outAnimation.setDuration(200);
        progressBarHolder.setAnimation(outAnimation);
        progressBarHolder.setVisibility(View.GONE);
    }
}
