package com.example.educare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.educare.Model.Course;
import com.example.educare.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;


    public class CourseAdapter extends ArrayAdapter<Course> {
        private int mColorResourceId;

        public CourseAdapter(Context context, ArrayList<Course> courses, int ColorResourceId) {
            super(context, 0, courses);
            mColorResourceId=ColorResourceId;
        }
        @NonNull

        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View listItemView = convertView;
            if (listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }

            Course SingleWord = getItem (position);

            TextView courseTextView = (TextView) listItemView.findViewById(R.id.item_name);


            courseTextView.setText(SingleWord.getCourseName());


            // Set the theme color for the list item
            View textContainer = listItemView.findViewById(R.id.item_name);
            // Find the color that the resource ID maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            // Set the background color of the text container View
            textContainer.setBackgroundColor(color);

            return listItemView;
        }
    }

