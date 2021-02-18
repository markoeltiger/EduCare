package com.example.educare.professors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.example.educare.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class professors_chat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pof_chat);
        BottomNavigationView bottomNavigationViewprof=findViewById(R.id.bottom_navigationprof);
        bottomNavigationViewprof.setSelectedItemId(R.id.professor_chat);
        bottomNavigationViewprof.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

                    case R.id.professor_chat:
                        return true;
                    case R.id.prfessor_student:
                        startActivity(new Intent(getApplicationContext(),professors.class));
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