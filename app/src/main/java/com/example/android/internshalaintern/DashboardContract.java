package com.example.android.internshalaintern;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class DashboardContract {

    public static final String CONTENT_AUTHORITY ="com.example.android.internshalaintern";
    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.pets/pets/ is a valid path for
     * looking at pet data. content://com.example.android.pets/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_DASHBOARD = "dashboard";


    private DashboardContract(){}

    public static final class DashboardEntry implements BaseColumns {

        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_DASHBOARD);
        /** Name of database table for pets */
        public final static String TABLE_NAME = "dashboard";

        /**
         * Unique ID number for the pet (only for use in the database table).
         *
         * Type: INTEGER
         */

        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_COURSE_NAME ="name";

        /**
         * Breed of the pet.
         *
         * Type: TEXT
         */
        public final static String COLUMN_ABOUT_COURSE = "aboutCourse";

        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DASHBOARD;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_DASHBOARD;


        }

    }





