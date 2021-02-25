package com.example.educare.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.educare.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderClass extends RecyclerView.ViewHolder{
    TextView name ,email,department,level,id ,course_Name,course_Description,course_Code,course_Period,course_Subject;
    private final Context context;

    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        name =itemView.findViewById(R.id.item_name);
        email=itemView.findViewById(R.id.item_email);
        department=itemView.findViewById(R.id.item_dep);
        level=itemView.findViewById(R.id.item_level);
        id=itemView.findViewById(R.id.item_id);
        context = itemView.getContext();

    }

    @Override
    public String toString() {
        return super.toString();
    }
}