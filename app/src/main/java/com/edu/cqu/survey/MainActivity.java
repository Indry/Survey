package com.edu.cqu.survey;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btn =(ImageButton)findViewById(R.id.btnStart);
        btn.setOnClickListener(new View.OnClickListener() {

                                   @Override
                                   public void onClick(View v) {

                                       Intent intent = new Intent(MainActivity.this, Question_1.class);
                                       startActivity(intent);
                                   }
                               }
            );
        }
}
