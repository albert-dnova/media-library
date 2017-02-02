package com.lasalle.second.part.medialibrary.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

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

    protected LibraryManager getLibraryManager() {
        return ((MediaLibraryApplication) getApplication()).getLibraryManager();
    }
}
