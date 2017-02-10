package com.lasalle.second.part.medialibrary.view.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lasalle.second.part.medialibrary.MediaLibraryApplication;
import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.view.activity.AbstractActivity;

import java.util.List;

public class AddItemMovieFragment extends Fragment implements View.OnClickListener {

    private Button button;
    private EditText movieNameInput;
    private EditText directorNameInput;
    private EditText releaseYearInput;

    public AddItemMovieFragment() {
        // Required empty public constructor
    }

    public static AddItemMovieFragment newInstance() {
        AddItemMovieFragment fragment = new AddItemMovieFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_item_movie, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button = (Button) getActivity().findViewById(R.id.fragment_add_item_movie_button);
        button.setOnClickListener(this);

        movieNameInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_movie_input_name);
        directorNameInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_movie_input_director);
        releaseYearInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_movie_input_release_year);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == button.getId())
        {
            AddItemMovie addItemMovie = new AddItemMovie();
            addItemMovie.execute();
        }
    }

    private class AddItemMovie extends AsyncTask<Void, Void, Void> {

        private String movieName;
        private String directorName;
        private Integer releaseYear;
        private LibraryManager libraryManager;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            AbstractActivity activity = (AbstractActivity) getActivity();
            activity.displayWaiting();

            movieName = movieNameInput.getText().toString();
            directorName = directorNameInput.getText().toString();
            releaseYear = Integer.parseInt(releaseYearInput.getText().toString());

            MediaLibraryApplication application = (MediaLibraryApplication) getActivity().getApplication();
            libraryManager = application.getLibraryManager();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            libraryManager.addMovie(movieName, directorName, releaseYear);
            return null;
        }

        @Override
        protected void onPostExecute(Void movieList) {
            super.onPostExecute(movieList);

            AbstractActivity activity = (AbstractActivity) getActivity();
            activity.hideWaiting();
            activity.finish();
        }
    }


}
