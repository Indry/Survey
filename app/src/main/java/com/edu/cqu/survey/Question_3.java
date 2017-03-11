package com.edu.cqu.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;



/**
 * Created by 自无道处得吾道 on 2017/3/11.
 */
public class Question_3 extends Activity {
    static String information ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_3);
        ImageButton mBtn_03 = (ImageButton)findViewById(R.id.imageButton);
        final RadioGroup userIncome = (RadioGroup)findViewById(R.id.radioGroup5) ;
        RadioButton _rbtn =(RadioButton)findViewById(R.id.radioButton4) ;
        _rbtn.setChecked(true);
        final RadioGroup userSingle = (RadioGroup)findViewById(R.id.radioGroup3) ;
        RadioButton _rbtn1 =(RadioButton)findViewById(R.id.radioButton5) ;
        _rbtn1.setChecked(true);
        final RadioGroup userMoney = (RadioGroup)findViewById(R.id.radioGroup4) ;
        RadioButton _rbtn2 =(RadioButton)findViewById(R.id.radioButton9) ;
        _rbtn2.setChecked(true);
        final RadioGroup userReason = (RadioGroup)findViewById(R.id.radioGroup6) ;
        RadioButton _rbtn3 =(RadioButton)findViewById(R.id.radioButton10) ;
        _rbtn3.setChecked(true);


        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            information = extras.getString("data_to_be_sent");

        }
        mBtn_03.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                           //收入人群
                                           int radioSelected_01 = userIncome.getCheckedRadioButtonId();
                                           RadioButton selected_01 = (RadioButton)findViewById(radioSelected_01);
                                           String income = selected_01.getText().toString();
                                           //是否结婚
                                           int radioSelected_02 = userSingle.getCheckedRadioButtonId();
                                           RadioButton selected_02 = (RadioButton)findViewById(radioSelected_02);
                                           String single = selected_02.getText().toString();
                                           //花多少钱用于休闲
                                           int radioSelected_03 = userMoney.getCheckedRadioButtonId();
                                           RadioButton selected_03 = (RadioButton)findViewById(radioSelected_03);
                                           String money = selected_03.getText().toString();
                                           //认同的休闲的原因
                                           int radioSelected_04 = userReason.getCheckedRadioButtonId();
                                           RadioButton selected_04 = (RadioButton)findViewById(radioSelected_04);
                                           String reason = selected_04.getText().toString();

                                           information = information +"\n"+income +"\n"+single+"\n"+money+"\n"+reason;
                                           Intent intent = new Intent(Question_3.this, Question_4.class);
                                           intent.putExtra("data_to_be_sent",information);
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}