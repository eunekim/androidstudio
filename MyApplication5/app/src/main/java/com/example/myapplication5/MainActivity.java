package com.example.myapplication5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.BreakIterator;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    myPictureView myPicture;
    int curNum=0;
    File[] imageFiles;
    String imageFname;

    TextView a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 일기장");

        ActivityCompat.requestPermissions(this, new String[] {android.
                Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);
        myPicture = (myPictureView) findViewById(R.id.myPictureView1);

        imageFiles = new File(Environment.getExternalStorageDirectory().
                getAbsolutePath()+"/Pictures").listFiles();
        imageFname = imageFiles[curNum].toString();
        myPicture.imagePath = imageFname;

        a = (TextView)findViewById(R.id.text1);

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum <= 0) {
                    imageFname = imageFiles[4].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    a.setText("5/5");
                } else {
                    curNum--;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    a.setText(curNum+1+"/5");
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (curNum >= imageFiles.length-1) {
                    imageFname = imageFiles[0].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    a.setText("1/5");
                } else {
                    curNum++;
                    imageFname = imageFiles[curNum].toString();
                    myPicture.imagePath = imageFname;
                    myPicture.invalidate();
                    a.setText(curNum+1+"/5");
                }

            }
        });

    }
}
