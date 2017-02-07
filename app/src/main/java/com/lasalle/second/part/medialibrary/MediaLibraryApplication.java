package com.lasalle.second.part.medialibrary;

import android.app.Application;

import com.lasalle.second.part.medialibrary.data.impl.MovieDataFile;
import com.lasalle.second.part.medialibrary.data.impl.MovieDataMock;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;

public class MediaLibraryApplication extends Application {

    private LibraryManager libraryManager;

    @Override
    public void onCreate() {
        super.onCreate();

        libraryManager = new LibraryManager(new MovieDataFile(this));
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
