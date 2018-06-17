package com.example.android.internshalaintern;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DashboardDbHelper extends SQLiteOpenHelper {
    /** Name of the database file */
    private static final String DATABASE_NAME="dashboard.db";
    private static final int DATABASE_VERSION=1;

    public DashboardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_DASHBOARD_TABLE ="CREATE TABLE " + DashboardContract.DashboardEntry.TABLE_NAME + " ("
                + DashboardContract.DashboardEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DashboardContract.DashboardEntry.COLUMN_COURSE_NAME + " TEXT NOT NULL, "
                + DashboardContract.DashboardEntry.COLUMN_ABOUT_COURSE + " TEXT );";

        sqLiteDatabase.execSQL(SQL_CREATE_DASHBOARD_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }

}
