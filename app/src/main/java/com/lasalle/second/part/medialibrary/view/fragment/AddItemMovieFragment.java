package com.lasalle.second.part.medialibrary.view.fragment;

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
            String movieName = movieNameInput.getText().toString();
            String directorName = directorNameInput.getText().toString();
            Integer releaseYear = Integer.parseInt(releaseYearInput.getText().toString());

            MediaLibraryApplication application = (MediaLibraryApplication) getActivity().getApplication();
            application.getLibraryManager().addMovie(movieName, directorName, releaseYear);

            getActivity().finish();
        }
    }
}
