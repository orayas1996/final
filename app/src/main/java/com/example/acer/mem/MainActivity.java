package com.example.acer.mem;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ImageView iv11,iv12,iv13,iv21,iv22,iv23;

    Integer[] cardsarray = {101,102,103,201,202,203};

    int img11,img12,img13,img21,img22,img23;
    int stcard,ndcard;
    int clickst,clicknd;
    int cardnum = 1;
    int turn =1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.button);

        btn.setVisibility(View.INVISIBLE);

        iv11 = (ImageView) findViewById(R.id.iv11);
        iv12 = (ImageView) findViewById(R.id.iv12);
        iv13 = (ImageView) findViewById(R.id.iv13);
        iv21 = (ImageView) findViewById(R.id.iv21);
        iv22 = (ImageView) findViewById(R.id.iv22);
        iv23 = (ImageView) findViewById(R.id.iv23);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv21.setTag("3");
        iv22.setTag("4");
        iv23.setTag("5");

        //load card img
        frontofCardResources();

        Collections.shuffle(Arrays.asList(cardsarray));

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv11,thecard);

            }
        });
        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv12,thecard);

            }
        });
        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv13,thecard);

            }
        });
        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv21,thecard);

            }
        });
        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv22,thecard);

            }
        });
        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int thecard = Integer.parseInt((String) v.getTag());
                doStuff(iv23,thecard);

            }
        });
    }

    private void doStuff(ImageView iv, int card){
        if(cardsarray[card] == 101){
            iv.setImageResource(img11);
        }else if(cardsarray[card] == 102){
            iv.setImageResource(img12);
        }else if(cardsarray[card] == 103) {
            iv.setImageResource(img13);
        }else if(cardsarray[card] == 201) {
            iv.setImageResource(img21);
        }else if(cardsarray[card] == 202) {
            iv.setImageResource(img22);
        }else if(cardsarray[card] == 203) {
            iv.setImageResource(img23);
        }

        if(cardnum ==1 ){
            stcard = cardsarray[card];
            if(stcard > 200){
                stcard = stcard - 100;
            }
            cardnum = 2;
            clickst = card;
            iv.setEnabled(false);
        }else if(cardnum == 2){
            ndcard = cardsarray[card];
            if(ndcard >200){
                ndcard = ndcard -100;
            }
            cardnum = 1;
            clicknd = card;

            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                 calculate();
                }
            }, 1000);
        }

    }
    private void calculate(){


        if(stcard == ndcard){
            if(clickst ==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clickst ==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clickst ==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clickst ==3){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clickst ==4){
                iv22.setVisibility(View.INVISIBLE);
            }else if(clickst ==5){
                iv23.setVisibility(View.INVISIBLE);
            }
            if(clicknd ==0){
                iv11.setVisibility(View.INVISIBLE);
            }else if(clicknd ==1){
                iv12.setVisibility(View.INVISIBLE);
            }else if(clicknd ==2){
                iv13.setVisibility(View.INVISIBLE);
            }else if(clicknd ==3){
                iv21.setVisibility(View.INVISIBLE);
            }else if(clicknd ==4){
                iv22.setVisibility(View.INVISIBLE);
            }else if(clicknd ==5) {
                iv23.setVisibility(View.INVISIBLE);
            }

            }else{
            iv11.setImageResource(R.drawable.bb);
            iv12.setImageResource(R.drawable.bb);
            iv13.setImageResource(R.drawable.bb);
            iv21.setImageResource(R.drawable.bb);
            iv22.setImageResource(R.drawable.bb);
            iv23.setImageResource(R.drawable.bb);
        }
        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);

        checkend();

    }

    private void checkend(){
        if(iv11.getVisibility() == View.INVISIBLE &&
                iv12.getVisibility() == View.INVISIBLE &&
                iv13.getVisibility() == View.INVISIBLE &&
                iv21.getVisibility() == View.INVISIBLE &&
                iv22.getVisibility() == View.INVISIBLE &&
                iv23.getVisibility() == View.INVISIBLE){


                Button btn = (Button) findViewById(R.id.button);

                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this,level2.class);
                        startActivity(i);
                    }
                });




//            AlertDialog.Builder alertDi = new AlertDialog.Builder(MainActivity.this);
//            alertDi
//                    .setMessage("เข้าสู่เลเวลที่2")
//                    .setCancelable(false)
//                btn.setOnClickListener(new OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int i) {
//                                    Intent intent = new Intent(MainActivity.this,level2.class);
//                                    startActivity(intent);
//                                    finish();
//
//                                }
//                    });
////                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
////                        @Override
////                        public void onClick(DialogInterface dialog, int i) {
////                            finish();
////                        }
////                    });
//            AlertDialog alertDialog = alertDi.create();
//            alertDialog.show();

        }


    }
    private void frontofCardResources(){
        img11 = R.drawable.n;
        img12 = R.drawable.d;
        img13 = R.drawable.b;
        img21 = R.drawable.n1;
        img22 = R.drawable.d1;
        img23 = R.drawable.b1;

    }

}
