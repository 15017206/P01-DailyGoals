package com.example.a15017206.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class P01_DailyGoals_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p01__daily_goals_2);

        TextView tv1 = (TextView) findViewById(R.id.textViewOutput);
        Button btn2 = (Button) findViewById(R.id.button2);

         Intent j = getIntent();
        String[] receive2 = j.getStringArrayExtra("info");

        tv1.setText("Read up on materials before class: " + receive2[0] + "\n"
                + "Arrive on time so as not to miss important part of the lesson: " + receive2[1] + "\n"
                + "Attempt the problem myself: " + receive2[2] + "\n \n"
                + "Reflection: " + receive2[3]
        );

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
