package com.example.educare.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.educare.Model.Users;
import com.example.educare.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 public class StudentAdapter extends RecyclerView.Adapter {
    List<Users> myUsersList;

 public StudentAdapter(List<Users> mUsersList) {
        this.myUsersList = mUsersList;
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

        Users users =myUsersList.get(position);
        viewHolderClass.name.setText(users.getName().toString());
        viewHolderClass.email.setText(users.getEmail().toString());
        viewHolderClass.id.setText(users.getId().toString());
       viewHolderClass.department.setText(users.getFaculty().toString());
          viewHolderClass.level.setText(users.getPhone().toString());

    }

    @Override
    public int getItemCount() {
        return myUsersList.size();
    }


}
