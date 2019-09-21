package com.ong.labactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private EditText mSchool1,mSchool2,mSchool3,mSchool4,mSchool5,mSchool6,mSchool7,mSchool8;
    private Button mSave, mNext;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("data1", MODE_PRIVATE);

        mSchool1 = findViewById(R.id.edit_school1);
        mSchool2 = findViewById(R.id.edit_school2);
        mSchool3 = findViewById(R.id.edit_school3);
        mSchool4 = findViewById(R.id.edit_school4);
        mSchool5 = findViewById(R.id.edit_school5);
        mSchool6 = findViewById(R.id.edit_school6);
        mSchool7 = findViewById(R.id.edit_school7);
        mSchool8 = findViewById(R.id.edit_school8);

        mSave = findViewById(R.id.btn_save);
        mNext = findViewById(R.id.btn_next);

        Set<String> set = new HashSet<>();

        mSave.setOnClickListener((View view)->{
            set.add(String.valueOf(mSchool1.getText()));
            set.add(String.valueOf(mSchool2.getText()));
            set.add(String.valueOf(mSchool3.getText()));
            set.add(String.valueOf(mSchool4.getText()));
            set.add(String.valueOf(mSchool5.getText()));
            set.add(String.valueOf(mSchool6.getText()));
            set.add(String.valueOf(mSchool7.getText()));
            set.add(String.valueOf(mSchool8.getText()));
            sharedPreferences.edit().putStringSet("schools", set).apply();
            Toast.makeText(this, "Saving", Toast.LENGTH_LONG).show();
        });
        mNext.setOnClickListener((View view)->{
            openActivity(VerifySchool.class);
        });
    }
    private void openActivity(Class activityClass){
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }


}
