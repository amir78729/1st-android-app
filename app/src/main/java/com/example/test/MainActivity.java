package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int moves;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button playAgain;
    private TextView title;
    private TextView status;

    private char[] gameField = new char[9];
    private Button[] myButtons = new Button[9];

    private boolean playerNumber1Turn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgain = findViewById(R.id.playAgain);

        title = findViewById(R.id.title);
        status = findViewById(R.id.status);

        button1 = findViewById(R.id.b1);
        button2 = findViewById(R.id.b2);
        button3 = findViewById(R.id.b3);
        button4 = findViewById(R.id.b4);
        button5 = findViewById(R.id.b5);
        button6 = findViewById(R.id.b6);
        button7 = findViewById(R.id.b7);
        button8 = findViewById(R.id.b8);
        button9 = findViewById(R.id.b9);

        myButtons[0] = button1;
        myButtons[1] = button2;
        myButtons[2] = button3;
        myButtons[3] = button4;
        myButtons[4] = button5;
        myButtons[5] = button6;
        myButtons[6] = button7;
        myButtons[7] = button8;
        myButtons[8] = button9;



        clearTheGameField();

        button1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(1,playerNumber1Turn);

               }
           }
        );

        button2.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(2,playerNumber1Turn);

               }
           }
        );

        button3.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(3,playerNumber1Turn);

               }
           }
        );
        button4.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(4,playerNumber1Turn);

               }
           }
        );
        button5.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(5,playerNumber1Turn);

               }
           }
        );
        button6.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(6,playerNumber1Turn);

               }
           }
        );
        button7.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(7,playerNumber1Turn);

               }
           }
        );
        button8.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(8,playerNumber1Turn);

               }
           }
        );
        button9.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   press(9,playerNumber1Turn);

               }
           }
        );
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearTheGameField();
                enableAllButtons();
                playerNumber1Turn = true;
                status.setText("X's turn...");
                playAgain.setVisibility(View.INVISIBLE);
            }
        });
    }


    public void press(int i, boolean IsPlayerNumber1Turn){
        i--;
        if(IsPlayerNumber1Turn){
            myButtons[i].setText("❌");
            myButtons[i].setEnabled(false);
            gameField[i] = 'X';
            status.setText("O's turn...");
        }else{
            myButtons[i].setText("⭕");
            myButtons[i].setEnabled(false);
            gameField[i] = 'O';
            status.setText("X's turn...");
        }
        moves++;
        playerNumber1Turn = !playerNumber1Turn;
        if (isTheGameOver()){
            gameOver();
        }else if(moves >= 9){
            draws();
        }
    }

    public boolean isTheGameOver(){
        if (gameField[0] == gameField[1] && gameField[1] == gameField[2] && gameField[2] != '-')
            return true;
        if (gameField[0] == gameField[4] && gameField[4] == gameField[8] && gameField[8] != '-')
            return true;
        if (gameField[0] == gameField[3] && gameField[3] == gameField[6] && gameField[6] != '-')
            return true;
        if (gameField[2] == gameField[5] && gameField[5] == gameField[8] && gameField[8] != '-')
            return true;
        if (gameField[6] == gameField[7] && gameField[7] == gameField[8] && gameField[8] != '-')
            return true;
        if (gameField[2] == gameField[4] && gameField[4] == gameField[6] && gameField[6] != '-')
            return true;
        if (gameField[3] == gameField[4] && gameField[4] == gameField[5] && gameField[5] != '-')
            return true;
        if (gameField[1] == gameField[4] && gameField[4] == gameField[7] && gameField[7] != '-')
            return true;
        return false;
    }

    public void clearTheGameField(){
        moves = 0;
        for (int i = 0 ; i < 9 ; i++){
            gameField[i] = '-';
            myButtons[i].setText("-");
        }
    }

    public void disableAllButtons(){
        for (int i = 0 ; i < 9 ; i++){
            myButtons[i].setEnabled(false);
        }
    }

    public void enableAllButtons(){
        for (int i = 0 ; i < 9 ; i++){
            myButtons[i].setEnabled(true);
        }
    }

    public void gameOver(){
        disableAllButtons();
        if (!playerNumber1Turn){
            status.setText("player X won!");
        }else{
            status.setText("player O won!");
        }
        playAgain.setVisibility(View.VISIBLE);
    }
    public void draws(){
        disableAllButtons();
            status.setText("no winners!");
        playAgain.setVisibility(View.VISIBLE);
    }
}
