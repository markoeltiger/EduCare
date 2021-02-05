package com.example.educare;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class course_application extends AppCompatActivity {

    TextView nameTxt,subjectTxt,periodTxt,codeTxt,descriptionTxt;
    Button cancelbtn,addbtn;
    TextInputLayout nameEdt,periodEdit,codeEdit,descriptionEdit,subjectEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt=findViewById(R.id.courseName);
        subjectTxt=findViewById(R.id.subject);
        periodTxt=findViewById(R.id.coursePeriod);
        codeTxt=findViewById(R.id.courseCode);
        descriptionTxt=findViewById(R.id.courseDec);

        cancelbtn=findViewById(R.id.cancelButton);
        addbtn=findViewById(R.id.addButton);

        nameEdt=findViewById(R.id.courseNameEdit);
        periodEdit=findViewById(R.id.coursePeriodEdit);
        codeEdit=findViewById(R.id.courseCodeEdit);
        descriptionEdit=findViewById(R.id.courseDecEdit);
        subjectEdit=findViewById(R.id.subiectEdit);



    }
}