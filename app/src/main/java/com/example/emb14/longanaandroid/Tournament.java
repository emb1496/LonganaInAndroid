/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tournament extends AppCompatActivity {
    /**
     * Created by emb14 on 11/12/2017.
     */
    private int score = 1;
    private int loadGame = -1;

    /**
     * returns score
     * @return - int
     */
    public int getScore(){
            return score;
        }

    /**
     * sets the score to num
     * @param num - int
     */
    public void setScore(int num){
            score = num;
        }

    /**
     * checks if the tournament is over
     * @param player1 - Human
     * @param player2 - Computer
     * @return boolean true - if the game is over false - otherwise
     */
    public boolean gameOver(Human player1, Computer player2){
        if(player1.getScore()>=score){
            return true;
        }
        if(player2.getScore()>=score){
            return true;
        }
        return false;
    }

    /**
     * sets up the tournament and the details to go along with it
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament);
        Bundle bundle = getIntent().getExtras();
        Button newGameButton = (Button)findViewById(R.id.StartNewGame);
        newGameButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Tournament.this, BoardView.class);
                Bundle bundle1 = new Bundle();
                bundle1.putInt("key", 0);
                intent.putExtras(bundle1);
                startActivity(intent);
            }
        });
        if(bundle != null) {
            loadGame = bundle.getInt("key");
        }
        if(loadGame == 0){
            // new game
            setTournScore();
            Intent intent = new Intent(Tournament.this, BoardView.class);
            bundle.putInt("key", 2);
            bundle.putInt("tournScore", score);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        else if(loadGame == 1){
            // load game
        }
        else if(loadGame == 2){
            int computerScore = bundle.getInt("compScore");
            int humanScore = bundle.getInt("humanScore");
            int tournScore = bundle.getInt("tournScore");
            TextView textView = (TextView)findViewById(R.id.eog);
            textView.setText("Tournament score: " + tournScore + '\n' + "Computer final score: " + computerScore + '\n' + "Human final score: " + humanScore);
        }
    }

    /**
     * sets the score to user entered number
     */
    private void setTournScore(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Enter Tournament Score: ");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setRawInputType(Configuration.KEYBOARD_12KEY);
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if(input.getText().length() != 0){
                    setScore(Integer.parseInt(input.getText().toString()));
                    throw new RuntimeException();
                }
                else{
                    setTournScore();
                    throw new RuntimeException();
                }
            }
        });
        alert.show();
        try { Looper.loop(); }
        catch (RuntimeException e2){return;}

    }
}
