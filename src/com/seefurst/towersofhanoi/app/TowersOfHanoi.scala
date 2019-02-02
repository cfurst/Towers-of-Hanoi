package com.seefurst.towersofhanoi.app

import com.seefurst.towersofhanoi.boardobjects._;

object TowersOfHanoi {
  def main(args: Array[String]): Unit  = {
    val numberOfDisksInPlay = args(0).toInt;
    System.err.println("we are here...")
    TowersOfHanoi.play(numberOfDisksInPlay, x => {
        new Board(x)
    });
    
  }
  
  def play(x: Int, board: (Int) => Board) = {
    val b = board(x);
    b.moveDisks(x, 1, 2, 3, b => b.toString());
    
  }
  
  
}