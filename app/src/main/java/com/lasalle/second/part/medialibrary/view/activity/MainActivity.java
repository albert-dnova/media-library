package com.lasalle.second.part.medialibrary.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.view.loader.ListMovieLoader;

import java.util.List;

public class MainActivity extends AbstractActivity implements View.OnClickListener,
        LoaderManager.LoaderCallbacks<List<Movie>> {

    private static final int LOADER_ID = 1;

    private Button addButton;
    private Button listbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        addButton = (Button) findViewById(R.id.activity_main_add_button);
        listbutton = (Button) findViewById(R.id.activity_main_list_button);

        addButton.setOnClickListener(this);
        listbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == addButton.getId())
        {
            Intent intent = new Intent(this, AddItem.class);
            startActivity(intent);
        }
        else if(view.getId() == listbutton.getId())
        {
            displayWaiting();
            getSupportLoaderManager().initLoader(LOADER_ID, null, this);
        }
    }

    @Override
    public Loader<List<Movie>> onCreateLoader(int id, Bundle args) {
        Loader loader = null;

        if(id == LOADER_ID) {
            loader = new ListMovieLoader(this, getLibraryManager());
        }

        return loader;
    }

    @Override
    public void onLoadFinished(Loader<List<Movie>> loader, List<Movie> data) {
        hideWaiting();
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onLoaderReset(Loader<List<Movie>> loader) {
        // Do nothing
    }
}
