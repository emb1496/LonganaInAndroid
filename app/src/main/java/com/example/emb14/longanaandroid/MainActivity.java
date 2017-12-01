/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * determines if the player wants to load a game or make a new game and goes
     * to BoardView
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newGame = (Button)findViewById(R.id.NewGame);
        Button loadGame = (Button) findViewById(R.id.LoadGame);
        newGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, BoardView.class);
                Bundle bundle = new Bundle();

                bundle.putInt("key", 0);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        loadGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, BoardView.class);
                Bundle bundle = new Bundle();

                bundle.putInt("key", 1);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
