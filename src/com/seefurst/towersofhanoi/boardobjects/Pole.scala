package com.seefurst.towersofhanoi.boardobjects

import java.util.Stack;

class Pole(numberOfDisks: Int) {
    private val disks = initDisks;
    
    def initDisks(): Stack[Disk] = {
      val newDisks = new Stack[Disk]();
      for (i <- 0 to numberOfDisks - 1) {
        newDisks.push(new Disk(i));
      }
      newDisks;
    }
  def canAccept(disk: Disk) : Boolean = {
      if (disks.peek.size > disk.size) true;
      else false;
    }
  def addDisk(disk: Disk) = {
    disks.push(disk);
  }
  def removeDisk(): Disk = {
    return disks.pop();
  }
}