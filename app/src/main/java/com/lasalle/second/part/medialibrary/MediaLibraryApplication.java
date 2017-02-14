package com.lasalle.second.part.medialibrary;

import android.app.Application;
import android.os.StrictMode;

import com.lasalle.second.part.medialibrary.data.impl.MovieDataFile;
import com.lasalle.second.part.medialibrary.data.impl.MovieDataMock;
import com.lasalle.second.part.medialibrary.data.impl.MovieDataSharedPreferences;
import com.lasalle.second.part.medialibrary.manager.LibraryManager;
import com.lasalle.second.part.medialibrary.network.impl.LibraryNetworkImpl;

public class MediaLibraryApplication extends Application {

    private LibraryManager libraryManager;

    @Override
    public void onCreate() {
        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }

        super.onCreate();

        libraryManager = new LibraryManager(
                new MovieDataSharedPreferences(this),
                new LibraryNetworkImpl(this));
    }

    public LibraryManager getLibraryManager() {
        return libraryManager;
    }
}
