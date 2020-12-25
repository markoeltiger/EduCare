package com.example.educare.Adapter;

import android.view.View;
import android.widget.TextView;

import com.example.educare.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderClass extends RecyclerView.ViewHolder{
    TextView name ,email;
    public ViewHolderClass(@NonNull View itemView) {
        super(itemView);
        name =itemView.findViewById(R.id.item_name);
        email=itemView.findViewById(R.id.item_email);

    }

    @Override
    public String toString() {
        return super.toString();
    }
}