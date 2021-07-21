package com.example.emirim_project_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ImageView imgv = findViewById(R.id.imgv);
        TextView text1 = findViewById(R.id.text_result1);
        TextView text2 = findViewById(R.id.text_result2);
        Intent intent = getIntent();

        double w = intent.getDoubleExtra("weight", 0);
        double h = intent.getDoubleExtra("height", 0);

        double bmi = w / Math.pow(h * 0.01, 2);

        String bmiStr = "";
        int imgSrcId = 0;
        int bmiCommentId = 0;

        if(bmi < 18.5){
            bmiStr = "저체중";
            imgSrcId = R.drawable.bmi1;
            bmiCommentId = R.string.bmi_comment1;
        }else if(bmi < 24){
            bmiStr = "정상";
            imgSrcId = R.drawable.bmi2;
            bmiCommentId = R.string.bmi_comment2;
        }else if(bmi < 30){
            bmiStr = "과체중";
            imgSrcId = R.drawable.bmi3;
            bmiCommentId = R.string.bmi_comment3;
        }else if(bmi < 35){
            bmiStr = "비만";
            imgSrcId = R.drawable.bmi4;
            bmiCommentId = R.string.bmi_comment4;
        }else if(bmi < 40){
            bmiStr = "고도비만";
            imgSrcId = R.drawable.bmi5;
            bmiCommentId = R.string.bmi_comment5;
        }else{
            bmiStr = " 초고도비만";
            imgSrcId = R.drawable.bmi6;
            bmiCommentId = R.string.bmi_comment6;
        }

        imgv.setImageResource(imgSrcId);
        text1.setText(String.format("귀하의 BMI지수는 %.2f(㎏/㎡)이므로 %s입니다.", bmi, bmiStr));
        text2.setText(bmiCommentId);
    }
}