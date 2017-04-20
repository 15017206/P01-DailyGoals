package com.example.a15017206.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.x;
//import static com.example.a15017206.p01_dailygoals.R.id.radioButton;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton1;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton2;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton3;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton4;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton5;
import static com.example.a15017206.p01_dailygoals.R.id.radioButton6;

public class P01_DailyGoals extends AppCompatActivity {

    String a = "No";
    String b = "No";
    String c = "No";
    String d;




    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(), "onPaused", Toast.LENGTH_SHORT).show();

        //Shared Preferences
        SharedPreferences sp = getApplicationContext().getSharedPreferences("key1", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putString("key-rb1",a);
        e.putString("key-rb2",b);
        e.putString("key-rb3",c);
        e.putString("key-et4",d);
        e.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Shared Preferences
        SharedPreferences sp = getApplicationContext().getSharedPreferences("key1", MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();

        EditText et1 = (EditText) findViewById(R.id.editText2);
        et1.setText(sp.getString("key-et4",null));

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);




        if (sp.getString("key-rb1", null).equalsIgnoreCase("Yes")){
            Toast.makeText(getBaseContext(), "Test", Toast.LENGTH_SHORT).show();
            rg.check(radioButton1);
        }else {
            rg.check(radioButton2);
        }

        if (sp.getString("key-rb2", null).equalsIgnoreCase("Yes")){
            rg2.check(radioButton3);
        }else {
            rg2.check(radioButton4);
        }

        if (sp.getString("key-rb3", null).equalsIgnoreCase("Yes")){
            rg3.check(radioButton5);
        }else {
            rg3.check(radioButton6);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p01__daily_goals);

        Button btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
                EditText et1 = (EditText) findViewById(R.id.editText2);

                int selBtnId1 = rg.getCheckedRadioButtonId();
                int selBtnId2 = rg2.getCheckedRadioButtonId();
                int selBtnId3 = rg3.getCheckedRadioButtonId();

                // These 3 will output either "Yes" or "No"
                RadioButton rb1 = (RadioButton) findViewById(selBtnId1);
                RadioButton rb2 = (RadioButton) findViewById(selBtnId2);
                RadioButton rb3 = (RadioButton) findViewById(selBtnId3);

//                Toast.makeText(getBaseContext(), rb1.getText(), Toast.LENGTH_SHORT).show();

                //Put radio button options & EditText into an array
                String[] radioGroupEditText = {rb1.getText().toString(), rb2.getText().toString(),rb3.getText().toString(), et1.getText().toString()};

                Intent i = new Intent(P01_DailyGoals.this, P01_DailyGoals_2.class);
                i.putExtra("info", radioGroupEditText);

                startActivity(i);

                //Shared Preferences
                SharedPreferences sp = getApplicationContext().getSharedPreferences("key1", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();

                a = rb1.getText().toString();
                b = rb2.getText().toString();
                c = rb3.getText().toString();
                d = et1.getText().toString();

//                et1.setText(sp.getString("key-et4",null));
            }
        });
    }
}
