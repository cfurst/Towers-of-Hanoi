package com.seefurst.towersofhanoi.boardobjects

class Disk(initialSize: Int) {
    val size = initialSize;
   
    override def toString: String = {
      "Disk " + initialSize
    }
}