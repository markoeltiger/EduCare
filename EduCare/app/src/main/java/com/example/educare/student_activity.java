package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.educare.Adapter.StudntAdap;
import com.example.educare.Model.Student;
import com.example.educare.Model.Users;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class student_activity extends AppCompatActivity {
List<Users> myUsersList;
RecyclerView recyclerView;
    StudntAdap mStudentadapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

recyclerView=(RecyclerView)findViewById(R.id.list_co);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
myUsersList=new ArrayList<>();
databaseReference=FirebaseDatabase.getInstance().getReference("Users").child("Student");

databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        for(DataSnapshot  ds:snapshot.getChildren()){

        Users user =ds.getValue(Users.class);
            myUsersList.add(user);
        }
        mStudentadapter=new StudntAdap(myUsersList);
        recyclerView.setAdapter(mStudentadapter);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }
});

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.student);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.student:
                        return true;
                    case R.id.courses:
                        startActivity(new Intent(getApplicationContext(), courses_activity.class));
                        return true;
                    case R.id.chats:
                        startActivity(new Intent(getApplicationContext(), chat_activity.class));
                        return true;
                }



                return false;
            }
        });


    }

}