package com.seefurst.towersofhanoi.boardobjects

import java.util.Stack;
import java.util.EmptyStackException;


class Pole(numberOfDisks: Int) {
    private val disks = initDisks;
    private val lineSeparator = System.lineSeparator();
    
    def initDisks: Stack[Disk] = {
      // println("numberOfDisks: " + numberOfDisks);
      val newDisks = new Stack[Disk]();
      for (i <- numberOfDisks - 1 to 0 by -1 
              if (i >= 0)) { // the smallest disk should be the last in ... so
      // println("pushing disk " + i)
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
    else throw new IllegalArgumentException("disk of size: " + disk.size + " is not allowed on this pole: " + this)
                                           
  }
  def removeDisk(): Option[Disk] = {
    try {
      Some(disks.pop());
    } catch {
      case e: EmptyStackException => None // use Option????
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