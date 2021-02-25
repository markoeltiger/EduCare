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
import android.widget.TextView;
import android.widget.Toast;

import com.example.educare.professors.professors;
import com.example.educare.student.student_activity;
import com.example.educare.student.courses_activity;
import com.example.educare.professors.materials;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
//Register For Student

public class Sign_UpActivity extends AppCompatActivity {
     String User_Name,User_Email,User_password,User_Type,User_Faculty,User_Phone,User_Id,User_Year,User_Depart;
    private Button CreateAccountButton;
    private RadioButton Male,Famale;
    private EditText InputName,InputEmail,InputPassword,Faculty_name,InputPhone,InputUserNumber,InputYear,InputProfCode,
            Inputdepart,InputpositionProf;
    private ProgressDialog loading;
    private TextView titlePROF,titleSTU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign__up);
        titleSTU=findViewById(R.id.titleSTU);
        titlePROF=findViewById(R.id.titlePRoF);
        InputName=(EditText) findViewById(R.id.register_name_number_input);
        InputEmail=(EditText)findViewById(R.id.register_email_input);
        Faculty_name=(EditText)findViewById(R.id.Faculty_name);
        InputPassword=(EditText) findViewById(R.id.register_password_input);
        InputPhone=(EditText)findViewById(R.id.userphone);
        InputYear=(EditText)findViewById(R.id.useryear);
        InputUserNumber=(EditText)findViewById(R.id.userID);
        CreateAccountButton=(Button) findViewById(R.id.register_login_btn);
        //مارك دول الى اخدتهم من صفحة البروفيسور شوف لو هتزودهم علي ال database
        InputProfCode=(EditText)findViewById(R.id.usercode);
        Inputdepart=(EditText)findViewById(R.id.depart);
        InputpositionProf=(EditText)findViewById(R.id.positionProf);
        Male=(RadioButton)findViewById(R.id.radioMale);
        Famale=(RadioButton)findViewById(R.id.radioFamale);


        int mode=getIntent().getIntExtra("type",0);
        // 1= professor
        if(mode==1){
            titleSTU.setVisibility(View.GONE);
            titlePROF.setVisibility(View.VISIBLE);
            InputName.setVisibility(View.VISIBLE);
            InputEmail.setVisibility(View.VISIBLE);
            Faculty_name.setVisibility(View.VISIBLE);
            InputPassword.setVisibility(View.VISIBLE);
            InputPhone.setVisibility(View.VISIBLE);
            InputYear.setVisibility(View.GONE);
            InputUserNumber.setVisibility(View.GONE);
            InputProfCode.setVisibility(View.VISIBLE);
            Inputdepart.setVisibility(View.VISIBLE);
            InputpositionProf.setVisibility(View.VISIBLE);
            Male.setVisibility(View.VISIBLE);
            Famale.setVisibility(View.VISIBLE);
            CreateAccountButton.setVisibility(View.VISIBLE);
            User_Type ="Doctor";
        }
        //2=student
        else if( mode==2){
            titleSTU.setVisibility(View.VISIBLE);
            titlePROF.setVisibility(View.GONE);
            InputName.setVisibility(View.VISIBLE);
            InputEmail.setVisibility(View.VISIBLE);
            Faculty_name.setVisibility(View.VISIBLE);
            InputPassword.setVisibility(View.VISIBLE);
            InputPhone.setVisibility(View.VISIBLE);
            InputYear.setVisibility(View.VISIBLE);
            InputUserNumber.setVisibility(View.VISIBLE);
            InputProfCode.setVisibility(View.GONE);
            InputpositionProf.setVisibility(View.GONE);
            Male.setVisibility(View.VISIBLE);
            Inputdepart.setVisibility(View.VISIBLE);
            Famale.setVisibility(View.VISIBLE);
            CreateAccountButton.setVisibility(View.VISIBLE);
            User_Type ="Student";
        }



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
        User_Faculty = Faculty_name.getText().toString();
        User_Phone = InputPhone.getText().toString();
        User_Year = InputYear.getText().toString();
        User_Id = InputUserNumber.getText().toString();

        if (TextUtils.isEmpty(User_Name)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_password)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_Email)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Email", Toast.LENGTH_SHORT).show();
      /*   else if (!Doc.isChecked() && !Student.isChecked()) {
            Toast.makeText(Sign_UpActivity.this, "Please Check Your Type", Toast.LENGTH_SHORT).show();
        } */
        } else {
            loading.setTitle("Create Account");
            loading.setMessage("Please Wait");
            loading.setCanceledOnTouchOutside(false);
            loading.show();
            //    User_Type.equals("Student");
   /*   if(User_Type="Doctor";){
             Intent profintent =new Intent(Sign_UpActivity.this,professors.class);
             startActivity(profintent);


           /* if (User_Type == "Student") {
                Intent stuintent = new Intent(Sign_UpActivity.this, student_activity.class);
                startActivity(stuintent);
            }
*/
            ValidatePhoneNumber(User_Name, User_Email, User_password, User_Type, User_Faculty, User_Phone, User_Year, User_Id);

        }
    }
    private void ValidatePhoneNumber(final String User_Name, final String User_Email, final String User_password,final String User_Type,final String User_Faculty,final String User_Phone,final String User_Year ,final String User_Id) {
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
                    userdatamap.put("faculty",User_Faculty);
                    userdatamap.put("phone",User_Phone);
                    userdatamap.put("year",User_Year);
                    userdatamap.put("id",User_Id);
                    RootRef.child("Users").child(User_Type).child(User_Name).updateChildren(userdatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){Toast.makeText(Sign_UpActivity.this,"your account has been created",Toast.LENGTH_SHORT).show();
                                loading.dismiss();
                                if (User_Type == "Student") {
                                    Intent stuintent = new Intent(Sign_UpActivity.this, student_activity.class);
                                    stuintent.putExtra("name",User_Name);
                                    startActivity(stuintent);
                                }else {Toast.makeText(Sign_UpActivity.this,"Network is very bad",Toast.LENGTH_SHORT).show();}
                                if(User_Type .equals("Doctor") ) {
                                    Intent profintent = new Intent(Sign_UpActivity.this, professors.class);
                                    startActivity(profintent);

                                }

                                }
                        }
                    });
                }
                else {
                    Toast.makeText(Sign_UpActivity.this, "This " + User_Name + "Is already registered please try another Email", Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }

        }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
    });

}
}