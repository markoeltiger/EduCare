package com.example.educare.student;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.educare.R;
import com.example.educare.professors.materials;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class chattingpagestudent extends AppCompatActivity {
    String Name;
    String id;
   ImageButton sendbtn;
   EditText editMsg;
    String message;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatting_page);
         sendbtn=findViewById(R.id.impSend);
        editMsg=findViewById(R.id.edtMessage);
         Name=getIntent().getStringExtra("name");
        id=getIntent().getStringExtra("id");
        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
message=editMsg.getText().toString();
                ValidatePhoneNumber(Name,"25/8/2000",message);
            }
        });


    }
    private void ValidatePhoneNumber( final String Code,final String CourseDescripton ,final String message) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Courses").child("sdasdsada").exists())){
                    HashMap<String,Object> coursedatamap=new HashMap<>();


                    //           coursedatamap.put("subject",Subject);
                    coursedatamap.put("to",Code);
                    coursedatamap.put("date",CourseDescripton);
                    coursedatamap.put("message",message);

                    RootRef.child("Users").child("Student").child(Name).child("Chats").child(message).updateChildren(coursedatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(chattingpagestudent.this,"your Course has been created",Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
                }
                else {
                    //  Toast.makeText(Sign_UpActivity.this, "This " + User_Name + "Is already registered please try another Email", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
