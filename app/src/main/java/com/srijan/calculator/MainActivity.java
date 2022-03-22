package com.srijan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    TextView one,two,three,four,five,six,seven,eight,nine,ac,percent,remove;
    TextView add,multiply,division,sub,equals;
    TextView zero,zero2,point;
    TextView operations,answer;
    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six =  findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ac = findViewById(R.id.ac);
        percent = findViewById(R.id.percent);
        remove =  findViewById(R.id.remove);
        equals = findViewById(R.id.equals);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);

        operations = findViewById(R.id.textView2);
        answer = findViewById(R.id.textView);

        zero = findViewById(R.id.zero);
        zero2 = findViewById(R.id.zero2);
        point = findViewById(R.id.point);


        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               data =  operations.getText().toString();
               operations.setText(data + "1");

            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operations.setText(data + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "9");
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operations.setText("");
                answer.setText("");
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "%");
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText("" + data);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "+");
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "2");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "x");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data =  operations.getText().toString();
                operations.setText(data + "/");

            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = operations.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                answer.setText(finalResult);
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operations.setText( data + "0");
            }
        });

    }

}