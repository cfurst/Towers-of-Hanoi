package com.seefurst.towersofhanoi.app

import com.seefurst.towersofhanoi.boardobjects._;

object TowersOfHanoi {
  def main(args: Array[String]): Unit  = {
    val numberOfDisksInPlay = args(0).toInt;
    TowersOfHanoi.play(numberOfDisksInPlay, x => {
        new Board(x)
    });
    
  }
  
  def play(x: Int, board: (Int) => Board) = {
    val b = board(x);
    println("we have the board set up like this: " + b);
    b.moveDisks(x-1,0,1,2, b => println(b))
    
  }
  
  
}