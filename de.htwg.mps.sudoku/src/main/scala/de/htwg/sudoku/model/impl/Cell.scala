package de.htwg.sudoku.model.impl

import de.htwg.sudoku.model.{ Cell => CellTrait }

case class Cell(val value: Int, val isHighlighted: Boolean, val isGiven: Boolean, val isShowingCandidates: Boolean) extends CellTrait {
  def this(value: Int) = this(value, false, false, false)

  def showCandidates = copy(isShowingCandidates = true)
  def hideCandidates = copy(isShowingCandidates = false)
  def given = if (isSet) copy(isGiven = true) else this
  def notGiven = copy(isGiven = false)
  def highlight = copy(isHighlighted = true)
  def unhighlight = copy(isHighlighted = false)

  def equals(that: Cell) = this.value == that.value
  def ==(v: Int) = if (value == v) true else false
  def isSet = value != 0
  override def toString = value.toString.replace('0', ' ')
}
