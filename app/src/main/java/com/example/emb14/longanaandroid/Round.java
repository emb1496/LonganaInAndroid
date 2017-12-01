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
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

public class Round {
    private int nummoves = -1;

    /**
     * returns nummoves
     * @return - int
     */
    public int getNummmoves(){
        return nummoves;
    }

    /**
     * sets nummoves to num
     * @param num - int
     */
    public void setNummoves(int num){
        nummoves = num;
    }

    /**
     * checks if the round is over
     * @param p1 - Human
     * @param p2 - Computer
     * @param pile - ArrayList of Tiles
     * @return - boolean true if the round is over false otherwise
     */
    public boolean roundOver(Human p1, Computer p2, ArrayList<Tile> pile){
        if(p1.getPlayerHand().size()==0){
            return true;
        }
        if(p2.getPlayerHand().size()==0){
            return true;
        }
        if(pile.size()==0 && p1.getPassed() == true && p2.getPassed() == true){
            return true;
        }
        return false;
    }

    /**
     * starts a new round and sets up the board and all the options
     * @param human
     * @param computer
     * @param myBoard
     */
    public void newRound(Human human, Computer computer, Board myBoard){
        int humanScore = human.make_a_num();
        int computerScore = computer.make_a_num();
        Stack<Tile> myStack = new Stack<>();
        if(humanScore > computerScore){
            computer.add_to_score(humanScore);
        }
        else if(humanScore < computerScore){
            human.add_to_score(computerScore);
        }
        while(human.getPlayerHand().size() != 0){
            human.removeTile(human.getPlayerHand().get(0));
        }
        while(computer.getPlayerHand().size() != 0){
            computer.removeTile(computer.getPlayerHand().get(0));
        }
        while(myBoard.getTheBoard().size() != 0){
            myBoard.getTheBoard().remove(0);
        }
        while(myBoard.getBoneyard().size()!=0){
            myBoard.getBoneyard().remove(0);
        }
        myBoard.setCenter(nummoves);
        Vector<Tile> aVec = new Vector<Tile>();
        aVec = myBoard.generateTiles();
        Collections.shuffle(aVec);
        for(int i = 0; i < 8; i++){
            myStack.push(aVec.firstElement());
            aVec.remove(aVec.firstElement());
        }
        human.fillHand(myStack);
        for(int i = 0; i < 8; i++){
            myStack.push(aVec.firstElement());
            aVec.remove(aVec.firstElement());
        }
        computer.fillHand(myStack);
        myBoard.setBoneyard(aVec);
        while (!computer.hasTile(myBoard.getCenter()) && !human.hasTile(myBoard.getCenter())){
            myStack.push(myBoard.getTopN(1).peek());
            human.fillHand(myStack);
            myStack.push(myBoard.getTopN(1).peek());
            computer.fillHand(myStack);
        }
        myBoard.getTheBoard().remove(myBoard.getCenter());
    }
}
