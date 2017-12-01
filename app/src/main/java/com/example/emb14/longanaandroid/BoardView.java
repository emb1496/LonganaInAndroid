/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.ActivityCompat;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class BoardView extends Activity implements View.OnClickListener {
    private Board myBoard = new Board();
    private Round myRound = new Round();
    private Tournament myTournament = new Tournament();
    private Human human = new Human();
    private Computer computer = new Computer();
    private Help help = new Help();
    private int tileindex = -1;
    private int loadGame = -1;
    private char next = '\0';
    private Serialization mySave = new Serialization();

    /**
     * Checks if we are loading or starting new game, sets the on click listeners for all the buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_view);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        InputMethodManager imm = (InputMethodManager)getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(findViewById(android.R.id.content).getRootView().getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            loadGame=bundle.getInt("key");
        }

        if(loadGame == 0){
            Intent intent = new Intent(BoardView.this, Tournament.class);
            Bundle bundle1 = new Bundle();
            bundle1.putInt("key", loadGame);
            intent.putExtras(bundle1);
            startActivity(intent);
        }
        else if (loadGame == 1){
            loadGame();
        }
        else if(loadGame == 2){
            myTournament.setScore(bundle.getInt("tournScore"));
            newGame();
            View(myBoard.getTheBoard(),human.getPlayerHand(),computer.getPlayerHand(),myBoard.getBoneyard());
        }

        ImageButton ImageButton1 = (ImageButton) findViewById(R.id.ImageButton1);
        ImageButton1.setOnClickListener(this);
        ImageButton ImageButton2 = (ImageButton) findViewById(R.id.ImageButton2);
        ImageButton2.setOnClickListener(this);
        ImageButton ImageButton3 = (ImageButton) findViewById(R.id.ImageButton3);
        ImageButton3.setOnClickListener(this);
        ImageButton ImageButton4 = (ImageButton) findViewById(R.id.ImageButton4);
        ImageButton4.setOnClickListener(this);
        ImageButton ImageButton5 = (ImageButton) findViewById(R.id.ImageButton5);
        ImageButton5.setOnClickListener(this);
        ImageButton ImageButton6 = (ImageButton) findViewById(R.id.ImageButton6);
        ImageButton6.setOnClickListener(this);
        ImageButton ImageButton7 = (ImageButton) findViewById(R.id.ImageButton7);
        ImageButton7.setOnClickListener(this);
        ImageButton ImageButton8 = (ImageButton) findViewById(R.id.ImageButton8);
        ImageButton8.setOnClickListener(this);
        ImageButton ImageButton9 = (ImageButton) findViewById(R.id.ImageButton9);
        ImageButton9.setOnClickListener(this);
        ImageButton ImageButton10 = (ImageButton) findViewById(R.id.ImageButton10);
        ImageButton10.setOnClickListener(this);
        ImageButton ImageButton11 = (ImageButton) findViewById(R.id.ImageButton11);
        ImageButton11.setOnClickListener(this);
        ImageButton ImageButton12 = (ImageButton) findViewById(R.id.ImageButton12);
        ImageButton12.setOnClickListener(this);
        ImageButton ImageButton13 = (ImageButton) findViewById(R.id.ImageButton13);
        ImageButton13.setOnClickListener(this);
        ImageButton ImageButton14 = (ImageButton) findViewById(R.id.ImageButton14);
        ImageButton14.setOnClickListener(this);
        ImageButton ImageButton15 = (ImageButton) findViewById(R.id.ImageButton15);
        ImageButton15.setOnClickListener(this);
        ImageButton ImageButton16 = (ImageButton) findViewById(R.id.ImageButton16);
        ImageButton16.setOnClickListener(this);
        ImageButton ImageButton17 = (ImageButton) findViewById(R.id.ImageButton17);
        ImageButton17.setOnClickListener(this);
        ImageButton ImageButton18 = (ImageButton) findViewById(R.id.ImageButton18);
        ImageButton18.setOnClickListener(this);
        ImageButton ImageButton19 = (ImageButton) findViewById(R.id.ImageButton19);
        ImageButton19.setOnClickListener(this);
        ImageButton ImageButton20 = (ImageButton) findViewById(R.id.ImageButton20);
        ImageButton20.setOnClickListener(this);
        ImageButton ImageButton21 = (ImageButton) findViewById(R.id.ImageButton21);
        ImageButton21.setOnClickListener(this);
        ImageButton ImageButton22 = (ImageButton) findViewById(R.id.ImageButton22);
        ImageButton22.setOnClickListener(this);
        ImageButton ImageButton23 = (ImageButton) findViewById(R.id.ImageButton23);
        ImageButton23.setOnClickListener(this);
        ImageButton ImageButton24 = (ImageButton) findViewById(R.id.ImageButton24);
        ImageButton24.setOnClickListener(this);
        ImageButton ImageButton25 = (ImageButton) findViewById(R.id.ImageButton25);
        ImageButton25.setOnClickListener(this);
        ImageButton ImageButton26 = (ImageButton) findViewById(R.id.ImageButton26);
        ImageButton26.setOnClickListener(this);
        ImageButton ImageButton27 = (ImageButton) findViewById(R.id.ImageButton27);
        ImageButton27.setOnClickListener(this);
        ImageButton ImageButton28 = (ImageButton) findViewById(R.id.ImageButton28);
        ImageButton28.setOnClickListener(this);
        ImageButton ImageButton29 = (ImageButton) findViewById(R.id.ImageButton29);
        ImageButton29.setOnClickListener(this);
        ImageButton ImageButton30 = (ImageButton) findViewById(R.id.ImageButton30);
        ImageButton30.setOnClickListener(this);
        ImageButton ImageButton31 = (ImageButton) findViewById(R.id.ImageButton31);
        ImageButton31.setOnClickListener(this);
        ImageButton ImageButton32 = (ImageButton) findViewById(R.id.ImageButton32);
        ImageButton32.setOnClickListener(this);
        ImageButton ImageButton33 = (ImageButton) findViewById(R.id.ImageButton33);
        ImageButton33.setOnClickListener(this);
        ImageButton ImageButton34 = (ImageButton) findViewById(R.id.ImageButton34);
        ImageButton34.setOnClickListener(this);
        ImageButton ImageButton35 = (ImageButton) findViewById(R.id.ImageButton35);
        ImageButton35.setOnClickListener(this);
        ImageButton ImageButton36 = (ImageButton) findViewById(R.id.ImageButton36);
        ImageButton36.setOnClickListener(this);
        ImageButton ImageButton37 = (ImageButton) findViewById(R.id.ImageButton37);
        ImageButton37.setOnClickListener(this);
        ImageButton ImageButton38 = (ImageButton) findViewById(R.id.ImageButton38);
        ImageButton38.setOnClickListener(this);
        ImageButton ImageButton39 = (ImageButton) findViewById(R.id.ImageButton39);
        ImageButton39.setOnClickListener(this);
        ImageButton ImageButton40 = (ImageButton) findViewById(R.id.ImageButton40);
        ImageButton40.setOnClickListener(this);
        ImageButton ImageButton41 = (ImageButton) findViewById(R.id.ImageButton41);
        ImageButton41.setOnClickListener(this);
        ImageButton ImageButton42 = (ImageButton) findViewById(R.id.ImageButton42);
        ImageButton42.setOnClickListener(this);
        ImageButton ImageButton43 = (ImageButton) findViewById(R.id.ImageButton43);
        ImageButton43.setOnClickListener(this);
        ImageButton ImageButton44 = (ImageButton) findViewById(R.id.ImageButton44);
        ImageButton44.setOnClickListener(this);
        ImageButton ImageButton45 = (ImageButton) findViewById(R.id.ImageButton45);
        ImageButton45.setOnClickListener(this);
        ImageButton ImageButton46 = (ImageButton) findViewById(R.id.ImageButton46);
        ImageButton46.setOnClickListener(this);
        ImageButton ImageButton47 = (ImageButton) findViewById(R.id.ImageButton47);
        ImageButton47.setOnClickListener(this);
        ImageButton ImageButton48 = (ImageButton) findViewById(R.id.ImageButton48);
        ImageButton48.setOnClickListener(this);
        ImageButton ImageButton49 = (ImageButton) findViewById(R.id.ImageButton49);
        ImageButton49.setOnClickListener(this);
        ImageButton ImageButton50 = (ImageButton) findViewById(R.id.ImageButton50);
        ImageButton50.setOnClickListener(this);
        ImageButton ImageButton51 = (ImageButton) findViewById(R.id.ImageButton51);
        ImageButton51.setOnClickListener(this);
        ImageButton ImageButton52 = (ImageButton) findViewById(R.id.ImageButton52);
        ImageButton52.setOnClickListener(this);
        ImageButton ImageButton53 = (ImageButton) findViewById(R.id.ImageButton53);
        ImageButton53.setOnClickListener(this);
        ImageButton ImageButton54 = (ImageButton) findViewById(R.id.ImageButton54);
        ImageButton54.setOnClickListener(this);
        ImageButton ImageButton55 = (ImageButton) findViewById(R.id.ImageButton55);
        ImageButton55.setOnClickListener(this);
        ImageButton ImageButton56 = (ImageButton) findViewById(R.id.ImageButton56);
        ImageButton56.setOnClickListener(this);
        ImageButton ImageButton57 = (ImageButton) findViewById(R.id.ImageButton57);
        ImageButton57.setOnClickListener(this);
        ImageButton ImageButton58 = (ImageButton) findViewById(R.id.ImageButton58);
        ImageButton58.setOnClickListener(this);
        ImageButton ImageButton59 = (ImageButton) findViewById(R.id.ImageButton59);
        ImageButton59.setOnClickListener(this);
        ImageButton ImageButton60 = (ImageButton) findViewById(R.id.ImageButton60);
        ImageButton60.setOnClickListener(this);
        ImageButton ImageButton61 = (ImageButton) findViewById(R.id.ImageButton61);
        ImageButton61.setOnClickListener(this);
        ImageButton ImageButton62 = (ImageButton) findViewById(R.id.ImageButton62);
        ImageButton62.setOnClickListener(this);
        ImageButton ImageButton63 = (ImageButton) findViewById(R.id.ImageButton63);
        ImageButton63.setOnClickListener(this);
        ImageButton ImageButton64 = (ImageButton) findViewById(R.id.ImageButton64);
        ImageButton64.setOnClickListener(this);
        ImageButton ImageButton65 = (ImageButton) findViewById(R.id.ImageButton65);
        ImageButton65.setOnClickListener(this);
        ImageButton ImageButton66 = (ImageButton) findViewById(R.id.ImageButton66);
        ImageButton66.setOnClickListener(this);
        ImageButton ImageButton67 = (ImageButton) findViewById(R.id.ImageButton67);
        ImageButton67.setOnClickListener(this);
        ImageButton ImageButton68 = (ImageButton) findViewById(R.id.ImageButton68);
        ImageButton68.setOnClickListener(this);
        ImageButton ImageButton69 = (ImageButton) findViewById(R.id.ImageButton69);
        ImageButton69.setOnClickListener(this);
        ImageButton ImageButton70 = (ImageButton) findViewById(R.id.ImageButton70);
        ImageButton70.setOnClickListener(this);

        Button Left = (Button) findViewById(R.id.LBut);
        Left.setOnClickListener(this);
        Button Right = (Button) findViewById(R.id.RBut);
        Right.setOnClickListener(this);

        Button Pass = (Button) findViewById(R.id.PassButton);
        Pass.setOnClickListener(this);
        Button Save = (Button) findViewById(R.id.SaveAndExit);
        Save.setOnClickListener(this);
        Button Help = (Button) findViewById(R.id.HelpButton);
        Help.setOnClickListener(this);
        Button Play = (Button) findViewById(R.id.ComputerPlay);
        Play.setOnClickListener(this);
    }

    /**
     * Onclicklistener for the buttons which the user can click
     * Calls the appropriate functions based on the intents of the user
     * @param view
     */
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.ImageButton57:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 0;
                break;
            case R.id.ImageButton58:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 1;
                break;
            case R.id.ImageButton59:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 2;
                break;
            case R.id.ImageButton60:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 3;
                break;
            case R.id.ImageButton61:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 4;
                break;
            case R.id.ImageButton62:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 5;
                break;
            case R.id.ImageButton63:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 6;
                break;
            case R.id.ImageButton64:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 7;
                break;
            case R.id.ImageButton65:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 8;
                break;
            case R.id.ImageButton66:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 9;
                break;
            case R.id.ImageButton67:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 10;
                break;
            case R.id.ImageButton68:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 11;
                break;
            case R.id.ImageButton69:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 12;
                break;
            case R.id.ImageButton70:
                Toast.makeText(this,"Press the  'L' or the 'R' buttons to place the tile", Toast.LENGTH_SHORT).show();
                tileindex = 13;
                break;
            case R.id.RBut:
                if(tileindex >= 0){
                    humanPlayTile(tileindex, 'R');
                }
                break;
            case R.id.LBut:
                if(tileindex>= 0){
                    humanPlayTile(tileindex, 'L');
                }
                break;
            case R.id.HelpButton:
                getHelp();
                break;
            case R.id.PassButton:
                if(!human.hasLegalMove(computer.getPassed(), myBoard.getTheBoard().get(0).getLeft(), myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight())){
                    humanPass();
                }
                else{
                    Toast.makeText(this, "You have a legal move", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.SaveAndExit:
                saveAndExit();
                break;
            case R.id.ComputerPlay:
                computerPlayTile();
                break;
            default:
                Toast.makeText(this, "You can't do that stupid", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * lets the user enter the filename and calls loadGame
     */
    private void loadGame(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter file name: ");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String filename = input.getText().toString();
                String [] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
                int permission = ActivityCompat.checkSelfPermission(BoardView.this, Manifest.permission.READ_EXTERNAL_STORAGE);
                if(permission != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(BoardView.this, PERMISSIONS_STORAGE, 1);
                }
                String save = mySave.loadGame(filename, myTournament, computer, human, myBoard, myRound, next);
                if(save.compareTo("DNE") == 0){
                    loadGame();
                }
                else if(save.compareTo("Done") != 0){
                    Toast.makeText(BoardView.this, save, Toast.LENGTH_LONG).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(BoardView.this, BoardView.class);
                Bundle bundle = new Bundle();
                bundle.putInt("key", 0);
                intent.putExtras(bundle);
                dialog.cancel();
                startActivity(intent);
            }
        });
        builder.show();
        View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
    }

    /**
     * Allows user to enter filename to save to and calls the serialization class
     */
    private void saveAndExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Enter file name: ");

        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            String filename = input.getText().toString();
            String[] PERMISSIONS_STORAGE = {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
            int permission = ActivityCompat.checkSelfPermission(BoardView.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if(permission != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(BoardView.this, PERMISSIONS_STORAGE, 1);
            }
            if(mySave.saveAndExit(filename, myTournament, myRound, computer, human, myBoard, next)){
                finishAffinity();
            }
            else{
                Toast.makeText(BoardView.this, "Serialization Error",Toast.LENGTH_SHORT).show();
            }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                throw new RuntimeException();
            }
        });

        builder.show();
    }

    /**
     * calls the Help class getHelp method
     */
    private void getHelp(){
        Toast.makeText(this,help.getHelp(next, human, computer, myBoard), Toast.LENGTH_SHORT).show();
        View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
    }

    /**
     * calls the Computer class computer play tile method, tells the user what happened, and then
     * sets the next player to human and calls View method
     */
    private void computerPlayTile() {
        String value = computer.computerPlayTile(next, myBoard, human);
        Toast.makeText(this, value,Toast.LENGTH_SHORT).show();
        next = 'H';
        View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
    }

    /**
     * Calls the Human class humanPass method and makes the appropriate updated to the next player and such
     */
    private void humanPass(){
        if(human.humanPass(next, myBoard).compareTo("You have drawn a tile, if you pass again Computer will play") != 0){
            next = 'C';
        }
        View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
    }

    /**
     * calls Human class human play tile method and updates the view
     * @param index - which tile to play
     * @param side - which side to play it on
     */
    private void humanPlayTile(int index, char side){
        String value = "";
        value = human.humanPlayTile(next, index, side, myBoard, computer);
        if(value.compareTo("It is the Computer move.") != 0){
            Toast.makeText(this, "It is the Computer move.", Toast.LENGTH_SHORT).show();
            next = 'C';
        }
        else if(value.compareTo("") != 0){
            next = 'C';
        }
        View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
    }

    /**
     * Updated the GUI based on the gamestate
     * @param theBoard
     * @param human
     * @param comp
     * @param stock
     */
    private void View(ArrayList<Tile> theBoard, ArrayList<Tile> human, ArrayList<Tile> comp, ArrayList<Tile> stock){
        tileindex = -1;
        ViewGroup layout = (ViewGroup)findViewById(R.id.ComputerHandView);
        for(int i = 0; i < layout.getChildCount(); i++){
            View child = layout.getChildAt(i);
            if(child instanceof ImageButton){
                ImageButton button = (ImageButton) child;
                if(i >= comp.size()){
                    button.setVisibility(View.GONE);
                }
                else{
                    button.setVisibility(View.VISIBLE);
                    switch(comp.get(i).getLeft()){
                        case 0:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.zerozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twozero);
                                     break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                            }
                            break;
                        case 1:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.oneone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                            }
                            break;
                        case 2:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.twozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twotwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                            }
                            break;
                        case 3:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                            }
                            break;
                        case 4:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                            }
                            break;
                        case 5:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                            }
                            break;
                        case 6:
                            switch (comp.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixsix);
                                    break;
                            }
                            break;
                    }
                }
                button.setPadding(5, 0, 5, 0);
                button.setClickable(false);
            }
        }

        layout = (ViewGroup)findViewById(R.id.BoardViewLayout);
        for(int i = 0; i < layout.getChildCount(); i++){
            View child = layout.getChildAt(i);
            if(child instanceof ImageButton){
                ImageButton button = (ImageButton) child;
                if(i > theBoard.size()){
                    button.setVisibility(View.GONE);
                }
                else if(i == 0){

                }
                else if(i == layout.getChildCount()-1){

                }
                else{
                    button.setRotation(0);
                    button.setVisibility(View.VISIBLE);
                    if(theBoard.get(i-1).getLeft() == theBoard.get(i-1).getRight()){
                        switch(theBoard.get(i-1).getRight()){
                            case 0:
                                button.setBackgroundResource(R.drawable.zerozero);
                                button.setRotation(90);
                                break;
                            case 1:
                                button.setBackgroundResource(R.drawable.oneone);
                                button.setRotation(90);
                                break;
                            case 2:
                                button.setBackgroundResource(R.drawable.twotwo);
                                button.setRotation(90);
                                break;
                            case 3:
                                button.setBackgroundResource(R.drawable.threethree);
                                button.setRotation(90);
                                break;
                            case 4:
                                button.setBackgroundResource(R.drawable.fourfour);
                                button.setRotation(90);
                                break;
                            case 5:
                                button.setBackgroundResource(R.drawable.fivefive);
                                button.setRotation(90);
                                break;
                            case 6:
                                button.setBackgroundResource(R.drawable.sixsix);
                                button.setRotation(90);
                                break;
                        }
                    }
                    else{
                        switch (theBoard.get(i-1).getLeft()){
                            case 0:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.zerozero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.onezero);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.twozero);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.threezero);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fourzero);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fivezero);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixzero);
                                        break;
                                }
                                break;
                            case 1:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.onezero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.oneone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.twoone);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.threeone);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fourone);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fiveone);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixone);
                                        break;
                                }
                                break;
                            case 2:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.twozero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.twoone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.twotwo);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.threetwo);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fourtwo);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fivetwo);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixtwo);
                                        break;
                                }
                                break;
                            case 3:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.threezero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.threeone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.threetwo);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.threethree);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fourthree);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fivethree);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixthree);
                                        break;
                                }
                                break;
                            case 4:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.fourzero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.fourone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.fourtwo);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.fourthree);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fourfour);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fivefour);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixfour);
                                        break;
                                }
                                break;
                            case 5:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.fivezero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.fiveone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.fivetwo);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.fivethree);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.fivefour);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.fivefive);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixfive);
                                        break;
                                }
                                break;
                            case 6:
                                switch (theBoard.get(i-1).getRight()){
                                    case 0:
                                        button.setBackgroundResource(R.drawable.sixzero);
                                        break;
                                    case 1:
                                        button.setBackgroundResource(R.drawable.sixone);
                                        break;
                                    case 2:
                                        button.setBackgroundResource(R.drawable.sixtwo);
                                        break;
                                    case 3:
                                        button.setBackgroundResource(R.drawable.sixthree);
                                        break;
                                    case 4:
                                        button.setBackgroundResource(R.drawable.sixfour);
                                        break;
                                    case 5:
                                        button.setBackgroundResource(R.drawable.sixfive);
                                        break;
                                    case 6:
                                        button.setBackgroundResource(R.drawable.sixsix);
                                        break;
                                }
                                break;
                        }
                            // check against the tile on the right if it needs to be rotated
                        if(theBoard.get(i-1).getRight() > theBoard.get(i-1).getLeft()){
                            button.setRotation(180);
                        }
                    }
                }
                button.setPadding(5, 0, 5, 0);
                button.setClickable(false);
            }
        }
        layout = (ViewGroup)findViewById(R.id.BoneYardView);

        for(int i = 0; i < layout.getChildCount(); i++){
            View child = layout.getChildAt(i);
            if(child instanceof ImageButton){
                ImageButton button = (ImageButton) child;
                if(i >= stock.size()){
                    button.setVisibility(View.GONE);
                }
                else{
                    button.setVisibility(View.VISIBLE);
                    switch (stock.get(i).getLeft()){
                        case 0:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.zerozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twozero);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                            }
                            break;
                        case 1:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.oneone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                            }
                            break;
                        case 2:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.twozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twotwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                            }
                            break;
                        case 3:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                            }
                            break;
                        case 4:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                            }
                            break;
                        case 5:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                            }
                            break;
                        case 6:
                            switch (stock.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixsix);
                                    break;
                            }
                            break;
                    }
                }
                button.setPadding(30, 0, 30, 0);
                button.setClickable(false);
            }
        }
        layout = (ViewGroup)findViewById(R.id.HumanHandView);
        for(int i = 0; i < layout.getChildCount(); i++){
            View child = layout.getChildAt(i);
            if(child instanceof ImageButton){
                ImageButton button = (ImageButton) child;
                if(i >= human.size()){
                    button.setVisibility(View.GONE);
                }
                else{
                    button.setVisibility(View.VISIBLE);
                    switch (human.get(i).getLeft()){
                        case 0:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.zerozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twozero);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                            }
                            break;
                        case 1:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.onezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.oneone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                            }
                            break;
                        case 2:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.twozero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.twoone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.twotwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                            }
                            break;
                        case 3:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.threezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.threeone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.threetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.threethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                            }
                            break;
                        case 4:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fourzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fourone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fourtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fourthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fourfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                            }
                            break;
                        case 5:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.fivezero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.fiveone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.fivetwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.fivethree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.fivefour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.fivefive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                            }
                            break;
                        case 6:
                            switch (human.get(i).getRight()){
                                case 0:
                                    button.setBackgroundResource(R.drawable.sixzero);
                                    break;
                                case 1:
                                    button.setBackgroundResource(R.drawable.sixone);
                                    break;
                                case 2:
                                    button.setBackgroundResource(R.drawable.sixtwo);
                                    break;
                                case 3:
                                    button.setBackgroundResource(R.drawable.sixthree);
                                    break;
                                case 4:
                                    button.setBackgroundResource(R.drawable.sixfour);
                                    break;
                                case 5:
                                    button.setBackgroundResource(R.drawable.sixfive);
                                    break;
                                case 6:
                                    button.setBackgroundResource(R.drawable.sixsix);
                                    break;
                            }
                            break;
                    }
                }
                button.setPadding(30, 0, 30, 0);
                button.setClickable(true);
            }
        }
        TextView TournDisplay = (TextView)findViewById(R.id.TournamentDisplay);
        TournDisplay.setText("Tournament score: " + myTournament.getScore());

        TextView HumanScore = (TextView)findViewById(R.id.HumanScoreDisplay);
        HumanScore.setText("Human score: " + this.human.getScore());

        TextView ComputerScore = (TextView)findViewById(R.id.ComputerScoreDisplay);
        ComputerScore.setText("Computer score: " + computer.getScore());

        if (this.human.getDrew() == 1){
            Button SaveImageButton = (Button)findViewById(R.id.SaveAndExit);
            SaveImageButton.setVisibility(View.GONE);
        }
        else{
            Button SaveImageButton = (Button)findViewById(R.id.SaveAndExit);
            SaveImageButton.setVisibility(View.VISIBLE);
        }

        if(myRound.roundOver(this.human, computer, myBoard.getBoneyard())){
            int cscore = computer.getScore();
            int hscore = this.human.getScore();
            Toast.makeText(this, "Computer has " +computer.make_a_num() + " points in his hand vs the human's " + this.human.make_a_num(),Toast.LENGTH_SHORT).show();
            myRound.setNummoves(myRound.getNummmoves()+1);
            myRound.newRound(this.human, computer, myBoard);
            if(this.human.getScore() > hscore){
                Toast.makeText(this, "Human won the round, computer had " + (this.human.getScore() - hscore) + " points remaining and so those will be added to the human score", Toast.LENGTH_SHORT).show();
            }
            else if(computer.getScore() > cscore){
                Toast.makeText(this, "Computer won the round, human had " + (computer.getScore() - cscore) + " points remaining and so those will be added to the computer score", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "It was a tie, no score will be changed",Toast.LENGTH_SHORT).show();
            }
            if(myTournament.gameOver(this.human,computer)){
                if(this.human.getScore() > computer.getScore()){
                    Toast.makeText(this, "HUMAN PLAYER WINS CONGRADULATIONS!!!!!",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(this, "Computer player wins\nUnfortunetely that means you're bad at this game",Toast.LENGTH_LONG).show();
                }
                Intent intent = new Intent(BoardView.this, Tournament.class);
                Bundle bundle = new Bundle();
                bundle.putInt("key", 2);
                bundle.putInt("tournScore", myTournament.getScore());
                bundle.putInt("compScore", computer.getScore());
                bundle.putInt("humanScore", this.human.getScore());
                intent.putExtras(bundle);
                startActivity(intent);
            }
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Would you like to save before we begin the next round?");
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    saveAndExit();
                }
            });
            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    throw new RuntimeException();
                }
            });
            alert.show();
            try {
                Looper.loop();
            }
            catch (RuntimeException e2){
                myBoard.setCenter(myRound.getNummmoves());
                if(computer.hasTile(myBoard.getCenter())){
                    computer.removeTile(myBoard.getCenter());
                    next = 'H';
                    Toast.makeText(this, "Computer has placed center, Human to play",Toast.LENGTH_SHORT).show();
                }
                else if(this.human.hasTile(myBoard.getCenter())){
                    this.human.removeTile(myBoard.getCenter());
                    next = 'C';
                    Toast.makeText(this, "Human has placed center, Computer to play",Toast.LENGTH_SHORT).show();
                }
                View(myBoard.getTheBoard(),this.human.getPlayerHand(),computer.getPlayerHand(), myBoard.getBoneyard());
            }
        }
    }

    /**
     * creates the newGame and offers a save before the center gets placed then updates View
     */
    private void newGame(){
        myRound.setNummoves(1);
        myRound.newRound(human, computer, myBoard);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Would you like to save before we begin?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveAndExit();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                throw new RuntimeException();
            }
        });
        alert.show();
        try {
            Looper.loop();
        }
        catch (RuntimeException e2) {
            myBoard.setCenter(myRound.getNummmoves());
            if(computer.hasTile(myBoard.getCenter())){
                computer.removeTile(myBoard.getCenter());
                next = 'H';
                Toast.makeText(this, "Computer has placed center, Human to play",Toast.LENGTH_SHORT).show();
                View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
            }
            else if(human.hasTile(myBoard.getCenter())){
                human.removeTile(myBoard.getCenter());
                next = 'C';
                Toast.makeText(this, "Human has placed center, Computer to play",Toast.LENGTH_SHORT).show();
                View(myBoard.getTheBoard(), human.getPlayerHand(), computer.getPlayerHand(), myBoard.getBoneyard());
            }
        }
    }
}
