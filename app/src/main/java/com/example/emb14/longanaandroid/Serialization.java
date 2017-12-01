/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.Vector;

/**
 * Created by emb14 on 11/18/2017.
 */

public class Serialization {
    String toRet = "";

    /**
     * saves game state and returns true, if it doesn't work returns false
     * @param filename - String
     * @param myTournament - Tournament
     * @param myRound - Round
     * @param computer - Computer
     * @param human - Human
     * @param myBoard - Board
     * @param next - Char
     * @return boolean true if it worked, false otherwise
     */
    public boolean saveAndExit(String filename, Tournament myTournament, Round myRound, Computer computer, Human human, Board myBoard, char next){
        try {
            File dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Longana");
            dir.mkdirs();
            File file = new File(dir, filename);
            //file.createNewFile();
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);
            pw.write("Tournament Score: " + myTournament.getScore() + '\n');
            pw.flush();
            pw.write("Round No.: " + myRound.getNummmoves() + '\n');
            pw.flush();
            pw.write('\n');
            pw.flush();
            pw.write("Computer:\n");
            pw.flush();
            pw.write("    Hand: ");
            pw.flush();
            for (int i = 0; i < computer.getPlayerHand().size(); i++) {
                pw.write(computer.getPlayerHand().get(i).getLeft() + "-" + computer.getPlayerHand().get(i).getRight() + " ");
                pw.flush();
            }
            pw.write('\n');
            pw.flush();
            pw.write("    Score: " + computer.getScore() + '\n');
            pw.flush();
            pw.write('\n');
            pw.flush();
            pw.write("Human: \n");
            pw.flush();
            pw.write("    Hand: ");
            pw.flush();
            for (int i = 0; i < human.getPlayerHand().size(); i++) {
                pw.write(human.getPlayerHand().get(i).getLeft() + "-" + human.getPlayerHand().get(i).getRight() + " ");
                pw.flush();
            }
            pw.write('\n');
            pw.flush();
            pw.write("    Score: " + human.getScore() + '\n');
            pw.flush();
            pw.write('\n');
            pw.flush();
            pw.write("Layout: \n");
            pw.flush();
            pw.write("    L ");
            pw.flush();
            for (int i = 0; i < myBoard.getTheBoard().size(); i++) {
                pw.write(myBoard.getTheBoard().get(i).getLeft() + "-" + myBoard.getTheBoard().get(i).getRight() + " ");
                pw.flush();
            }
            pw.write(" R");
            pw.flush();
            pw.write('\n');
            pw.flush();
            pw.write('\n');
            pw.flush();
            pw.write("Boneyard: \n");
            pw.flush();
            for (Tile i:myBoard.getBoneyard()) {
                pw.write(i.getLeft() + "-" + i.getRight() + " ");
                pw.flush();
            }
            pw.write('\n');
            pw.flush();
            pw.write('\n');
            pw.flush();
            if (next == 'C') {
                pw.write("Previous Player Passed: ");
                pw.flush();
                if (human.getPassed()) {
                    pw.write("Yes\n");
                    pw.flush();
                } else {
                    pw.write("No\n");
                    pw.flush();
                }
                pw.write('\n');
                pw.flush();
                pw.write("Next Player: Computer");
                pw.flush();
            } else if (next == 'H') {
                pw.write("Previous Player Passed: ");
                pw.flush();
                if (computer.getPassed()) {
                    pw.write("Yes\n");
                    pw.flush();
                } else {
                    pw.write("No\n");
                    pw.flush();
                }
                pw.write('\n');
                pw.flush();
                pw.write("Next Player: Human");
                pw.flush();
            } else {
                pw.write("Previous Player Passed: \n");
                pw.flush();
                pw.write('\n');
                pw.flush();
                pw.write("Next Player: ");
                pw.flush();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * loads the game and returns "DNE", "Done", or the list of what happened when the game was loaded if players need to draw
     * @param filename - String
     * @param myTournament - Tournament
     * @param computer - Computer
     * @param human - Human
     * @param myBoard - Board
     * @param myRound - Round
     * @param next - char
     * @return String value of what happened or "DNE" if it doesn't exist or "Done" if it went smoothly
     */
    public String loadGame(String filename, Tournament myTournament, Computer computer, Human human, Board myBoard, Round myRound, char next){
        try{
            File dir = new File(Environment.getExternalStorageDirectory(),"/Longana");
            File file = new File(dir, filename);
            if(!file.exists()){
                return "DNE";
            }
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            Stack<Tile> myStack = new Stack<>();
            boolean passed = false;
            for (int i = 0; i < 20; i++){
                line = br.readLine();
                switch (i){
                    case 0:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        myTournament.setScore(Integer.parseInt(line));
                        break;
                    case 1:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == '.' || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        myRound.setNummoves(Integer.parseInt(line));
                        break;
                    case 4:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        Stack<Tile> computerTiles = new Stack<>();
                        while(line.length() > 1 && line.charAt(1) != ' '){
                            Tile tile = new Tile();
                            tile.setLeft(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            tile.setRight(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            computerTiles.push(tile);
                        }
                        computer.fillHand(computerTiles);
                        break;
                    case 5:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        computer.add_to_score(Integer.parseInt(line));
                        break;
                    case 8:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        Stack<Tile> humanTiles = new Stack<>();
                        while(line.length() > 1 && line.charAt(1) != ' '){
                            Tile tile = new Tile();
                            tile.setLeft(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            tile.setRight(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            humanTiles.push(tile);
                        }
                        human.fillHand(humanTiles);
                        break;
                    case 9:
                        while(Character.isAlphabetic(line.charAt(0)) || line.charAt(0) == ' ' || line.charAt(0) == ':'){ // Not doing what you want it to!
                            line = line.substring(1);
                        }
                        human.add_to_score(Integer.parseInt(line));
                        break;
                    case 12:
                        while(line.charAt(0) != 'L'){
                            line = line.substring(1);
                        }
                        if(line.charAt(2) == 'R' || line.charAt(3) == 'R'){
                            i += 3;
                            line = br.readLine();
                            line = br.readLine();
                            line = br.readLine();
                            Vector<Tile> stock = new Vector<>();
                            while(line.length() > 1 && line.charAt(1) != ' '){
                                Tile tile = new Tile();
                                tile.setLeft(Integer.parseInt(Character.toString(line.charAt(0))));
                                line = line.substring(2);
                                tile.setRight(Integer.parseInt(Character.toString(line.charAt(0))));
                                line = line.substring(2);
                                stock.add(stock.size(), tile);
                            }
                            myBoard.setBoneyard(stock);
                            myBoard.setCenter(myRound.getNummmoves());
                            while(!human.hasTile(myBoard.getCenter()) && !computer.hasTile(myBoard.getCenter())){
                                myStack.push(myBoard.getTopN(1).pop());
                                human.fillHand(myStack);
                                toRet += "You have drawn " +human.getPlayerHand().get(0).getLeft() + " - " + human.getPlayerHand().get(0).getRight() + " from the stock.\n";
                                myStack.push(myBoard.getTopN(1).pop());
                                computer.fillHand(myStack);
                                toRet += "Computer has drawn " +computer.getPlayerHand().get(0).getLeft() + " - " + computer.getPlayerHand().get(0).getRight() + " from the stock.\n";
                            }
                            if(human.hasTile(myBoard.getCenter())){
                                human.removeTile(myBoard.getCenter());
                                next = 'C';
                                toRet += "Human placed the center tile, Computer to play next";
                                return toRet;
                            }
                            else{
                                computer.removeTile(myBoard.getCenter());
                                next = 'H';
                                toRet += "Computer placed the center tile, Human to play next";
                                return toRet;
                            }
                            // empty board need to handle this case!!!!
                        }
                        line = line.substring(2);
                        while(line.charAt(1) != 'R' ){
                            Tile tile = new Tile();
                            tile.setLeft(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            tile.setRight(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            myBoard.addToRight(tile);
                        }
                        break;
                    case 15:
                        Vector<Tile> stock = new Vector<>();
                        while(line.length() > 1 && line.charAt(1) != ' '){
                            Tile tile = new Tile();
                            tile.setLeft(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            tile.setRight(Integer.parseInt(Character.toString(line.charAt(0))));
                            line = line.substring(2);
                            stock.add(stock.size(), tile);
                        }
                        myBoard.setBoneyard(stock);
                        break;
                    case 17:
                        while(line.charAt(0) != 'N' && line.charAt(0) != 'Y'){
                            line = line.substring(1);
                        }
                        switch (line.charAt(0)){
                            case 'N':
                                passed = false;
                                break;
                            case 'Y':
                                passed = true;
                                break;
                        }
                        break;
                    case 19:
                        while(line.charAt(0) != 'H' && line.charAt(0) != 'C'){
                            line = line.substring(1);
                        }
                        switch (line.charAt(0)){
                            case 'H':
                                next = 'H';
                                computer.setPassed(passed);
                                break;
                            case 'C':
                                next = 'C';
                                human.setPassed(passed);
                                break;
                        }
                        break;
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "Done";
    }
}
