package de.htwg.sudoku.model.impl

import scala.math.sqrt
import scala.util.Random
import de.htwg.sudoku.model.IGrid
import com.escalatesoft.subcut.inject._

case class Grid(val cells: Vector[Cell]) extends IGrid {
  def this(blocksize: Int) = this(Vector.fill(blocksize * blocksize)(new Cell(0)))

  val size = sqrt(cells.size).toInt
  val blocknum = sqrt(size).toInt
  def blockAt(row: Int, col: Int) = (col / blocknum) + (row / blocknum) * blocknum
  def indexToRowCol(index: Int) = { val r = index / size; val c = index % size; (r, c) }
  def cell(row: Int, col: Int) = rows(row).cells(col)
  def rows(row: Int) = new House(cells.slice(size * row, size * (row + 1)))
  def allrows = (0 until size).map(i => rows(i))
  def cols(col: Int) = new House((for { row <- 0 until size } yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def allcols = (0 until size).map(i => cols(i))
  def blocks(block: Int) = new House((for {
    row <- 0 until (size)
    col <- 0 until size; if blockAt(row, col) == block
  } yield cell(row, col)).asInstanceOf[Vector[Cell]])
  def allblocks = (0 until size).map(i => blocks(i))
  def set(row: Int, col: Int, value: Int): Grid = copy(cells.updated(size * row + col, new Cell(value)))
  def set(row: Int, col: Int, cell: Cell): Grid = copy(cells.updated(size * row + col, cell))
  def unset(row: Int, col: Int) = set(row, col, 0)
  def available(row: Int, col: Int): Set[Int] = if (cell(row, col).isSet) Set.empty else (1 to size).toSet -- rows(row).toIntSet -- cols(col).toIntSet -- blocks(blockAt(row, col)).toIntSet
  def options = for {
    row <- 0 until size
    col <- 0 until size
  } yield available(row, col)
  def valid = allrows.forall(house => house.valid) && allcols.forall(house => house.valid) && allblocks.forall(house => house.valid)
  def highlight(index: Int): IGrid = {
    var grid = this
    for {
      row <- 0 until size
      col <- 0 until size
    } if (available(row, col).contains(index)) grid = grid.set(row, col, cell(row, col).highlight) else grid = grid.set(row, col, cell(row, col).unhighlight)
    grid
  }
  def showCandidates(row: Int, col: Int): IGrid = set(row, col, cell(row, col).showCandidates)
  def setGiven = {
    var grid = this
    for {
      row <- 0 until size
      col <- 0 until size
    } if (cell(row, col).isSet) grid = grid.set(row, col, cell(row, col).given) else grid = grid.set(row, col, cell(row, col).notGiven)
    grid
  }
  override def toString = {
    val lineseparator = ("+-" + ("--" * blocknum)) * blocknum + "+\n"
    val line = ("| " + ("x " * blocknum)) * blocknum + "|\n"
    var box = "\n" + (lineseparator + (line * blocknum)) * blocknum + lineseparator
    for {
      row <- 0 until size
      col <- 0 until size
    } (box = box.replaceFirst("x", cell(row, col).toString))
    box
  }
  def reset = new Grid(size);
  def createRandom(num: Int): Grid = {
    var grid = new Grid(this.size)
    for {index <- 1 to num} { grid = grid.setRandomCell }
    grid
  }

  private def setRandomCell = {
    val row = Random.nextInt(size)
    val column = Random.nextInt(size)
    val availableValueSet = available(row, column).toIndexedSeq
    val numAvailableValues = availableValueSet.size
    if (numAvailableValues > 0) {
      val value = availableValueSet(Random.nextInt(numAvailableValues))
      set(row, column, value)
    } else this
  }

  def solved = cells.forall(cell => cell.isSet)
  def unsolvable = options.isEmpty
  def solve: Tuple2[Boolean, Grid] = solve(0)
  def solve(index: Int): Tuple2[Boolean, Grid] = {
    if (solved) return (true, this) else if (unsolvable) return (false, this) else {
      val (row, col) = indexToRowCol(index)
      if (cell(row, col).isSet) return solve(index + 1) else {
        val iter = Random.shuffle(available(row, col).toList).iterator
        var res: Tuple2[Boolean, Grid] = (false, this)
        if (iter.hasNext) {
          for { v <- iter } {
            var g = set(row, col, v)
            res = g.solve(index + 1)
            if (res._1 == true) return res
          }
        }
        return res
      }
    }
  }
  def parseFromString(string: String): Grid = {
    val listChar = string.toList.filter(char => ('0' to '9').contains(char))
    var listInt = listChar.map(c => c.toString.toInt)
    var g = new Grid(sqrt(listInt.size).toInt)
    for {
      r <- 0 until this.size
      c <- 0 until this.size
    } {
      val v = listInt.head
      g = g.set(r, c, v)
      listInt = listInt.drop(1)
    }
    g
  }
}

