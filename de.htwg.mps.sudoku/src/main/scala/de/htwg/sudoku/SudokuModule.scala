package de.htwg.sudoku

import com.escalatesoft.subcut.inject._
import de.htwg.sudoku.model.IGrid

object GridSize extends BindingId

object SudokuModule extends NewBindingModule (module => {
  import module._
  
 // bind[Int] idBy GridSize to 9  
  bind[IGrid] to newInstanceOf [de.htwg.sudoku.model.impl.Grid]
  
})