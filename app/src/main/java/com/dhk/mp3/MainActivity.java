package com.dhk.mp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnOption,btnPlay,btnPause;
    private TextView textName, textTime,textIdBaihat;
    private int id=0,time=0,path;
    private String name,tmp;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOption = findViewById(R.id.chon);
        btnPlay = findViewById(R.id.play);
        btnPause = findViewById(R.id.pause);
        textName = findViewById(R.id.baiHat);
        textTime = findViewById(R.id.textTime);
        textIdBaihat = findViewById(R.id.idBai);

        setOnClickButtonOption(btnOption);
        setOnClickButtonPlay(btnPlay);
        setOnClickButtonPause(btnPause);

        if(getIntent().getExtras() != null){
            String ID = getIntent().getExtras().get("id").toString();
            id = Integer.parseInt(ID);
            name=  getIntent().getExtras().get("name").toString();
            tmp= getIntent().getExtras().get("path").toString();
            path=Integer.parseInt(tmp);
            mediaPlayer =MediaPlayer.create(this,path);
            int time =mediaPlayer.getDuration()/1000;
            int minute = time/60;
            int sec = time%60;
            textTime.setText(minute+" min,"+sec+" sec");
            textIdBaihat.setText("Bài số " +ID);
            textName.setText(name);
        }
    }

    private void setOnClickButtonOption( Button btnOption){
        btnOption.setOnClickListener(item->{
            Intent intent =new Intent(MainActivity.this, Music.class);
            startActivity(intent);
            finish();
        });
    }

    private void setOnClickButtonPlay(Button btnPlay){
        btnPlay.setOnClickListener( item ->{
            if(this.id!=0){
                    mediaPlayer.start();
            }else{
                textName.setText("Bạn chưa chọn bài !");
            }
        });
    }

    private  void setOnClickButtonPause(Button btnPause){
        btnPause.setOnClickListener(item->{
            if(this.id!=0){
                mediaPlayer.stop();
            }else{
                textName.setText("Bạn chưa chọn bài !");
            }
        });
    }



}