package com.example.android.internshalaintern;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class AvailableCoursesAdapter extends ArrayAdapter<AvailableCourses>{
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.course_list, parent, false);
        }
        AvailableCourses CurrentCourse = getItem(position);
        TextView courseNameTextView = (TextView)listItemView.findViewById(R.id.courseName);
        courseNameTextView.setText(CurrentCourse.getCourseName());

        TextView aboutCourseTextView = (TextView)listItemView.findViewById(R.id.aboutCourse);
        aboutCourseTextView.setText(CurrentCourse.getAboutCourse());

        return listItemView;

    }

    public AvailableCoursesAdapter(Context context, ArrayList<AvailableCourses> availableCourse){
        super(context,0,availableCourse);
    }
}
