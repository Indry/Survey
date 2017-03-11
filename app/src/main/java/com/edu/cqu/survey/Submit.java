package com.edu.cqu.survey;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageButton;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by 自无道处得吾道 on 2017/3/11.
 */
public class Submit extends Activity {
    static String information = "";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);
        final ImageButton submit = (ImageButton) findViewById(R.id.imageButton3);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            information = extras.getString("data_to_be_sent");
        }


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               saveToSDCard("Result.txt",information);
            }
        });

    }

    public boolean saveToSDCard(String fileName, String content) {

        // judge weather the SDCard exits,and can be read and written
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return false;
        }

        FileOutputStream fileOutputStream = null;
        File file = new File(Environment.getExternalStorageDirectory(),
                fileName);
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
