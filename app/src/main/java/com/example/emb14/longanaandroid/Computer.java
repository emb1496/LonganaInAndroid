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

/**
 * Created by emb14 on 11/11/2017.
 */

public class Computer extends Player {

    /**
     * rearranges the tiles in the computer hand based upon the priority
     * Doubles before other tiles
     * And then it orders them based on the sum of the pips
     */
    public void best_tiles_to_play(){
        Tile tile = new Tile();
        int temp = 0;
        ArrayList<Integer> weights = new ArrayList<>();
        for(int i = 0; i < playerHand.size(); i++){
            if(playerHand.get(i).getRight() == playerHand.get(i).getLeft()){
                weights.add(playerHand.get(i).getLeft() + 100 + playerHand.get(i).getRight());
            }
            else{
                weights.add(playerHand.get(i).getLeft() + playerHand.get(i).getRight());
            }
        }
        for(int i = 0; i < playerHand.size(); i++){
            for(int j = 0; j < playerHand.size(); j++){
                if(weights.get(i) < weights.get(j)){
                    temp = weights.get(i);
                    weights.set(i, weights.get(j));
                    weights.set(j, temp);
                    tile = playerHand.get(i);
                    playerHand.set(i, playerHand.get(j));
                    playerHand.set(j, tile);
                }
            }
        }
    }


    /**
     * plays the Tile onto the board, using the computer preference to play right before playing
     * left
     * @param a_tile
     * @param myBoard
     * @param human
     * @return the computer move as a string
     */
    private String playTile(Tile a_tile, Board myBoard, Human human){
        if(myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight() == a_tile.getRight()){
            removeTile(a_tile);
            int temp = a_tile.getRight();
            a_tile.setRight(a_tile.getLeft());
            a_tile.setLeft(temp);
            myBoard.addToRight(a_tile);
            if(a_tile.isDouble()){
                return a_tile.getLeft() + " - " + a_tile.getRight() + " was the best double tile the computer could play.\nDouble tiles get weighted automatically heavier than other tiles. \nThen they get ordered by sum of the pips.\nComputer can play this tile on the right and therefore it will play it on the right";
            }
            else{
                return a_tile.getLeft() + " - " + a_tile.getRight() + " was the best tile the computer could play based on the sum of its pips.\nComputer prefers to play on the right and it will play this tile on the right";
            }
        }
        else if(myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight() == a_tile.getLeft()){
            myBoard.addToRight(a_tile);
            removeTile(a_tile);
            if(a_tile.isDouble()){
                return a_tile.getLeft() + " - " + a_tile.getRight() + " was the best double tile the computer could play.\nDouble tiles get weighted automatically heavier than other tiles. \nThen they get ordered by sum of the pips.\nComputer can play this tile on the right and therefore it will play it on the right";
            }
            else{
                return a_tile.getLeft() + " - " + a_tile.getRight() + " was the tile with the biggest sum which the computer could play. \nIt will play it on the right because the computer prefers to play on the right.";
            }
        }
        else if(human.getPassed() || a_tile.getRight()==a_tile.getLeft()){
            if(myBoard.getTheBoard().get(0).getLeft() == a_tile.getRight()){
                myBoard.addToLeft(a_tile);
                removeTile(a_tile);
                if(a_tile.isDouble()){
                    return a_tile.getLeft() + " - " + a_tile.getRight() + " was the best double tile the computer could play.\nDouble tiles get weighted automatically heavier than other tiles. \nThen they get ordered by sum of the pips.\nComputer cannot play this tile on the right as it prefers, and therefore will play on the left.";
                }
                else{
                    return a_tile.getLeft() + " - " + a_tile.getRight() + " was the tile with the biggest sum which the computer could play. \nHowever it could not play it on the right which the computer prefers, and therefore will play on the left.";
                }
            }
            else if(myBoard.getTheBoard().get(0).getLeft() == a_tile.getLeft()){
                removeTile(a_tile);
                int temp = a_tile.getRight();
                a_tile.setRight(a_tile.getLeft());
                a_tile.setLeft(temp);
                myBoard.addToLeft(a_tile);
                if(a_tile.isDouble()){
                    return a_tile.getLeft() + " - " + a_tile.getRight() + " was the best double tile the computer could play. \nDouble tiles get weighted automatically heavier than other tiles. \nThen they get ordered by sum of the pips.\nHowever it could not play this tile on the right and therefore will play on the left";
                }
                else{
                    return a_tile.getLeft() + " - " + a_tile.getRight() + " was the tile with the biggest sum which the computer could play. \nHowever it could not play it on the right which the computer prefers, and therefore will play on the left.";
                }
            }
        }
        return "";
    }

    /**
     * Checks if the tile can be played based upon whether the human passed and what kind of
     * a Tile it is
     * @param a_tile
     * @param human
     * @param myBoard
     * @return true if it can play false otherwise
     */
    private boolean compCanPlayTile(Tile a_tile, Human human, Board myBoard){
        if(human.getPassed())
        {
            if(myBoard.getTheBoard().get(0).getLeft() == a_tile.getRight() || myBoard.getTheBoard().get(0).getLeft() == a_tile.getLeft())
            {
                return true;
            }
        }
        if(a_tile.isDouble())
        {
            if(myBoard.getTheBoard().get(0).getLeft() == a_tile.getLeft())
            {
                return true;
            }
            else if(myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight() == a_tile.getRight())
            {
                return true;
            }
        }
        if(myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight() == a_tile.getLeft())
        {
            return true;
        }
        else if(myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight() == a_tile.getRight())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * returns what the computer did when he drew
     * @param myBoard - Board
     * @param next - character
     * @param human - Human
     * @return String describing the computer move
     */
    private String computerPasses(Board myBoard, char next, Human human){
        if(myBoard.getBoneyard().size() == 0){
            next = 'H';
            setPassed(true);
            return "Computer tried to draw a tile, but the boneyard is empty, Human move";
        }
        fillHand(myBoard.getTopN(1));
        best_tiles_to_play();
        for (int i = getPlayerHand().size()-1; i>= 0; i--) {
            if(compCanPlayTile(getPlayerHand().get(i), human, myBoard)){
                setPassed(false);
                return playTile(getPlayerHand().get(i), myBoard, human);
            }
            else if(i == 0){
                setPassed(true);
                next = 'H';
                return "Computer drew a tile and still has no legal moves, human to play";
            }
        }
        return "";
    }

    /**
     * returns the computer move
     * @param next
     * @param myBoard
     * @param human
     * @return String describing the computer move
     */
    public String computerPlayTile(char next, Board myBoard, Human human){
        String toRet = "";
        if(next != 'C'){
            return "It is not the Computer move";
        }
        best_tiles_to_play();
        for (int i = getPlayerHand().size()-1; i >= 0; i--) {
            if(compCanPlayTile(getPlayerHand().get(i), human, myBoard)){
                toRet = playTile(getPlayerHand().get(i), myBoard, human);
                setPassed(false);
                break;
            }
            else if(i == 0){
                toRet = computerPasses(myBoard, next, human);
                i--;
            }
        }
        next = 'H';
        return toRet;
    }
}
