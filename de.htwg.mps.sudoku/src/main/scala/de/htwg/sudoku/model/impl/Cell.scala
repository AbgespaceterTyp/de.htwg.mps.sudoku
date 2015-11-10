package de.htwg.sudoku.model.impl

import de.htwg.sudoku.model.{Cell=>CellTrait}

class Cell(val value: Int, val isHighlighted: Boolean, val isGiven: Boolean, val isShowingCandidates: Boolean) extends CellTrait {
  def this(value:Int) = this(value, false, false, false)
  
  def showCandidates = new Cell (value, isHighlighted, isGiven, isShowingCandidates=true)
  def hideCandidates = new Cell(value, isHighlighted, isGiven, isShowingCandidates=false)
  def given=if (isSet) new Cell(value, isHighlighted, isGiven=true, isShowingCandidates) else this
  def notGiven = new Cell(value, isHighlighted, isGiven=false, isShowingCandidates)
  def highlight = new Cell(value, isHighlighted=true, isGiven, isShowingCandidates)
  def unhighlight = new Cell(value, isHighlighted=false, isGiven, isShowingCandidates)
  
  def equals(that: Cell) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')
} 