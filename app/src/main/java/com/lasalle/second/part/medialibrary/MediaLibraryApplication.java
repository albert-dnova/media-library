package com.lasalle.second.part.medialibrary;

import android.app.Application;

import com.lasalle.second.part.medialibrary.data.impl.LibraryDataMock;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;

public class MediaLibraryApplication extends Application {

    private LibraryManager libraryManager;

    @Override
    public void onCreate() {
        super.onCreate();

        libraryManager = new LibraryManager(new LibraryDataMock());
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
