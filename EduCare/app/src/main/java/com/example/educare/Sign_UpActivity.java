package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Sign_UpActivity extends AppCompatActivity {
     String User_Name,User_Email,User_password,User_Type;
    private Button CreateAccountButton;
    private RadioButton Doc,Student;
    private EditText InputName,InputEmail,InputPassword;
    private ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        Doc=(RadioButton)findViewById(R.id.radioButton);
   //     User_Type= "Student";
        Student=(RadioButton)findViewById(R.id.radioButton2);
        CreateAccountButton=(Button) findViewById(R.id.register_login_btn);
        InputName=(EditText) findViewById(R.id.register_name_number_input);
        InputEmail=(EditText)findViewById(R.id.register_email_input);
        InputPassword=(EditText) findViewById(R.id.register_password_input);
        loading=new ProgressDialog(this);
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateAccount();
            }
        });
    }
    private void CreateAccount() {
        User_Name = InputName.getText().toString();
        User_password = InputPassword.getText().toString();
        User_Email = InputEmail.getText().toString();
        if (TextUtils.isEmpty(User_Name)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_password)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_Email)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Email", Toast.LENGTH_SHORT).show();
        } else if (!Doc.isChecked() && !Student.isChecked()) {
            Toast.makeText(Sign_UpActivity.this, "Please Check Your Type", Toast.LENGTH_SHORT).show();
        } else {
            loading.setTitle("Create Account");
            loading.setMessage("Please Wait");
            loading.setCanceledOnTouchOutside(false);
            loading.show();
        //    User_Type.equals("Student");
         if(Doc.isChecked()){User_Type="Doctor";}
       if (Student.isChecked()){User_Type="Student" ;}
            ValidatePhoneNumber(User_Name, User_Email, User_password,User_Type);
        }
    }private void ValidatePhoneNumber(final String User_Name, final String User_Email, final String User_password,final String User_Type) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Users").child(User_Type).child(User_Name).exists())){
                    HashMap<String,Object> userdatamap=new HashMap<>();
                    userdatamap.put("email",User_Email);
                    userdatamap.put("name",User_Name);
                    userdatamap.put("type",User_Type);
                    userdatamap.put("password",User_password);
                    RootRef.child("Users").child(User_Type).child(User_Name).updateChildren(userdatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){Toast.makeText(Sign_UpActivity.this,"your account has been created",Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                Intent loginintent =new Intent(Sign_UpActivity.this, courses_activity.class);
                                startActivity(loginintent);}else {Toast.makeText(Sign_UpActivity.this,"Network is very bad",Toast.LENGTH_SHORT).show();}
                        }
                    });
                }
                else {Toast.makeText(Sign_UpActivity.this,"This "+User_Name+"Is already registered please try another Email",Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                    Intent Mainintent =new Intent(Sign_UpActivity.this,student_activity.class);
                    startActivity(Mainintent);}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}