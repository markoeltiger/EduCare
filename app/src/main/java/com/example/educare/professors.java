package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class professors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professors);
        BottomNavigationView bottomNavigationViewprof=findViewById(R.id.bottom_navigationprof);
        bottomNavigationViewprof.setSelectedItemId(R.id.prfessor_student);
        bottomNavigationViewprof.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.professor_chat:
                        startActivity(new Intent(getApplicationContext(),professors_chat.class));
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