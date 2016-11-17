package de.htwg.sudoku.model

trait IGrid {
  def set(row: Int, col: Int, value: Int): IGrid
  def blocknum: Int
  def size: Int
  def available(row: Int, col: Int): Set[Int]
  def cell(row: Int, col: Int): Cell
  def highlight(index: Int): IGrid
  def showCandidates(row: Int, col: Int): IGrid
  def createRandom(size: Int): IGrid
  def setGiven: IGrid
  def parseFromString(s: String): IGrid
  def reset: IGrid
  def solve: Tuple2[Boolean, IGrid]
  def solved: Boolean
  def valid: Boolean
}
