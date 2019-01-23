package com.seefurst.towersofhanoi.boardobjects

class Board(numberOfDisksPerPole: Int) {
  private val poles = List(new Pole(numberOfDisksPerPole), new Pole(0), new Pole(0));
  
   def moveDisk(poleIdx: Int)  = {
     val poleWithDisk = poles(poleIdx)
     val disk = poleWithDisk.removeDisk()
     val destinationPole = getDestinationPole(poleIdx, disk);
     destinationPole.addDisk(disk);
   }
  
   def getDestinationPole(poleIdx: Int, disk: Disk): Pole = {
     val newIdx = 0;
     if (poles(poleIdx).canAccept(disk)) poles(poleIdx)
     else {
       if (poleIdx + 1 == poles.length) getDestinationPole(0,disk)
       else getDestinationPole(poleIdx+1,disk);
     }
   }
   
   override def toString: String = {
     return "";
   }
}