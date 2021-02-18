package com.example.educare.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import com.example.educare.R;
import com.example.educare.Adapter.ChatAdapter;
import com.example.educare.Model.Chat;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class chat_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stud_chat);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.chats);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){

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
        });
        final ArrayList<Chat> chats = new ArrayList<Chat>();
        chats.add(new Chat("hello doctor iam folan"));



        ChatAdapter adapter = new ChatAdapter(this, chats,R.color.category_student);

       // ListView No_chats = (ListView) findViewById(R.id.list_co);
     //   No_chats.setAdapter(adapter);




    }
}