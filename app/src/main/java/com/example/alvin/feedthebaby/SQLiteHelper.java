package com.example.alvin.feedthebaby;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by okker on 8/20/2017.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bab.db";

    public static final String TABLE_NAME = "PEOPLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    private SQLiteDatabase database;



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_FIRST_NAME + " VARCHAR, " + COLUMN_LAST_NAME + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //inserting
    public boolean insertRecord(Baby contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, contact.getName());
        contentValues.put(COLUMN_LAST_NAME, contact.getAge());
        long x = database.insert(TABLE_NAME, null, contentValues);
        database.close();
        if(x == -1)
            return false;
        else
            return true;
    }
    //updating
    public boolean updateRecord(Baby contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_FIRST_NAME, contact.getName());
        contentValues.put(COLUMN_LAST_NAME, contact.getAge());
        long x = database.update(TABLE_NAME, contentValues, COLUMN_LAST_NAME + " = ?", new String[]{contact.getAge()});
        database.close();
        if(x == -1)
            return false;
        else
            return true;
    }

    //deleteing
    public void deleteRecord(Baby contact) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_FIRST_NAME + " = ?", new String[]{contact.getName()});
        database.close();
    }
    //getALL
    public ArrayList<Baby> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        ArrayList<Baby> contacts = new ArrayList<Baby>();
        Baby contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactModel = new Baby();
                contactModel.setID(cursor.getString(0));
                contactModel.setName(cursor.getString(1));
                contactModel.setAge(cursor.getString(2));
                contacts.add(contactModel);
            }
        }
        cursor.close();
        database.close();
        return contacts;
    }


}
