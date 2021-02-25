package com.example.educare.professors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.educare.Adapter.StudentAdapter;
import com.example.educare.Model.Users;
import com.example.educare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class professors extends AppCompatActivity {
    List<Users> myUsersList;
    RecyclerView recyclerView;
    StudentAdapter studentAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pof_student);
        recyclerView=(RecyclerView)findViewById(R.id.list_profactivity);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myUsersList=new ArrayList<>();

        databaseReference=FirebaseDatabase.getInstance().getReference("Users").child("Doctor");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot  ds:snapshot.getChildren()){

                    Users user =ds.getValue(Users.class);
                    myUsersList.add(user);
                }
                studentAdapter=new StudentAdapter(professors.this,myUsersList);
                recyclerView.setAdapter(studentAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        BottomNavigationView bottomNavigationViewprof=findViewById(R.id.bottom_navigationprof);
        bottomNavigationViewprof.setSelectedItemId(R.id.prfessor_student);
        bottomNavigationViewprof.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.professor_chat:
                        startActivity(new Intent(getApplicationContext(), professors_chat.class));
                        return true;
                    case R.id.prfessor_student:
                        return true;
                    case R.id.materials:
                        startActivity(new Intent(getApplicationContext(), materials.class));
                        return true;
                }

                return false;
            }
        });
    }
}