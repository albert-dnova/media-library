package com.lasalle.second.part.medialibrary.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lasalle.second.part.medialibrary.R;

public class AddItem extends AbstractActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_add_item);

        enableToolbarHomeButton();
    }
}
