package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.educare.Adapter.CourseAdapter;
import com.example.educare.Model.Course;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class courses_activity<User_Type> extends AppCompatActivity {
String User_Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

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
        final ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("malware"));



        CourseAdapter adapter = new CourseAdapter(this, courses,R.color.category_student);

        RecyclerView No_courses = (RecyclerView) findViewById(R.id.list_co);
      //  No_courses.setAdapter(adapter);



    }

}