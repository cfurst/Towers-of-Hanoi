package com.seefurst.towersofhanoi.boardobjects

import java.util.Stack;
import java.util.EmptyStackException;


class Pole(numberOfDisks: Int) {
    private val disks = initDisks;
    private val lineSeparator = System.lineSeparator();
    
    def initDisks: Stack[Disk] = {
      val newDisks = new Stack[Disk]();
      for (i <- 0 to numberOfDisks - 1) {
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