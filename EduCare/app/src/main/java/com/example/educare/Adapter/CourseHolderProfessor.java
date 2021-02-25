package com.example.educare.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educare.R;

public class CourseHolderProfessor extends RecyclerView.ViewHolder {
    TextView CourseName,CourseDescreption,CourseCode,CorseSubject,CoursePeriod;
    public CourseHolderProfessor(@NonNull View itemView) {
        super(itemView);
        CourseName=itemView.findViewById(R.id.course_item_name);
        CourseDescreption=itemView.findViewById(R.id.course_item_description);
        CourseCode=itemView.findViewById(R.id.course_item_code);
    CoursePeriod=itemView.findViewById(R.id.course_item_period);
        CorseSubject=itemView.findViewById(R.id.course_item_subject);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

