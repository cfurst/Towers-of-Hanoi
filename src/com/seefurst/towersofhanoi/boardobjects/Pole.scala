package com.seefurst.towersofhanoi.boardobjects

import java.util.Stack;
import java.util.EmptyStackException;


class Pole(numberOfDisks: Int) {
    private val disks = initDisks;
    private val lineSeparator = System.lineSeparator();
    
    def initDisks: Stack[Disk] = {
      println("numberOfDisks: " + numberOfDisks);
      val newDisks = new Stack[Disk]();
      for (i <- numberOfDisks - 1 to 0 by -1 
              if (i >= 0)) { // the smalledst disk should be the last in ... so
       println("pushing disk " + i)
        newDisks.push(new Disk(i));
      }
      newDisks;
    }
  private def canAccept(disk: Disk) : Boolean = {
      if (disks.size() == 0 ) true;
      else if (disks.peek.size > disk.size) true;
      else false;
    }
  def addDisk(disk: Disk) = {
    if (canAccept(disk))
          disks.push(disk);
  }
  def removeDisk(): Disk = {
    try {
      disks.pop();
    } catch {
      case e: EmptyStackException => null // use Option????
    }
  }
  
  def numberOfDisksOnPole: Int = {
    disks.size()
  }
  override def toString: String = {
     val diskArray = disks.toArray(Array[Disk]())
     val sb = new StringBuffer();
     sb.append(" disks: " + lineSeparator)
     for (d <- diskArray) sb.append(d.toString() + lineSeparator);
     sb.toString();
     
  }
  
  
}