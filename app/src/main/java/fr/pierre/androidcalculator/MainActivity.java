package fr.pierre.androidcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,addition,soustraction,multiplication,division,init,egal,point;
    EditText res;
    EditText res2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);

        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b0 = (Button) findViewById(R.id.button0);

        addition = (Button) findViewById(R.id.buttonPlus);
        soustraction = (Button) findViewById(R.id.buttonMoins);
        multiplication = (Button) findViewById(R.id.buttonMultiplier);
        division = (Button) findViewById(R.id.buttonDivision);
        init = (Button) findViewById(R.id.buttonC);
        egal = (Button) findViewById(R.id.buttonEgal);
        point = (Button) findViewById(R.id.buttonPoint);

        res = (EditText) findViewById(R.id.EditText01);
        res2 = (EditText) findViewById(R.id.EditText02);


        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("9");
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction("0");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreAction(".");
            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurAction("+");
            }
        });
        soustraction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurAction("-");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurAction("*");
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                operateurAction("/");
            }
        });
        egal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalAction();
            }
        });
        init.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                initAction();
            }
        });
    }

    Service calculator = new Service(-1,-1,"");

    public void chiffreAction(String str){
        str = res.getText() + str;
        res.setText(str);
    }
    public void operateurAction(String str){
        calculator = init(str, calculator);
    }
    public void egalAction(){
        calculator = init2(calculator);
        calcul(calculator);
        calculator.nb1 = -1;
        calculator.nb2 = -1;
        calculator.operator = "";
    }
    public void initAction(){
        calculator.nb1 = -1;
        calculator.nb2 = -1;
        calculator.operator = "";
        res.setText("");
        res2.setText("");
    }

    public Service init(String operator,Service service){
        if(service.nb1 == -1){
            service.nb1 = Double.valueOf(res.getText().toString()).doubleValue();
            res.setText("");
            service.operator = operator;
        }
        return service;
    }
    public Service init2(Service service){
        if(service.nb1 == -1 || service.operator == ""){

        }
        else{
            service.nb2 = Double.valueOf(res.getText().toString()).doubleValue();
        }
        return service;
    }

    public void calcul(Service service){
        double result = 0.0;
        switch (service.operator){
            case "+":
                result = service.nb1 + service.nb2;
                res2.setText(service.nb1 + service.operator + service.nb2);
                break;
            case "-":
                result = service.nb1 - service.nb2;
                res2.setText(service.nb1 + service.operator + service.nb2);
                break;
            case "*":
                result = service.nb1 * service.nb2;
                res2.setText(service.nb1 + service.operator + service.nb2);
                break;
            case "/":
                result = service.nb1 / service.nb2;
                res2.setText(service.nb1 + service.operator + service.nb2);
                break;
        }
        res.setText(String.valueOf(result));
    }
}
