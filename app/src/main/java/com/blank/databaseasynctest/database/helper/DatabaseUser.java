package com.blank.databaseasynctest.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blank.databaseasynctest.database.constants.FeedContract;

/**
 * Created by Christian Moreno on 1/26/2016.
 */
public class DatabaseUser extends SQLiteOpenHelper {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES =
            "create table " + FeedContract.FeedUser.TABLE_NAME + "(" +
                    FeedContract.FeedUser._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    FeedContract.FeedUser.COL_NAME_USERNAME + TEXT_TYPE + COMMA_SEP +
                    FeedContract.FeedUser.COL_NAME_PASSWORD + TEXT_TYPE + ");";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedContract.FeedUser.TABLE_NAME;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AsyncDatabase.db";

    public DatabaseUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(FeedContract.FeedUser.COL_NAME_USERNAME, username);
        contentValues.put(FeedContract.FeedUser.COL_NAME_PASSWORD, password);

        long result = db.insert(FeedContract.FeedUser.TABLE_NAME, null, contentValues);
        db.close();
        return result != -1;
    }

//    public boolean delete(int rowId) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // Defines 'where' part of query.
//        String selection = FeedContract.FeedUser._ID + " LIKE ?";
//        // Specify arguments in placeholder order.
//        String[] selectionArgs = {String.valueOf(rowId)};
//
//        // Issue SQL statement.
//        long result = db.delete(FeedContract.FeedUser.TABLE_NAME, selection, selectionArgs);
//        db.close();
//
//        return result != -1;
//    }
}