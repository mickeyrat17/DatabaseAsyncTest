package com.blank.databaseasynctest.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blank.databaseasynctest.database.constants.FeedContract;

/**
 * Created by Christian Moreno on 1/27/2016.
 */
public class DatabaseImages extends SQLiteOpenHelper{
    private static final String BLOB_TYPE = " BLOB";
    //private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedContract.FeedImages.TABLE_NAME + " (" +
//                    FeedContract.FeedImages._ID + " INTEGER PRIMARY KEY AUTO INCREMENT," +
                    FeedContract.FeedImages.COL_NAME_IMAGE + BLOB_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedContract.FeedImages.TABLE_NAME;

    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "AsyncDatabase.db";

    public DatabaseImages(Context context) {
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

    public boolean insert(int id, int image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
//        contentValues.put(FeedContract.FeedImages._ID, id);
        contentValues.put(FeedContract.FeedImages.COL_NAME_IMAGE, image);

        long result = db.insert(FeedContract.FeedImages.TABLE_NAME, null, contentValues);
        db.close();
        return result != -1;
    }

//    public boolean delete(int rowId){
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // Defines 'where' part of query.
//        String selection = FeedContract.FeedImages._ID + " LIKE ?";
//        // Specify arguments in placeholder order.
//        String[] selectionArgs = { String.valueOf(rowId) };
//
//        // Issue SQL statement.
//        long result = db.delete(FeedContract.FeedImages.TABLE_NAME, selection, selectionArgs);
//        db.close();
//
//        return result != -1;
//    }

    public Cursor checkData(SQLiteDatabase db, String column, String columnData, String data) {
        Cursor cursor;

        String query = "Select " + column + " FROM " + FeedContract.FeedImages.TABLE_NAME +
                " WHERE " + columnData + " =  \"" + data + "\"";

        cursor = db.rawQuery(query, null);
        return cursor;
    }
}