package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.test.R.color.*;

public class MainActivity extends AppCompatActivity {
    private int moves;
    private Button playAgain;
    private TextView status;
    private ImageButton changeTheme;
    private char[] gameField = new char[9];
    private Button[] myButtons = new Button[9];
    private TextView title;
    private boolean isLight = true;

    private boolean playerNumber1Turn = true;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playAgain = findViewById(R.id.playAgain);

        status = findViewById(R.id.status);

        Button button1 = findViewById(R.id.b1);
        Button button2 = findViewById(R.id.b2);
        Button button3 = findViewById(R.id.b3);
        Button button4 = findViewById(R.id.b4);
        Button button5 = findViewById(R.id.b5);
        Button button6 = findViewById(R.id.b6);
        Button button7 = findViewById(R.id.b7);
        Button button8 = findViewById(R.id.b8);
        Button button9 = findViewById(R.id.b9);

//        changeTheme = findViewById(R.id.change_theme);

        myButtons[0] = button1;
        myButtons[1] = button2;
        myButtons[2] = button3;
        myButtons[3] = button4;
        myButtons[4] = button5;
        myButtons[5] = button6;
        myButtons[6] = button7;
        myButtons[7] = button8;
        myButtons[8] = button9;

        title = findViewById(R.id.title);

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
                status.setText(R.string.X_turn);
                playAgain.setVisibility(View.INVISIBLE);
            }
        });

        changeTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTheTheme(isLight);
                isLight = !isLight;
            }
        });
    }


    public void press(int i, boolean IsPlayerNumber1Turn){
        i--;
        if(IsPlayerNumber1Turn){
            myButtons[i].setText("✖");
            myButtons[i].setEnabled(false);
            gameField[i] = 'X';
            status.setText(R.string.O_turn);
        }else{
            myButtons[i].setText("⭕");
            myButtons[i].setEnabled(false);
            gameField[i] = 'O';
            status.setText(R.string.X_turn);
        }
        Log.d("TTT", "button number "+(i+1)+" pressed");
        moves++;
        Log.d("TTT", "" + moves + "move(s)");

        playerNumber1Turn = !playerNumber1Turn;
        if (hasTheGameAWinner()){
            gameOver();
        }else if(moves >= 9){
            draws();
        }
    }

    public boolean hasTheGameAWinner(){
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
        if (gameField[3] == gameField[4] && gameField[4]  == gameField[5] && gameField[5] != '-')
            return true;
        return gameField[1] == gameField[4] && gameField[4] == gameField[7] && gameField[7] != '-';
    }

    public void clearTheGameField(){
        moves = 0;
        for (int i = 0 ; i < 9 ; i++){
            gameField[i] = '-';
            myButtons[i].setText(R.string.no_input_yet);
        }
        Log.d("TTT", "clearTheGameField: ");
    }

    public void disableAllButtons(){
        for (int i = 0 ; i < 9 ; i++){
            myButtons[i].setEnabled(false);
        }
        Log.d("TTT", "disableAllButtons: ");

    }

    public void enableAllButtons(){
        for (int i = 0 ; i < 9 ; i++){
            myButtons[i].setEnabled(true);
        }
        Log.d("TTT", "enableAllButtons: ");
    }

    public void gameOver(){
        disableAllButtons();
        if (!playerNumber1Turn){
            status.setText(R.string.X_won);
            Toast.makeText(getApplicationContext(),R.string.X_won, Toast.LENGTH_LONG).show();

        }else{
            status.setText(R.string.O_won);
            Toast.makeText(getApplicationContext(),R.string.O_won, Toast.LENGTH_LONG).show();
        }
        playAgain.setVisibility(View.VISIBLE);
        Log.d("TTT", "gameOver: ");
    }
    public void draws(){
        disableAllButtons();
        status.setText(R.string.no_winners);
        Toast.makeText(getApplicationContext(),R.string.no_winners, Toast.LENGTH_LONG).show();
        playAgain.setVisibility(View.VISIBLE);
        Log.d("TTT", "draws: ");

    }

    @SuppressLint("ResourceAsColor")
    public void changeTheTheme(boolean isLight){
        if (isLight){
            status.setTextColor(lightBackground);
            status.setTextColor(lightBackground);
            for (Button b : myButtons){
                b.setTextColor(lightBackground);
                b.setBackgroundColor(darkBackground);
            }
        }else{
            status.setTextColor(darkBackground);
            status.setTextColor(darkBackground);
            for (Button b : myButtons){
                b.setTextColor(darkBackground);
                b.setBackgroundColor(lightBackground);
            }
        }
    }
}
