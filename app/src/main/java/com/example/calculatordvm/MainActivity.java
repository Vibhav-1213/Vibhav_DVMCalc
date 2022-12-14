package com.example.calculatordvm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView Screen;
private Button AC,Power,Back,Div,Mul,Add,Sub,One,Two,Three,Four,Five,Six,Seven,Eight,Nine,Zero,Ans,Point,Equal;
private String input,Answer;
@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Screen=findViewById(R.id.screen);
        AC=findViewById(R.id.ac);
        Power=findViewById(R.id.power);
        Back=findViewById(R.id.back);
        Div=findViewById(R.id.div);
        Mul=findViewById(R.id.mul);
        Add=findViewById(R.id.add);
        Sub=findViewById(R.id.min);
        One=findViewById(R.id.one);
        Two =findViewById(R.id.two);
        Three=findViewById(R.id.three);
        Four=findViewById(R.id.four);
        Five =findViewById(R.id.five);
        Six=findViewById(R.id.six);
        Seven=findViewById(R.id.seven);
        Eight=findViewById(R.id.eight);
        Nine=findViewById(R.id.nine);
        Zero=findViewById(R.id.zero);
        Ans=findViewById(R.id.ans);
        Equal=findViewById(R.id.equal);
        Point=findViewById(R.id.point);
    }
    public void ButtonClick(View view){
    Button button=(Button) view;
    String data=button.getText().toString();
    switch (data){
        case "AC":
            input="";
            break;
        case "Ans":
            input+=Answer;
            break;
        case "x":
            input+="x";
            break;
        case "^":
            Solve();
            input+="^";
            break;
        case "=":
            Solve();
            Answer=input;
            break;
        case "BACK":
            String newText= input.substring(0,input.length()-1);
            input=newText;
            break;
        default:
            if(input==null)
            {
                input="";
            }
            if(data.equals("+")|| data.equals("-")|| data.equals("/")) {
                Solve();
            }
            input+=data;

    }
    Screen.setText(input);
}
private void Solve()
{
 if(input.split("\\*").length==2)
    {
        String number[]=input.split("\\*");
        try {
            double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
            input = mul+"";
        }catch(Exception e) {
        }
        }
    else if(input.split("/").length==2)
    {
        String number[]=input.split("/");
        try {
            double div = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
            input = div+"";
        }catch(Exception e)
        {
        }
    }
    else if(input.split("\\+").length==2)
    {
        String number[]=input.split("\\+");
        try {
            double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
            input = sum+"";
        }catch(Exception e) {
        }
    }
    else if(input.split("-").length>1)
    {
        String number[]=input.split("-");
        if(number[0]=="" && number.length==2)
            number[0]=0+"";
        try {
            double sub=0;
            if(number.length==2)
                sub=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
            else if(number.length==3)
                sub = Double.parseDouble(number[1]) - Double.parseDouble(number[2]);
            input = sub+"";
        }catch(Exception e) {
        }
    }
    else if(input.split("\\^").length==2) {
     String number[] = input.split("\\^");
     try {
         double power = Math.pow(Double.parseDouble(number[0]), Double.parseDouble(number[1]));
         input = power+"";
     } catch (Exception e) {
     }
   }
   String n[]=input.split("\\.");
    if(n.length>1)
    {
        if(n[1].equals("0"))
            input=n[10];
    }
    Screen.setText(input);
  }
}


