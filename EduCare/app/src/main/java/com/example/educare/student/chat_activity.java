package com.example.educare.student;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.educare.Adapter.StudentAdapter;
import com.example.educare.Adapter.beforechatadapter;
import com.example.educare.Model.Users;
import com.example.educare.R;

import com.example.educare.Model.Chat;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class chat_activity extends AppCompatActivity {
    List<Users> myUsersList;
    RecyclerView recyclerView;
    beforechatadapter  chatadap;
    StudentAdapter mStudentadapter;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_chat);

        recyclerView=(RecyclerView)findViewById(R.id.reyChat);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myUsersList=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference("Users").child("Student");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot  ds:snapshot.getChildren()){

                    Users user =ds.getValue(Users.class);
                    myUsersList.add(user);
                }
                mStudentadapter=new StudentAdapter(chat_activity.this,myUsersList);
                recyclerView.setAdapter(mStudentadapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.chats);



        //for bar
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.student:
                        startActivity(new Intent(getApplicationContext(), student_activity.class));
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(), courses_activity.class));
                        return true;
                    case R.id.chats:

                        return true;
                }


                return false;
            }
        });}

      }

