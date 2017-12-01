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
import java.util.Vector;

/**
 * Created by emb14 on 11/11/2017.
 */

public class Board {
    // board list
    private ArrayList<Tile> theBoard = new ArrayList<Tile>();

    private Tile center = new Tile();
    private ArrayList<Tile> boneyard = new ArrayList<>();
    //private Stack<Tile> boneyard = new Stack<Tile>();
    private Stack<Tile> temp1 = new Stack<Tile>();

    /**
     * Returns the ArrayList of Tiles theBoard
     * @return ArrayList of Tile
     */
    public ArrayList<Tile> getTheBoard(){
        return theBoard;
    }


    /**
     * Returns the Tile center
     * @return center - Tile
     */
    public Tile getCenter(){
        return center;
    }

    /**
     * Returns ArrayList of Tiles boneyard
     * @return ArrayList - boneyard
     */
    public ArrayList<Tile> getBoneyard(){
        return boneyard;
    }

    /**
     * Parses myVec and adds it into Boneyard
     * @param myVec - Vector of Tiles to parse and insert each Tile into the Boneyard
     */
    public void setBoneyard(Vector<Tile> myVec){
        int lcv = myVec.size();
        for(int i = 0; i < lcv; i++){
            boneyard.add(myVec.firstElement());
            myVec.remove(0);
        }
    }

    /**
     * Puts the tile onto the left side of the board
     * @param a_tile
     */
    public void addToLeft(Tile a_tile){
        theBoard.add(0, a_tile);
    }

    /**
     * Puts the tile onto the right side of the board
     * @param a_tile
     */
    public void addToRight(Tile a_tile){
        theBoard.add(a_tile);
    }

    /**
     * returns the top "n" tiles as a stack
     * @param n - number of tiles
     * @return - Stack of Tiles
     */
    public Stack<Tile> getTopN(int n){
        while(!temp1.empty()){
            temp1.pop();
        }
        if(n>boneyard.size()){
            return temp1;
        }
        for(int i = 0; i < n; i++){
            temp1.push(boneyard.get(i));
            boneyard.remove(i);
        }
        return temp1;
    }

    /**
     * sets the center tile based on nummoves
     * @param nummoves
     */
    public void setCenter(int nummoves){
        nummoves = nummoves % 7;
        if(nummoves != 0){
            nummoves = 7 - nummoves;
        }
        center.setLeft(nummoves);
        center.setRight(nummoves);
        for(int i = 0; i < theBoard.size(); i++){
            if(theBoard.get(i).getLeft() == theBoard.get(i).getRight() && theBoard.get(i).getLeft() == center.getRight()){
                return;
            }
        }
        theBoard.add(center);
    }

    /**
     * generates all the tiles of the round
     * @return Vector of the tiles
     */
    public Vector<Tile> generateTiles(){
        Vector<Tile> myVec = new Vector<Tile>();
        for(int i=0; i<=6; i++){
            for(int j=i; j<=6;j++){
                Tile tile = new Tile();
                tile.setLeft(i);
                tile.setRight(j);
                myVec.add(tile);
            }
        }
        return myVec;
    }
}
