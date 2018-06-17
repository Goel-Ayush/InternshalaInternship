package com.example.android.internshalaintern;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.example.android.internshalaintern.*;

public class DashboardAdapter extends CursorAdapter{

    public DashboardAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTextView = (TextView)view.findViewById(R.id.name);
        TextView SummaryTextView = (TextView)view.findViewById(R.id.summary);

        int nameColumnIndex = cursor.getColumnIndex(DashboardContract.DashboardEntry.COLUMN_COURSE_NAME);
        int aboutColumnIndex = cursor.getColumnIndex(DashboardContract.DashboardEntry.COLUMN_ABOUT_COURSE);

        String petName = cursor.getString(nameColumnIndex);
        String petBreed = cursor.getString(aboutColumnIndex);

        nameTextView.setText(petName);
        SummaryTextView.setText(petBreed);

    }
}
