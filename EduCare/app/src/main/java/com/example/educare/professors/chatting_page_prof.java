package com.example.educare.professors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.educare.R;

public class chatting_page_prof extends AppCompatActivity {

    ImageButton sendbtn;
    EditText editMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_page);

        sendbtn=findViewById(R.id.impSend);
        editMsg=findViewById(R.id.edtMessage);

    }

}