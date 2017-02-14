package com.lasalle.second.part.medialibrary.network.impl;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.ion.Ion;
import com.lasalle.second.part.medialibrary.model.Movie;
import com.lasalle.second.part.medialibrary.model.TvShow;
import com.lasalle.second.part.medialibrary.network.LibraryNetwork;

import java.lang.reflect.Type;
import java.util.List;

public class LibraryNetworkImpl implements LibraryNetwork {

    private Context context;

    public LibraryNetworkImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<TvShow> retireveShowList() {
        List<TvShow> showList = null;
        try {
            JsonArray jsonArray = Ion.with(context)
               .load("http://private-8520e-mdpalibrary.apiary-mock.com/shows")
               .asJsonArray()
               .get();


            Type collectionType = new TypeToken<List<TvShow>>(){}.getType();
            Gson gson = new Gson();
            showList = gson.fromJson(jsonArray, collectionType);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return showList;
    }

}
