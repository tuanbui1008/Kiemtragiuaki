package com.dhk.mp3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Music extends AppCompatActivity {
    private Button btn1,btnOption,btn2,btn3,btn4,btn5,btn6;
    private TextView id;
    private int uri;
    private String name;
    private boolean check=false;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mp3_option);
        btn1= findViewById(R.id.bai1);
        btnOption= findViewById(R.id.option);
        id= findViewById(R.id.idBai);
        btn2=findViewById(R.id.bai2);
        btn3=findViewById(R.id.bai3);
        btn4=findViewById(R.id.bai4);
        btn5=findViewById(R.id.bai5);
        btn6=findViewById(R.id.bai6);
        btn1.setOnClickListener(item->{
            check=true;
            id.setText("1");
            uri=R.raw.namquocsonha;
            name="Nam quốc sơn hà";
        });
        btn2.setOnClickListener(item->{
            check=true;
            id.setText("2");
            uri=R.raw.anthan;
            name="An thần";
        });
        btn3.setOnClickListener(item->{
            check=true;
            id.setText("3");
            uri=R.raw.conmuatinhyeu;
            name="Cơn mưa tình yêu";
        }); btn4.setOnClickListener(item->{
            check=true;
            id.setText("4");
            uri=R.raw.lalung;
            name="Lạ lùng";
        }); btn5.setOnClickListener(item->{
            check=true;
            id.setText("5");
            uri=R.raw.motphut;
            name="1 phút";
        }); btn6.setOnClickListener(item->{
            check=true;
            id.setText("6");
            uri=R.raw.treasure;
            name="Treasure";
        });

        btnOption.setOnClickListener(item->{
            if(check){
                Intent  intent = new Intent(Music.this, MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("id",String.valueOf(id.getText()));
                intent.putExtra("path",String.valueOf(uri));
                startActivity(intent);
                finish();
            }
        });
    }



}
