package de.htwg.sudoku.model

trait Cell {
  def isShowingCandidates:Boolean
  def isGiven:Boolean
  def isSet:Boolean
  def isHighlighted:Boolean
}