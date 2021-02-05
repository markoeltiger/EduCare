package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class materials extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materials);
        setContentView(R.layout.activity_professors);
        BottomNavigationView bottomNavigationViewprof=findViewById(R.id.bottom_navigationprof);
        bottomNavigationViewprof.setSelectedItemId(R.id.materials);
        bottomNavigationViewprof.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.materials:
                        return true;
                    case R.id.professor_chat:
                        startActivity(new Intent(getApplicationContext(),professors_chat.class));
                        return true;
                    case R.id.prfessor_student:
                        startActivity(new Intent(getApplicationContext(), professors.class));
                        return true;

                }

                return false;
            }
        });
    }
}