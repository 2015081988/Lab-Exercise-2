package com.ong.labactivity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class VerifySchool extends AppCompatActivity {

    private EditText mSchool;
    private Button mVerify;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_school);
        Set<String> schools = sharedPreferences.getStringSet("schools", new HashSet<>());
        sharedPreferences = getSharedPreferences("data1", MODE_PRIVATE);
        initializeWidget();

        mVerify.setOnClickListener((View view)->{
            boolean found = false;
            String inputSchool = String.valueOf(mSchool.getText());
            for (String school: schools) {
                if(inputSchool.equals(school) && !inputSchool.isEmpty()){
                    Toast.makeText(this, "School is competing in UAAP", Toast.LENGTH_LONG).show();
                    found = true;
                }
            }
            if(!found){
                Toast.makeText(this, "School is not part of UAAP", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initializeWidget(){
        mVerify = findViewById(R.id.btn_verify);
        mSchool = findViewById(R.id.edit_verify_school);
    }
}
