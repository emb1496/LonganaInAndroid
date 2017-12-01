/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

public class Tile {
    private int left;
    private int right;

    /**
     * sets the left side to num
     * @param num - int
     */
    public void setLeft(int num){
        left=num;
    }

    /**
     * sets the right side to num
     * @param num - int
     */
    public void setRight(int num){
        right=num;
    }

    /**
     * returns left
     * @return - int
     */
    public int getLeft(){
        return left;
    }

    /**
     * returns right
     * @return - int
     */
    public int getRight(){
        return right;
    }

    /**
     * checks if the Tile is a double
     * @return Boolean true - if it is a double false - otherwise
     */
    public boolean isDouble(){
        if(right==left){
            return true;
        }
        return false;
    }
}
