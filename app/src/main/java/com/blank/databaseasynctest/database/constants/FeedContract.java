package com.blank.databaseasynctest.database.constants;

import android.provider.BaseColumns;

/**
 * Created by Christian Moreno on 1/26/2016.
 */
public final class FeedContract {

    //Prevents someone from accidentally initializing class
    public FeedContract() {}

    public static abstract class FeedUser implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COL_NAME_USERNAME = "USERNAME";
        public static final String COL_NAME_PASSWORD = "PASSWORD";
    }

    public static abstract class FeedImages
//            implements BaseColumns
    {
        public static final String TABLE_NAME = "Images";
        public static final String COL_NAME_IMAGE = "IMAGELOCTION";
    }

    public static abstract class FeedUserImages
//            implements BaseColumns
    {
        public static final String TABLE_NAME = "UserImages";
        public static final String COL_NAME_USER_ID = "USER_ID";
        public static final String COL_NAME_IMAGE_ID = "IMAGE_ID";
    }

}
