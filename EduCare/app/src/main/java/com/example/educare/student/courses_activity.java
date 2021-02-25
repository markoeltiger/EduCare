package com.example.educare.student;

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
import com.example.educare.Adapter.CourseAdapter;
import com.example.educare.Model.Course;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class courses_activity<User_Type> extends AppCompatActivity {
String User_Type;
List<Course> myCourseList;
    RecyclerView recyclerView;
    CourseAdapter mCousreAdapter;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_course);
        recyclerView=(RecyclerView)findViewById(R.id.matriallist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myCourseList=new ArrayList<>();

        databaseReference= FirebaseDatabase.getInstance().getReference("Courses");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot  ds:snapshot.getChildren()){

                    Course course =ds.getValue(Course.class);
                    myCourseList.add(course);
                }
                mCousreAdapter=new CourseAdapter(myCourseList);
                recyclerView.setAdapter(mCousreAdapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.courses);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.courses:
                        return true;
                    case R.id.chats:
                        startActivity(new Intent(getApplicationContext(), chat_activity.class));
                        return true;
                    case R.id.student:
                        startActivity(new Intent(getApplicationContext(), student_activity.class));
                        return true;
                }
                return false;
            }
        });



    }

}