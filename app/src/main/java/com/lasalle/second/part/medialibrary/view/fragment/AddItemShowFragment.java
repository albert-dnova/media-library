package com.lasalle.second.part.medialibrary.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lasalle.second.part.medialibrary.MediaLibraryApplication;
import com.lasalle.second.part.medialibrary.R;

public class AddItemShowFragment extends Fragment implements View.OnClickListener {

    private Button button;
    private EditText showNameInput;
    private EditText numSeasonsInput;
    private EditText startingYearInput;

    public AddItemShowFragment() {
        // Required empty public constructor
    }

    public static AddItemShowFragment newInstance() {
        AddItemShowFragment fragment = new AddItemShowFragment();
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
        return inflater.inflate(R.layout.fragment_add_item_show, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        button = (Button) getActivity().findViewById(R.id.fragment_add_item_show_button);
        button.setOnClickListener(this);

        showNameInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_show_input_name);
        numSeasonsInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_show_input_num_seasons);
        startingYearInput = (EditText) getActivity().findViewById(R.id.fragment_add_item_show_input_starting_year);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == button.getId())
        {
            String movieName = showNameInput.getText().toString();
            Integer numSeasons = Integer.parseInt(numSeasonsInput.getText().toString());
            Integer startingYear = Integer.parseInt(startingYearInput.getText().toString());

            MediaLibraryApplication application = (MediaLibraryApplication) getActivity().getApplication();
            application.getLibraryManager().addTvShow(movieName, numSeasons, startingYear);

            getActivity().finish();
        }
    }
}
