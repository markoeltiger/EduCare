package com.example.educare.Adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MatrialViewHolderClass extends RecyclerView.ViewHolder{
    TextView course_Name,course_Description,course_Code,course_Period,course_Subject;
    public MatrialViewHolderClass(@NonNull View itemView) {
        super(itemView);
    }
}
