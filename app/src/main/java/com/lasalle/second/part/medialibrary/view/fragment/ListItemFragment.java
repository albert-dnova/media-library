package com.lasalle.second.part.medialibrary.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.view.activity.AbstractActivity;
import com.lasalle.second.part.medialibrary.view.adapter.ListMovieItemRecyclerViewAdapter;

public class ListItemFragment extends Fragment {

    public enum ItemType {
        TV_SHOWS,
        MOVIES
    }

    private ItemType itemType;

    public ListItemFragment() {
    }

    public static ListItemFragment newInstance(ItemType itemType) {
        ListItemFragment fragment = new ListItemFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("itemType", itemType);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            itemType = (ItemType) getArguments().getSerializable("itemType");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_list_item, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_list_item_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        RecyclerView.Adapter adapter = null;
        if(itemType == ItemType.TV_SHOWS) {

        }
        else if(itemType == ItemType.MOVIES) {
            adapter = new ListMovieItemRecyclerViewAdapter((AbstractActivity) getActivity());
        }
        else {
            throw new RuntimeException("Unexpected type!");
        }
        recyclerView.setAdapter(adapter);

        return view;
    }

}
