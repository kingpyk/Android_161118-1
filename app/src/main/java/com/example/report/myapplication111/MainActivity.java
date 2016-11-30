package com.example.report.myapplication111;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button btn1,btn2,btn3,btn4,btn5;
    TextView tv12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1;
        setTitle("초간단 계산기(수정)");

        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        tv12 = (TextView) findViewById(R.id.textView2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator('+');
            }

        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator('-');
            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator('*');
            }

        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator('/');
            }

        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator('%');
            }

        });
    }
    void calculator(char op){
        if(e1.getText().length() ==0 || e2.getText().length() ==0){
            Toast.makeText(getApplicationContext(),"값을 입력해주세요",Toast.LENGTH_SHORT).show();
            return;
        }
        double num1, num2;
        double Result=0;

        num1 = Double.parseDouble(e1.getText().toString());
        num2 = Double.parseDouble(e2.getText().toString());

        if (op=='+') Result = num1+num2;
        if (op=='-') Result = num1-num2;
        if (op=='*') Result = num1*num2;
        if (op=='/') {
            if(e1.getText().toString().equals("0"))
            {
                Toast.makeText(getApplicationContext(),"0으로 나눌수없습니다.",Toast.LENGTH_SHORT).show();
                return;
            }
            if(e2.getText().toString().equals("0"))
            {
                Toast.makeText(getApplicationContext(),"0으로 나눌수없습니다.",Toast.LENGTH_SHORT).show();
                return;
            }
            Result = num1/num2;
        }
        if (op=='%') Result = num1%num2;

        tv12.setText("계산결과 :"+Result);
    }
}