/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

import java.util.ArrayList;
import java.util.Stack;

public class Player {
    private int drew = 0;
    ArrayList<Tile> playerHand = new ArrayList<Tile>();
    int score = 0;
    int total = -1;
    boolean passedLastMove;

    /**
     * returns int drew
     * @return drew - int
     */
    public int getDrew(){
        return drew;
    }

    /**
     * sets drew to a value
     * @param num - int to use
     */
    public void setDrew(int num){
        drew = num;
    }

    /**
     * totals the number of pips in player hand
     * @return - int total of pips
     */
    public int make_a_num(){
        total = 0;
        for(int i = 0; i < playerHand.size(); i++){
            total += playerHand.get(i).getLeft();
            total += playerHand.get(i).getRight();
        }
        return total;
    }

    /**
     * returns if the player passed
     * @return - boolean
     */
    public boolean getPassed(){
        return passedLastMove;
    }

    /**
     * sets the player passed boolean
     * @param passed - boolean to set passedLastMove to
     */
    public void setPassed(boolean passed){
        passedLastMove=passed;
    }

    /**
     * checks if a player has tile
     * @param a_tile - Tile to check for
     * @return boolean - true if the player has the Tile, false otherwise
     */
    public boolean hasTile(Tile a_tile){
        for(int i = 0; i < playerHand.size(); i++){
            if(playerHand.get(i).getLeft() == a_tile.getLeft() && playerHand.get(i).getRight() == a_tile.getRight()){
                return true;
            }
        }
        return false;
    }

    /**
     * adds num to score
     * @param num - int to add on
     */
    public void add_to_score(int num){
        score+=num;
    }

    /**
     * returns score
     * @return - int score
     */
    public int getScore(){
        return score;
    }

    /**
     * fills the player hand
     * @param tiles - Stack of tiles to add in
     */
    public void fillHand(Stack<Tile> tiles){
        while(!tiles.empty()){
            Tile tile = tiles.get(tiles.size()-1);
            playerHand.add(0,tile);
            tiles.pop();
        }
    }

    /**
     * removes tile from player hand
     * @param a_tile - tile to remove
     */
    public void removeTile(Tile a_tile){
        for(int i = 0; i < playerHand.size(); i++){
            if(playerHand.get(i).getRight() == a_tile.getRight() && playerHand.get(i).getLeft() == a_tile.getLeft()){
                playerHand.remove(i);
                break;
            }
        }
    }

    /**
     * returns the player hand
     * @return ArrayList of Tiles
     */
    public ArrayList<Tile> getPlayerHand(){
        return playerHand;
    }
}
