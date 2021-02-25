package com.example.educare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SingUpAs extends AppCompatActivity {
    CardView cardprof,cardstud;
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up_as);
        cardprof=findViewById(R.id.card_prof_id);
        cardprof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 1;
                Intent intent=new Intent(SingUpAs.this,Sign_UpActivity.class);
                intent.putExtra("type",mode);
                startActivity(intent);
            }
        });
        cardstud=findViewById(R.id.card_stud_id);
        cardstud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mode = 2;
                Intent intent=new Intent(SingUpAs.this,Sign_UpActivity.class);
                intent.putExtra("type",mode);
                startActivity(intent);
            }
        });
    }
}