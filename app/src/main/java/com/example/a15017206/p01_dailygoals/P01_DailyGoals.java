package com.example.a15017206.p01_dailygoals;

import android.content.Intent;
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

public class P01_DailyGoals extends AppCompatActivity {

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

                Toast.makeText(getBaseContext(), rb1.getText(), Toast.LENGTH_SHORT).show();

                //Put radio button options & EditText into an array
                String[] radioGroupEditText = {rb1.getText().toString(), rb2.getText().toString(),rb3.getText().toString(), et1.getText().toString()};

                Intent i = new Intent(P01_DailyGoals.this, P01_DailyGoals_2.class);
                i.putExtra("info", radioGroupEditText);

                startActivity(i);



            }
        });
    }
}
