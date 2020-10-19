package com.example.satourismapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "satourist";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "touristattractions";
    public static final String KEY_ID = "id";
    public static final String KEY_PROVINCE = "province";
    public static final String KEY_PLACE = "place";

    //SQL STRING  for creating touristattractions.
    public static final String SQL_TABLE_TOURISTATTRACTIONS = " CREATE TABLE " + TABLE_NAME +
            " ( " + KEY_ID + " INTEGER PRIMARY KEY, " +
            KEY_PROVINCE + " TEXT, " +
            KEY_PLACE + " TEXT " + " ) ";

    public SQLiteHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);

    }

    //OnCreate Method.
    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL for creating db and table.
        db.execSQL(SQL_TABLE_TOURISTATTRACTIONS);
    }

    //OnUpgrade Method.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //Adding Places Method.
    public void addPlace(PlaceDetails POI){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(KEY_ID,POI.ID);
        cv.put(KEY_PROVINCE,POI.Province);
        cv.put(KEY_PLACE,POI.Place);
        long rs = db.insert(TABLE_NAME,null,cv);
    }

    //Getting Places Method.
    public PlaceDetails getPLaceDetails (String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.query(TABLE_NAME, new String[] { KEY_ID,
                        KEY_PROVINCE, KEY_PLACE }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cs !=null ){
            cs.moveToFirst();
            PlaceDetails user = new PlaceDetails(cs.getString(0),cs.getString(1),cs.getString(2));
            return user;
        }
        return null;
    }
}
