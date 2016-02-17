package com.example.memmed_hacili.exponentialcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText text1 , text2 , cavab;
    Button btn1 , btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = (EditText) findViewById(R.id.txt1);
        text2 = (EditText) findViewById(R.id.txt2);
        cavab = (EditText) findViewById(R.id.answer);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        setCalculateOnClickListener();
        setClearOnClickListener();
    }
    private double calc() {
        String s = text1.getText().toString();
        double cvb = 0.0;
        double u0 = 1.0;
        int runner = 0;
        double iki = Double.parseDouble(text2.getText().toString());
        double x = Math.pow(10 , iki);
        if(s.contains("/")) {
            int ind = s.indexOf("/");
            String str[] = s.split("/");
            String s1 = s.substring(0, ind);
            String s2 = s.substring(ind + 1, s.length());
            double xx = Double.parseDouble(s1);
            double yy = Double.parseDouble(s2);
            while(true) {

                runner ++;
                if(Double.compare(u0 , x) < 0)
                    break;
                cvb += u0;
                u0 *= xx;
                u0 /= yy;
                u0 /= ((double)runner);

            }
            return cvb;
        }
        else {
            double bir = Double.parseDouble(s);
            while (true) {
                runner++;
                if (Double.compare(u0, x) < 0)
                    break;
                cvb += u0;
                u0 *= bir;
                u0 /= ((double) runner);

            }
            return cvb;
        }
    }

    private void setCalculateOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (text1.getText().toString() != "" && text2.getText().toString() != "") {
                    double x = calc();

                    String s = Double.toString(x);
                    cavab.setText(s);
                }
            }
        };
        btn1.setOnClickListener(listener);
    }
    private void setClearOnClickListener() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                text2.setText("");
                cavab.setText("");
            }
        };
        btn2.setOnClickListener(listener);
    }


}
