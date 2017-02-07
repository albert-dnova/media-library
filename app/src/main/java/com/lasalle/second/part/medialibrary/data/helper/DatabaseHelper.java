package com.lasalle.second.part.medialibrary.data.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lasalle.second.part.medialibrary.util.DatabaseXmlParser;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static DatabaseHelper instance;
    private static SQLiteDatabase.CursorFactory cursorFactory;

    private Context context;
    private SQLiteDatabase db;


    protected DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;

        db = getWritableDatabase();
    }

    public static DatabaseHelper getInstance(Context context) {
        if(instance == null) {
            // Read XML first
            DatabaseXmlParser.DatabaseProperties databaseProperties =
                    DatabaseXmlParser.getInstance(context).getDatabaseProperties();
            instance = new DatabaseHelper(context, databaseProperties.name, cursorFactory, databaseProperties.version);
        }

        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        DatabaseXmlParser.DatabaseProperties databaseProperties =
                DatabaseXmlParser.getInstance(context).getDatabaseProperties();
        List<String> creationStatements = databaseProperties.creationStatements;
        for(String statement : creationStatements)
        {
            sqLiteDatabase.execSQL(statement);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        DatabaseXmlParser.DatabaseProperties databaseProperties =
                DatabaseXmlParser.getInstance(context).getDatabaseProperties();

        List<String> removalStatements = databaseProperties.removalStatements;
        for(String statement : removalStatements) {
            sqLiteDatabase.execSQL(statement);
        }

        List<String> creationStatements = databaseProperties.creationStatements;
        for(String statement : creationStatements) {
            sqLiteDatabase.execSQL(statement);
        }
    }

    public SQLiteDatabase getDatabase() {
        return db;
    }
}
