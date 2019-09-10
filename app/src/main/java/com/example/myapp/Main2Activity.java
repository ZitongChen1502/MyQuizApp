package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class Main2Activity extends MainActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
       Button buttonBack = (Button) findViewById(R.id.buttonBack);
      final TextView Per = (TextView) findViewById(R.id.Percentage);
       final TextView Com = (TextView) findViewById(R.id.Comments);
       Intent intent = getIntent();
       int total = intent.getIntExtra("total_pass", 1);
       int correct = intent.getIntExtra("total_right",0);
       if(total == -1){
            Per.setText("You haven't started?");
        }
       else{Per.setText("You went through " + total +" vocabs; you got " + correct +" of them correct. Your accuracy is " + (double) correct/total + ".");}
       if(total == -1){
           Com.setText("Start working now!");
       }
       else if((double) correct/total ==0){
           Com.setText("Seriously?");
       }
       else if((double) correct/total <0.6){
           Com.setText("Work harder!!! You don't want to fail!");
        }
        else if((double) correct/total <0.8){
           Com.setText("Getting better! Keep up good work!");
       }
       else if((double) correct/total <0.95){
           Com.setText("You are AMAZING!");
       }
       else{
           Com.setText("Spectacular!!!");
       }





        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

    }

}
