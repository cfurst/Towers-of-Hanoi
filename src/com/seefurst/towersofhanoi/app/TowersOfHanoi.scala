package com.seefurst.towersofhanoi.app

import com.seefurst.towersofhanoi.boardobjects._;

object TowersOfHanoi extends App {
  def main(args: String*)  = {
    val numberOfDisksInPlay = args(0).toInt;
    TowersOfHanoi.play(numberOfDisksInPlay, x => {
        new Board(x)
    });
    
  }
  
  def play(x: Int, board: (Int) => Board) = {
    val b = board(x);
    b.moveDisks(x-1, 0, 1, 2, b => b.toString());
    
  }
  
  
}