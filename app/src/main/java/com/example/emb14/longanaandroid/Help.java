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
 * Created by emb14 on 11/14/2017.
 */

public class Help extends Computer{
    private ArrayList<Tile> myList = new ArrayList<>();

    /**
     * rearranges tiles based upon the computer strategy
     * @param playerHand
     * @return ArrayList of Tiles in order
     */
    private ArrayList<Tile> setBestOrder(ArrayList<Tile> playerHand){
        int lcv = myList.size();
        for (int i = lcv-1; i >= 0; i--){
            myList.remove(i);
        }
        Tile tile = new Tile();
        int temp = 0;
        for(int i = 0; i < playerHand.size(); i++){
            myList.add(i,playerHand.get(i));
        }
        ArrayList<Integer> weights = new ArrayList<>();
        for(int i = 0; i < playerHand.size(); i++){
            if(playerHand.get(i).getRight() == playerHand.get(i).getLeft()){
                weights.add(playerHand.get(i).getLeft() + 100 + playerHand.get(i).getRight());
            }
            else{
                weights.add(playerHand.get(i).getLeft() + playerHand.get(i).getRight());
            }
        }
        for(int i = 0; i < myList.size(); i++){
            for(int j = 0; j < myList.size(); j++){
                if(weights.get(i) < weights.get(j)){
                    temp = weights.get(i);
                    weights.set(i, weights.get(j));
                    weights.set(j, temp);
                    tile = myList.get(i);
                    myList.set(i, myList.get(j));
                    myList.set(j, tile);
                }
            }
        }
        return myList;
    }

    /**
     * returns the computer recommendation as a string
     * @param next
     * @param human
     * @param computer
     * @param myBoard
     * @return string - recommendation
     */
    public String getHelp(char next, Human human, Computer computer, Board myBoard){
        if(next == 'C'){
            return "It is not your move, the Computer recommends you let the Computer play";
        }
        if(!human.hasLegalMove(computer.getPassed(), myBoard.getTheBoard().get(0).getLeft(), myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight())){
            return "The Computer recommends you pass because you have no legal moves";
        }
        Tile tile = new Tile();
        tile = needHelp(myBoard.getTheBoard().get(0).getLeft(), myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight(), human.getPlayerHand(), computer.getPassed());

        if(tile.getLeft() == myBoard.getTheBoard().get(0).getLeft() || tile.getRight() == myBoard.getTheBoard().get(0).getLeft()){
            return "The Computer recommends you playing " + tile.getLeft() + " - " + tile.getRight() + " to the left\nIt is the heaviest tile you can legally play based on the sum of pips and with doubles being weighted above other tiles.\nAs a human player your strategy should be to play on the left, so please play this tile on the left.";
        }
        else {
            return  "The Computer recommends you playing " + tile.getLeft() + " - " + tile.getRight() + " to the right\nIt is the heaviest tile you can legally play based on the sum of pips and with doubles being weighted above other tiles.\nThough we prefer to play on the left, this tile cannot be placed on the left\nTherefore the computer recommends you moving it on the right";
        }
    }

    /**
     * returns the Tile to play
     * @param left_end - int
     * @param right_end - int
     * @param playerHand - ArrayList of Tiles
     * @param computerPassed - boolean
     * @return Tile which can be played
     */
    private Tile needHelp(int left_end, int right_end, ArrayList<Tile> playerHand, boolean computerPassed){
        setBestOrder(playerHand);
        Tile myTile = new Tile();
        for(int i = myList.size()-1; i >= 0; i--){
            if(computerPassed){
                if(myList.get(i).getRight() == left_end || myList.get(i).getLeft() == left_end){
                    myTile = myList.get(i);
                    break;
                }
                else if(myList.get(i).getRight() == right_end || myList.get(i).getLeft() == right_end){
                    myTile = myList.get(i);
                    break;
                }
            }
            else{
                if(myList.get(i).getLeft() == myList.get(i).getRight()){
                    if(myList.get(i).getRight() == left_end){
                        myTile = myList.get(i);
                        break;
                    }
                    if(myList.get(i).getRight() == right_end){
                        myTile = myList.get(i);
                        break;
                    }
                }
                if(myList.get(i).getRight() == left_end || myList.get(i).getLeft() == left_end){
                    myTile = myList.get(i);
                    break;
                }
            }
        }
        return myTile;
    }
}
