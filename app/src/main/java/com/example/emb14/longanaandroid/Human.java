/*
************************************************************
     * Name:  Elliott Barinberg                            *
     * Project:  3 Longana in Android                      *
     * Class:  CMPS 366                                    *
     * Date:  11/18/17                                     *
************************************************************
 */
package com.example.emb14.longanaandroid;

public class Human extends Player {
    private boolean legalmove = false;

    /**
     * Checks if human player has a legal move
     * @param comppassed - boolean
     * @param left_end - int
     * @param right_end - int
     * @return boolean whether human has a legal move
     */
    public boolean hasLegalMove(boolean comppassed, int left_end, int right_end){
        legalmove = false;
        if(comppassed){
            for(int i = 0; i<playerHand.size(); i++){
                if(playerHand.get(i).getLeft() == right_end || playerHand.get(i).getRight() == right_end){
                    legalmove = true;
                    break;
                }
                if(playerHand.get(i).getLeft() == left_end || playerHand.get(i).getRight() == left_end){
                    legalmove = true;
                    break;
                }
            }
        }
        else{
            for(int i = 0; i < playerHand.size(); i++){
                if(playerHand.get(i).getRight() == playerHand.get(i).getLeft()){
                    if(playerHand.get(i).getLeft() == right_end || playerHand.get(i).getLeft() == left_end){
                        legalmove = true;
                        break;
                    }
                }
                if(playerHand.get(i).getLeft() == left_end || playerHand.get(i).getRight() == left_end){
                    legalmove = true;
                    break;
                }
            }
        }
        return legalmove;
    }

    /**
     * returns a string - empty if the Human played otherwise its full
     * @param next - char next player
     * @param index - int tile to move
     * @param side - char which side to play on
     * @param myBoard - Board
     * @param computer - Computer
     * @return string - empty if Human played, otherwise it has message of what went wrong
     */
    public String humanPlayTile(char next, int index, char side, Board myBoard, Computer computer){
        int end;
        if(next != 'H'){
            return "It is the Computer move.";
        }
        switch (side){
            case 'L':
                end = myBoard.getTheBoard().get(0).getLeft();
                if(getPlayerHand().get(index).getRight() == end){
                    myBoard.addToLeft(getPlayerHand().get(index));
                    removeTile(getPlayerHand().get(index));
                    setDrew(0);
                    setPassed(false);
                }
                else if(getPlayerHand().get(index).getLeft() == end){
                    Tile tile = new Tile();
                    tile = getPlayerHand().get(index);
                    removeTile(tile);
                    int temp=-1;
                    temp = tile.getRight();
                    tile.setRight(tile.getLeft());
                    tile.setLeft(temp);
                    myBoard.addToLeft(tile);
                    setDrew(0);
                    setPassed(false);
                }
                break;
            case 'R':
                if(getPlayerHand().get(index).getLeft() == getPlayerHand().get(index).getRight()){

                }
                else if(!computer.getPassed()){
                    break;
                }
                end = myBoard.getTheBoard().get(myBoard.getTheBoard().size()-1).getRight();
                if(getPlayerHand().get(index).getLeft() == end){
                    myBoard.addToRight(getPlayerHand().get(index));
                    removeTile(getPlayerHand().get(index));
                    setDrew(0);
                    setPassed(false);
                }
                else if(getPlayerHand().get(index).getRight() == end){
                    Tile tile = new Tile();
                    tile = getPlayerHand().get(index);
                    removeTile(tile);
                    int temp=-1;
                    temp = tile.getRight();
                    tile.setRight(tile.getLeft());
                    tile.setLeft(temp);
                    myBoard.addToRight(tile);
                    setDrew(0);
                    setPassed(false);
                }
                break;
        }
        return "";
    }

    /**
     * returns a string of what happened when the human passed for an intent
     * @param next - char next player
     * @param myBoard - board
     * @return string of what happened
     */
    public String humanPass(char next, Board myBoard){
        if(next == 'C'){
            return "You cannot pass because it is not your turn";
        }
        if(myBoard.getBoneyard().size() == 0){
            setPassed(true);
            setDrew(0);
            return "Stock is empty cannot draw";
        }
        setDrew(getDrew()+1);
        if(getDrew() == 2){
            setDrew(0);
            setPassed(true);
            return "You have passed twice, it is not longer your turn.";
        }
        fillHand(myBoard.getTopN(1));
        return "You have drawn a tile, if you pass again Computer will play";
    }
}
