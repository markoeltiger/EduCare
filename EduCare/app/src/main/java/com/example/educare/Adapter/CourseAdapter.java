package com.example.educare.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.educare.Model.Course;
import com.example.educare.Model.Users;
import com.example.educare.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class CourseAdapter extends RecyclerView.Adapter {
    List<Course> myCourseList;

    public CourseAdapter(List<Course> myCourseList) {
        this.myCourseList = myCourseList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_course,parent,false);
        CourseHolderProfessor courseHolderProfessor=new CourseHolderProfessor(view);

        return courseHolderProfessor;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

      CourseHolderProfessor courseHolderProfessor=(CourseHolderProfessor)holder;
        Course Courses =myCourseList.get(position);
        courseHolderProfessor.CourseName.setText(Courses.getName().toString());
           courseHolderProfessor.CourseDescreption.setText(Courses.getCoursedescripton().toString());
        //.CorseSubject.setText(Courses.getSubject().toString());
      //  courseHolderProfessor.CourseCode.setText(Courses.getCode().toString());
           courseHolderProfessor.CoursePeriod.setText(Courses.getCourseperiod().toString());

    }

    @Override
    public int getItemCount() {
        return myCourseList.size();
    }


}
