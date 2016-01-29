package com.blank.databaseasynctest.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blank.databaseasynctest.database.constants.FeedContract;

/**
 * Created by Christian Moreno on 1/27/2016.
 * *****************************************************
 * Database included two FK: UserInfo _ID and Images _ID
 * *****************************************************
 */
public class DatabaseUser_Image
//        extends SQLiteOpenHelper
{
//    private static final String INT_TYPE = " INTEGER";
//    private static final String FOREIGN_KEY = " FOREIGN KEY REFERENCES";
//    private static final String COMMA_SEP = ",";
//    private static final String SQL_CREATE_ENTRIES =
//            "CREATE TABLE " + FeedContract.FeedUserImages.TABLE_NAME + " (" +
//                    FeedContract.FeedUserImages._ID + " INTEGER PRIMARY KEY AUTO INCREMENT," +
//                    FeedContract.FeedUserImages.COL_NAME_USER_ID + INT_TYPE + FOREIGN_KEY +
//                    FeedContract.FeedUser.TABLE_NAME + "(" + FeedContract.FeedUser._ID + ")" + COMMA_SEP +
//                    FeedContract.FeedUserImages.COL_NAME_IMAGE_ID + INT_TYPE + FOREIGN_KEY +
//                    FeedContract.FeedUser.TABLE_NAME + "(" + FeedContract.FeedUser._ID + ")" + " )";
//
//    private static final String SQL_DELETE_ENTRIES =
//            "DROP TABLE IF EXISTS " + FeedContract.FeedUserImages.TABLE_NAME;
//
//    public static final int DATABASE_VERSION = 3;
//    public static final String DATABASE_NAME = "AsyncDatabase.db";
//
//    public DatabaseUser_Image(Context context) {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(SQL_CREATE_ENTRIES);
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL(SQL_DELETE_ENTRIES);
//        onCreate(db);
//    }
//
//    public boolean insert(int id, int userId, int imageId) {
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(FeedContract.FeedUserImages._ID, id);
//        contentValues.put(FeedContract.FeedUserImages.COL_NAME_USER_ID, userId);
//        contentValues.put(FeedContract.FeedUserImages.COL_NAME_IMAGE_ID, imageId);
//
//        long result = db.insert(FeedContract.FeedUserImages.TABLE_NAME, null, contentValues);
//        db.close();
//        return result != -1;
//    }
//
//    public boolean delete(int rowId) {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        // Defines 'where' part of query.
//        String selection = FeedContract.FeedUserImages._ID + " LIKE ?";
//        // Specify arguments in placeholder order.
//        String[] selectionArgs = {String.valueOf(rowId)};
//
//        // Issue SQL statement.
//        long result = db.delete(FeedContract.FeedUserImages.TABLE_NAME, selection, selectionArgs);
//        db.close();
//
//        return result != -1;
//    }
}
