package com.example.alpirayhaslak.animasyonson2;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    GifImageView karakter,boss;
    Button sag,sol,yukari,assagi,saldir;
    ConstraintLayout cl;
    boolean baslangicKontrol=false;
    boolean hizlanma=false,hizlanm2=false,tirmanma=false,saldiri =false,inme=false;
    boolean sagHareket = false,solHareket=false;
    float hiz=0,hiz2=0,hiz3=0,hiz4=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = findViewById(R.id.cl);
        karakter = findViewById(R.id.karakter);
        boss = findViewById(R.id.boss);
        sag = findViewById(R.id.button);
        sol = findViewById(R.id.button2);
        yukari = findViewById(R.id.button3);
        assagi = findViewById(R.id.button4);
        saldir = findViewById(R.id.button5);

        final Timer timer = new Timer(1000000000,1);

        sag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(baslangicKontrol){
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        karakter.setImageResource(R.drawable.roguewalk);
                        sagHareket=true;
                        hizlanma = true;
                    }else if(event.getAction()==MotionEvent.ACTION_UP){
                        karakter.setImageResource(R.drawable.roguesevinme);
                        sagHareket=true;
                        hizlanma = false;
                        hiz=0;
                    }
                }else{
                    baslangicKontrol = true;
                    timer.start();
                }
                return false;
            }
        });
        sol.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(baslangicKontrol){
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        karakter.setImageResource(R.drawable.roguewalksol);
                        solHareket=true;
                        hizlanm2=true;
                    }else if(event.getAction()==MotionEvent.ACTION_UP){
                        karakter.setImageResource(R.drawable.roguesevinme);
                        solHareket=true;
                        hizlanm2=false;
                        hiz2=0;
                    }
                }else{
                    baslangicKontrol=true;
                    timer.start();
                }
                return false;

            }
        });
        yukari.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(baslangicKontrol){
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        karakter.setImageResource(R.drawable.yukari);
                        tirmanma =true;
                    }else if(event.getAction()==MotionEvent.ACTION_UP){
                        karakter.setImageResource(R.drawable.roguesevinme);
                        tirmanma=false;
                        hiz3=0;
                    }
                }else{
                    baslangicKontrol=true;
                    timer.start();
                }
                return false;
            }
        });
        assagi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(baslangicKontrol){
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        karakter.setImageResource(R.drawable.yukari);
                        inme=true;
                    }else if(event.getAction()==MotionEvent.ACTION_UP){
                        karakter.setImageResource(R.drawable.roguesevinme);
                        inme=false;
                        hiz4=0;
                    }
                }else{
                    baslangicKontrol=true;
                    timer.start();
                }
                return false;
            }
        });
        saldir.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(baslangicKontrol){
                    if(event.getAction()==MotionEvent.ACTION_DOWN){
                        karakter.setImageResource(R.drawable.rogueatack);
                        if(solHareket){
                            karakter.setImageResource(R.drawable.rogueatacksol);
                            saldiri=true;
                        }
                        if(sagHareket){
                            karakter.setImageResource(R.drawable.rogueatack);
                            saldiri=true;
                        }
                    }
                    if(event.getAction()==MotionEvent.ACTION_UP){
                        karakter.setImageResource(R.drawable.roguesevinme);
                        saldiri = false;
                    }
                }else{
                    baslangicKontrol=true;
                    timer.start();
                }
                return false;
            }
        });


    }
    class Timer extends CountDownTimer{
        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            //KARAKTER SAĞ HAREKET
            if(hizlanma){
                hiz+=0.1;
            }
            karakter.setX(karakter.getX()+hiz);
            //KARAKTER SOL HAREKET
            if(hizlanm2){
                hiz2-=0.1;
            }
            karakter.setX(karakter.getX()+hiz2);
            //KARAKTER YUKARI HAREKETİ
            if(tirmanma){
                hiz3-=0.1;
            }
            karakter.setY(karakter.getY()+hiz3);
            //KARAKTER AŞŞAĞI HAREKET
            if(inme){
                hiz4+=0.1;
            }
            karakter.setY(karakter.getY()+hiz4);
            if(karakter.getY()<=0){ //ÜST SINIR
                karakter.setY(0);
            }
            if(karakter.getX()>=cl.getWidth()-karakter.getWidth()){ //sol SINIR
                karakter.setX(cl.getWidth()-karakter.getWidth());
            }
            if(karakter.getX()<=0){ //sağ sınır
                karakter.setX(0);
            }
            //KARAKTERLERİN ÇARPIŞMA HAREKETİ
            if(karakter.getX()+karakter.getWidth()+karakter.getHeight()>boss.getX()+boss.getWidth()+boss.getHeight()/2
                    && karakter.getY()+karakter.getHeight()>boss.getY()+boss.getWidth()/2){
                if(saldiri){
                    boss.setImageResource(R.drawable.magedeath2);
                }
            }
        }
        @Override
        public void onFinish() {
        }
    }
}
