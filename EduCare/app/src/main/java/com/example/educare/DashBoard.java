package com.example.educare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import io.paperdb.Paper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.educare.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DashBoard extends AppCompatActivity {
TextView gotosignup;
    private CardView LogInButton;
    private EditText InputPassword,InputPhone;
    private ProgressDialog loading;
    private String parentDbName ="Users";
   // private CheckBox mCheckBox;
    private TextView AdminPanelTextView,NotAdmenLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
       Paper.init(this);
        LogInButton=(CardView)findViewById(R.id.login_login_btn);
        InputPassword=(EditText)findViewById(R.id.login_password_input);
        InputPhone=(EditText)findViewById(R.id.login_name_input);
        gotosignup=(TextView)findViewById(R.id.textView3);
        loading=new ProgressDialog(this);
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });


















        gotosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Sign_Up =new Intent(DashBoard.this,Sign_UpActivity.class);
                startActivity(Sign_Up);
            }
        });
    }
    private void LoginUser() {
        String password=InputPassword.getText().toString();
        String Name=InputPhone.getText().toString();
        if (TextUtils.isEmpty(password)){
            Toast.makeText(DashBoard.this,"Please Write Your Name",Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(Name)){
            Toast.makeText(DashBoard .this,"Please Write Your phone",Toast.LENGTH_SHORT).show();
        }
        else {loading.setTitle("Login Account");
            loading.setMessage("Please Wait...");
            loading.setCanceledOnTouchOutside(false);
            loading.show();



            AllowAccessToAccount(Name,password);
        }
    }
    private void AllowAccessToAccount(final String phone, final String password) {

        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child("Student").child(phone).exists())
                {
                    Users users =dataSnapshot.child(parentDbName).child("Student").child(phone).getValue(Users.class);
                    if (users.getName().equals(phone)){
                        if (users.getPassword().equals(password)){
                           if (parentDbName.equals("Users")){ Toast.makeText(DashBoard.this,"Welcome "+users.getName().toString()+".",Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                Intent HomeIntent =new Intent(DashBoard.this,MainActivity.class);
                                startActivity(HomeIntent);}

                        }else{Toast.makeText(DashBoard.this,"wrong password",Toast.LENGTH_SHORT).show();
                            loading.dismiss();}
                    }


                }else {

                    Toast.makeText(DashBoard.this,"Account with this "+phone+" doesn`y exist ,please Create an account to login",Toast.LENGTH_SHORT).show();
                    Intent Registerintent =new Intent(DashBoard.this,MainActivity.class);
                    startActivity(Registerintent);
                    loading.dismiss();}
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}