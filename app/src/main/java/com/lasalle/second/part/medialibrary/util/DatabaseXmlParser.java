package com.lasalle.second.part.medialibrary.util;

import android.content.Context;

import com.lasalle.second.part.medialibrary.R;
import com.lasalle.second.part.medialibrary.data.helper.DatabaseHelper;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class DatabaseXmlParser {

    private static DatabaseXmlParser instance;

    private DatabaseProperties databaseProperties;

    public static DatabaseXmlParser getInstance(Context context) {
        if(instance == null) {
            instance = new DatabaseXmlParser(context);
        }
        return instance;
    }

    public DatabaseProperties getDatabaseProperties() {
        return databaseProperties;
    }

    protected DatabaseXmlParser(Context context) {
        parseXml(R.raw.database, context);
    }

    private void parseXml(int xmlfile, Context context) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);

            InputStream rawXmlInputStream = context.getResources().openRawResource(xmlfile);

            XmlPullParser parser = factory.newPullParser();
            parser.setInput(rawXmlInputStream, "UTF-8");
            int eventType = parser.getEventType();

            boolean isCurrentTagName = false;
            boolean isCurrentTagVersion = false;
            boolean isCurrentTagCreate = false;
            boolean isCurrentTagRemove = false;

            databaseProperties = new DatabaseProperties();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                if(eventType == XmlPullParser.START_TAG) {
                    if(tagName.equals("name")) {
                        isCurrentTagName = true;
                    }
                    else if(tagName.equals("version")) {
                        isCurrentTagVersion = true;
                    }
                    else if(tagName.equals("create")) {
                        isCurrentTagCreate = true;
                    }
                    else if(tagName.equals("remove")) {
                        isCurrentTagRemove = true;
                    }
                }
                else if(eventType == XmlPullParser.TEXT) {
                    if (isCurrentTagName) {
                        databaseProperties.name = parser.getText();
                    }
                    else if(isCurrentTagVersion) {
                        databaseProperties.version = Integer.parseInt(parser.getText());
                    }
                    else if(isCurrentTagCreate) {
                        databaseProperties.creationStatements.add(parser.getText());
                    }
                    else if(isCurrentTagRemove) {
                        databaseProperties.removalStatements.add(parser.getText());
                    }
                }
                else if(eventType == XmlPullParser.END_TAG) {
                    isCurrentTagName = false;
                    isCurrentTagVersion = false;
                    isCurrentTagCreate = false;
                    isCurrentTagRemove = false;
                }

                eventType = parser.next();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class DatabaseProperties {
        public String name;
        public Integer version;
        public List<String> creationStatements;
        public List<String> removalStatements;

        public DatabaseProperties() {
            creationStatements = new ArrayList<>();
            removalStatements = new ArrayList<>();
        }
    }

}
