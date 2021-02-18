package com.example.educare.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.educare.Model.Users;
import com.example.educare.R;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProfessorAdapter extends RecyclerView.Adapter {
    List<Users> myDocorsList;

    public ProfessorAdapter(List<Users> myUsersList) {
        this.myDocorsList = myUsersList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolderClass viewHolderClass=new ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderClass viewHolderClass =(ViewHolderClass)holder;

        Users users =myDocorsList.get(position);
        viewHolderClass.name.setText(users.getName().toString());
        viewHolderClass.email.setText(users.getEmail().toString());
        viewHolderClass.department.setText(users.getDepartment().toString());
    }

    @Override
    public int getItemCount() {
        return myDocorsList.size();
    }


}
