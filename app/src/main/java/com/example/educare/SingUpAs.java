package com.example.educare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingUpAs extends AppCompatActivity {
    CardView cardprof,cardstud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up_as);
        cardprof=findViewById(R.id.card_prof_id);
        cardprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profsingup=new Intent(SingUpAs.this,Sign_UpActivity.class);
                profsingup.putExtra("type","Doctor");
                startActivity(profsingup);
            }
        });
        cardstud=findViewById(R.id.card_stud_id);
        cardstud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent studentIntent=new Intent(SingUpAs.this,Sign_UpActivity.class);
                studentIntent.putExtra("type","Student");
                startActivity(studentIntent);
            }
        });
    }
}