package com.example.educare.professors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.educare.R;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.educare.Sign_UpActivity;
import com.example.educare.student.student_activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class materials extends AppCompatActivity {
     Button CreateCoursetButton;
     String CourseName , Subject, Code,CourseDescripton,CoursePeriod;
     EditText courseNameEdit,courseSubjectEdit,courseCodeEdit,courseDescriptonEdit,coursePeriodEdit;
    private ProgressDialog loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pof_materials);
        courseNameEdit=(TextInputEditText) findViewById(R.id.CourseNameEditText);
        courseSubjectEdit=(TextInputEditText) findViewById(R.id.subjectEdit);
        courseCodeEdit=(TextInputEditText)findViewById(R.id.courseCodeEdit);
        courseDescriptonEdit=(TextInputEditText) findViewById(R.id.courseDecEdit);
        coursePeriodEdit=(TextInputEditText)findViewById(R.id.coursePeriodEdit);
        CreateCoursetButton=(Button)findViewById(R.id.addButton)  ;
        loading=new ProgressDialog(this);
        CreateCoursetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateCourse();
            }
        });

        BottomNavigationView bottomNavigationViewprof=findViewById(R.id.bottom_navigationprof);
        bottomNavigationViewprof.setSelectedItemId(R.id.materials);
        bottomNavigationViewprof.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

        {
            @Override
            public boolean onNavigationItemSelected (@NonNull MenuItem item){
                switch (item.getItemId()) {
                    case R.id.materials:
                        return true;
                    case R.id.professor_chat:
                        startActivity(new Intent(getApplicationContext(), professors_chat.class));
                        return true;
                    case R.id.prfessor_student:
                        startActivity(new Intent(getApplicationContext(), professors.class));
                        return true;

                }

                return false;
            }
        });
    }

    private void CreateCourse() {
        CourseName = courseNameEdit.getText().toString();
      //  Subject = courseSubjectEdit.getText().toString();
        Code = courseCodeEdit.getText().toString();
        CourseDescripton = courseDescriptonEdit.getText().toString();
        CoursePeriod = coursePeriodEdit.getText().toString();


       /* if (TextUtils.isEmpty(User_Name)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_password)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(User_Email)) {
            Toast.makeText(Sign_UpActivity.this, "Please Write Your Email", Toast.LENGTH_SHORT).show();
      /*   else if (!Doc.isChecked() && !Student.isChecked()) {
            Toast.makeText(Sign_UpActivity.this, "Please Check Your Type", Toast.LENGTH_SHORT).show();
        }
    } else {*/
        loading.setTitle("Creating Course");
        loading.setMessage("Please Wait");
        loading.setCanceledOnTouchOutside(false);
        loading.show();
        ValidatePhoneNumber(CourseName,  Code, CourseDescripton, CoursePeriod);
        //    User_Type.equals("Student");
   /*   if(User_Type="Doctor";){
             Intent profintent =new Intent(Sign_UpActivity.this,professors.class);
             startActivity(profintent);


           /* if (User_Type == "Student") {
                Intent stuintent = new Intent(Sign_UpActivity.this, student_activity.class);
                startActivity(stuintent);
            }
*/


    }
    private void ValidatePhoneNumber(final String CourseName, final String Code,final String CourseDescripton,final String CoursePeriod) {
        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (!(dataSnapshot.child("Courses").child(Code).exists())){
                    HashMap<String,Object> coursedatamap=new HashMap<>();

                    coursedatamap.put("name",CourseName);
         //           coursedatamap.put("subject",Subject);
                    coursedatamap.put("code",Code);
                    coursedatamap.put("coursedescripton",CourseDescripton);
                    coursedatamap.put("courseperiod",CoursePeriod);

                    RootRef.child("Courses").child(Code).updateChildren(coursedatamap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(materials.this,"your Course has been created",Toast.LENGTH_SHORT).show();
                                loading.dismiss();

                            }
                        }
                    });
                }
                else {
                  //  Toast.makeText(Sign_UpActivity.this, "This " + User_Name + "Is already registered please try another Email", Toast.LENGTH_SHORT).show();
                    loading.dismiss();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}