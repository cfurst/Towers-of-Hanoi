package com.seefurst.towersofhanoi.boardobjects

class Board(numberOfDisksPerPole: Int) {
  private val poles = List(new Pole(numberOfDisksPerPole), new Pole(0), new Pole(0));
  private val lineSeparator = System.lineSeparator();
  
  
   def moveDisks(disk: Int, beginningPole: Int, auxiliaryPole: Int, destinationPole: Int, displayAfterMove: (Board) => String): Unit  = {
     System.out.println("we are moving disk: " + disk +" from: "+ beginningPole +" to: " + destinationPole)
     if (disk == 1) {
       System.out.println("reached base case..") 
       moveDisk(beginningPole, destinationPole)
       displayAfterMove(this)
     }
     else {
       System.out.println("not top disk, moving disk above it.")
       moveDisks(disk-1, beginningPole, destinationPole, auxiliaryPole,displayAfterMove)
       displayAfterMove(this)
       moveDisks(0, beginningPole, auxiliaryPole, destinationPole,displayAfterMove)
       displayAfterMove(this)
       moveDisks(disk-1, auxiliaryPole,beginningPole,destinationPole,displayAfterMove)
       displayAfterMove(this)
       
     }
   }
  
   def moveDisk(source: Int, dest: Int) = {
     System.out.println("calling move disk")
     val sourcePole = poles(source -1) //index
     val sourceDisk = sourcePole.removeDisk()
     val destPole = poles(dest - 1) //index
     destPole.addDisk(sourceDisk)
     
   }
   
   def isFinished: Boolean = {
     poles(poles.length - 1).numberOfDisksOnPole == numberOfDisksPerPole
   }
   
   override def toString: String = {
     val sb = new StringBuffer();
     sb.append("=========================")
     sb.append("This board is using " + numberOfDisksPerPole +" disks on " + poles.length + " poles").
     append(lineSeparator).
     append(lineSeparator);
     var poleIdx = 1
     for (pole <- poles) {
       sb.append("Pole " + poleIdx + ": ")
       sb.append(pole.toString()).
       append(lineSeparator)
       poleIdx += 1 
     }
     sb.append("=========================").toString();
   }
}