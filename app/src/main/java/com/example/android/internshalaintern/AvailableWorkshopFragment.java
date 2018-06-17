package com.example.android.internshalaintern;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class AvailableWorkshopFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_available_workshop,container,false);

        ArrayList<AvailableCourses> availableCourses = new ArrayList<AvailableCourses>();
        availableCourses.add(new AvailableCourses("Mathematics",""));
        availableCourses.add(new AvailableCourses("Computer Science",""));
        availableCourses.add(new AvailableCourses("English",""));
        availableCourses.add(new AvailableCourses("Data Structures",""));
        availableCourses.add(new AvailableCourses("Economics",""));
        availableCourses.add(new AvailableCourses("Management",""));
        availableCourses.add(new AvailableCourses("Android Development",""));
        availableCourses.add(new AvailableCourses("Data Science",""));
        availableCourses.add(new AvailableCourses("Germany",""));
        availableCourses.add(new AvailableCourses("French",""));
        availableCourses.add(new AvailableCourses("Mathematics Advanced",""));


        AvailableCoursesAdapter adapter = new AvailableCoursesAdapter(this.getContext(),availableCourses);
        ListView listView = (ListView)rootView.findViewById(R.id.listAvailableWorkshop);
        listView.setAdapter(adapter);
        return rootView;
    }
}
