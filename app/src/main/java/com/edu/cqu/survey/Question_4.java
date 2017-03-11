package com.edu.cqu.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 自无道处得吾道 on 2017/3/11.
 */
public class Question_4 extends Activity {
    static String information = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_4);
        ImageButton mBtn_04 = (ImageButton)findViewById(R.id.imageButton2);
        final EditText etEmail = (EditText)findViewById(R.id.etEmail);
        final EditText etPhone = (EditText)findViewById(R.id.etPhone);
        final RadioGroup userChoose = (RadioGroup)findViewById(R.id.radioGroup7) ;
        RadioButton _rbtn3 =(RadioButton)findViewById(R.id.radioButton14) ;
        _rbtn3.setChecked(true);
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            information = extras.getString("data_to_be_sent");

        }

        mBtn_04.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                           String mail = etEmail.getText().toString();
                                          if( isEmail(mail)!=true){
                                              Toast.makeText(Question_4.this,"you should insert the right email!",Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                           String phone = etPhone.getText().toString();
                                           information = information + "\n"+mail+"\n"+phone;
                                           Intent intent = new Intent(Question_4.this, Submit.class);
                                           intent.putExtra("data_to_be_sent",information);
                                           startActivity(intent);

                                       }
                                   }
        );
    }

    public boolean isEmail(String eml)
    {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(eml);

        return m.matches();
    }
}