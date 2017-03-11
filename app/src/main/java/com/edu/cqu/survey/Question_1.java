package com.edu.cqu.survey;

/**
 * Created by 自无道处得吾道 on 2017/3/10.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;

public class Question_1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_1);
        ImageButton mBtn_01 = (ImageButton)findViewById(R.id.imgbtn);
        final EditText  userName = (EditText)findViewById(R.id.etName);
        final RadioGroup userGender = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton rbtn =(RadioButton)findViewById(R.id.rbGenger2) ;
        rbtn.setChecked(true);
        mBtn_01.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                           String name = userName.getText().toString();
                                           int radioSelected = userGender.getCheckedRadioButtonId();

                                           RadioButton selected = (RadioButton) findViewById(radioSelected);
                                           String gender = selected.getText().toString();
                                           String information = name + "\n"+gender;
                                           Intent intent = new Intent(Question_1.this, Question_2.class);
                                           intent.putExtra("data_to_be_sent",information);
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}
