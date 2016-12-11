package de.htwg.sudoku.model

trait Cell {
  val value:Int
  def isShowingCandidates: Boolean
  def isGiven: Boolean
  def isSet: Boolean
  def isHighlighted: Boolean
}
