package com.example.educare.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.educare.DashBoard;
import com.example.educare.Model.Users;
import com.example.educare.R;
import com.example.educare.student.chattingpagestudent;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 public class StudentAdapter extends RecyclerView.Adapter {
    List<Users> myUsersList;
     private Context mContext;
 public StudentAdapter(  Context context ,List<Users> mUsersList) {
        this. mContext = context;
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

        final Users users =myUsersList.get(position);
        viewHolderClass.name.setText(users.getName().toString());
        viewHolderClass.email.setText(users.getEmail().toString());
        viewHolderClass.id.setText(users.getId().toString(                  ));
       viewHolderClass.department.setText(users.getFaculty().toString());
          viewHolderClass.level.setText(users.getPhone().toString());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, chattingpagestudent.class);
                intent.putExtra("name", users.getName());
                intent.putExtra("id", users.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myUsersList.size();
    }


}
