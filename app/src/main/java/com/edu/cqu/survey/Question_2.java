package com.edu.cqu.survey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * Created by 自无道处得吾道 on 2017/3/11.
 */
public class Question_2 extends Activity {
    static String ways = "";
    static String information = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_2);
        ImageButton mBtn_02 = (ImageButton)findViewById(R.id.imgBtn1);
        Bundle extras = getIntent().getExtras();
        final RadioGroup userAge = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioButton rbtn =(RadioButton)findViewById(R.id.rBtnAge2) ;
        rbtn.setChecked(true);
        final RadioGroup userTime = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioButton _rbtn =(RadioButton)findViewById(R.id.rBtnTime2) ;
        _rbtn.setChecked(true);
        final CheckBox cBox1 = (CheckBox)findViewById(R.id.cBoxHobby1);
        final CheckBox cBox2 = (CheckBox)findViewById(R.id.cBoxHobby2);
        final CheckBox cBox3 = (CheckBox)findViewById(R.id.cBoxHobby3);
        final CheckBox cBox4 = (CheckBox)findViewById(R.id.cBoxHobby4);

        //给CheckBox设置事件监听

        cBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                String way = cBox1.getText().toString();
                if(isChecked){
                   ways = ways+"\n"+way;
                }

            }
        });

        cBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                String way =  cBox2.getText().toString();
                if(isChecked){


                    ways = ways+"\n"+way;
                }
            }
        });

        cBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                String way =  cBox3.getText().toString();
                if(isChecked){


                    ways = ways+"\n"+way;
                }
            }
        });
        cBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton buttonView,
                                         boolean isChecked) {
                // TODO Auto-generated method stub
                String way =  cBox4.getText().toString();
                if(isChecked){


                     ways = ways+"\n"+way;
                }
            }
        });

        if (extras != null) {
            information = extras.getString("data_to_be_sent");
        }

        mBtn_02.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                           //得到年龄
                                           int radioSelected = userAge.getCheckedRadioButtonId();
                                           RadioButton selected = (RadioButton) findViewById(radioSelected);
                                           String age = selected.getText().toString();
                                           //得到休息时间
                                           int _radioSelected = userTime.getCheckedRadioButtonId();
                                           RadioButton _selected = (RadioButton) findViewById(_radioSelected);
                                           String time = _selected.getText().toString();

                                           information = information +"\n"+age +"\n" + ways + "\n"+time;
                                           Intent intent = new Intent(Question_2.this, Question_3.class);
                                           intent.putExtra("data_to_be_sent",information);
                                           startActivity(intent);
                                       }
                                   }
        );
    }
}