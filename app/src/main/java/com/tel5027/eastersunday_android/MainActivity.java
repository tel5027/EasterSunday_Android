package com.tel5027.eastersunday_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button calculateButton = (Button) findViewById(R.id.calculateEaster);
        calculateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                EditText y = (EditText) findViewById(R.id.editText);
                TextView msg = (TextView) findViewById(R.id.easterDate);
                if(y.getText().length() == 0){
                    msg.setText("Invalid year");
                }
                else{
                    int year = Integer.parseInt(y.getText().toString());
                    int a = year % 19;
                    int b = year / 100;
                    int c = year % 100;
                    int d = b / 4;
                    int ee = b % 4;
                    int g = (8 * b + 13) / 25;
                    int h = (19 * a + b - d - g + 15) % 30;
                    int j = c / 4;
                    int k = c % 4;
                    int m = (a + 11 * h) / 319;
                    int r = (2 * ee + 2 * j - k - h + m + 32) % 7;
                    int n = (h - m + r + 90) / 25;
                    int p = (h - m + r + n + 19) % 32;

                    //Create the Month String used for display
                    String month;

                    if(n == 3)
                    {
                        month = "March ";
                    }
                    else
                    {
                        month = "April ";
                    }

                    msg.setText(month + p + ", " + year);
                }

            }
        });
    }
}
