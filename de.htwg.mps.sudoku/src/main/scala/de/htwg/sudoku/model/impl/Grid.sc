 package de.htwg.sudoku.model.impl

import scala.math.sqrt
import scala.io.Source._

object GridWS {



  var grid = new Grid(4)                          //> grid  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 
  
        
  grid.size                                       //> res0: Int = 4
  grid.blocknum                                   //> res1: Int = 2
  grid.rows(0)                                    //> res2: de.htwg.sudoku.model.impl.House =     
  grid.rows(2)                                    //> res3: de.htwg.sudoku.model.impl.House =     

  grid = grid.set(0, 0, 1)
  grid.toString                                   //> res4: String = "
                                                  //| +-----+-----+
                                                  //| | 1   |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| "
  grid.rows(0)                                    //> res5: de.htwg.sudoku.model.impl.House = 1   

  grid.cols(0)                                    //> res6: de.htwg.sudoku.model.impl.House = 1   

  grid = grid.set(0, 3, 2)
  grid.toString                                   //> res7: String = "
                                                  //| +-----+-----+
                                                  //| | 1   |   2 |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| "

  grid.rows(0)                                    //> res8: de.htwg.sudoku.model.impl.House = 1  2
  grid.cols(3)                                    //> res9: de.htwg.sudoku.model.impl.House = 2   
  grid.blocks(0)                                  //> res10: de.htwg.sudoku.model.impl.House = 1   
  grid.blocks(1)                                  //> res11: de.htwg.sudoku.model.impl.House =  2  

  grid.available(0, 1)                            //> res12: Set[Int] = Set(3, 4)
  grid.available(1, 1)                            //> res13: Set[Int] = Set(2, 3, 4)
  grid.available(2, 2)                            //> res14: Set[Int] = Set(1, 2, 3, 4)
  grid.options                                    //> res15: scala.collection.immutable.IndexedSeq[Set[Int]] = Vector(Set(), Set(3
                                                  //| , 4), Set(3, 4), Set(), Set(2, 3, 4), Set(2, 3, 4), Set(1, 3, 4), Set(1, 3, 
                                                  //| 4), Set(2, 3, 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1, 3, 4), Set(2, 3, 
                                                  //| 4), Set(1, 2, 3, 4), Set(1, 2, 3, 4), Set(1, 3, 4))
 
  grid.indexToRowCol(0)                           //> res16: (Int, Int) = (0,0)
  grid.indexToRowCol(1)                           //> res17: (Int, Int) = (0,1)
  grid.indexToRowCol(2)                           //> res18: (Int, Int) = (0,2)
  grid.indexToRowCol(3)                           //> res19: (Int, Int) = (0,3)
  grid.indexToRowCol(4)                           //> res20: (Int, Int) = (1,0)

  var grid1 = new Grid(1)                         //> grid1  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +---+
                                                  //| |   |
                                                  //| +---+
                                                  //| 
  grid1 = grid1.solve(0)._2
  
  var unsolved = new Grid(4)                      //> unsolved  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |     |
                                                  //| +-----+-----+
                                                  //| 
  unsolved = unsolved.set(0,0,4).set(0,1,3).set(0,2,2).set(0,3,1).set(1,0,2).set(1,1,1).set(1,3,4).set(3,3,3)
  unsolved                                        //> res21: de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 |   4 |
                                                  //| +-----+-----+
                                                  //| |     |     |
                                                  //| |     |   3 |
                                                  //| +-----+-----+
                                                  //| 
 unsolved.options                                 //> res22: scala.collection.immutable.IndexedSeq[Set[Int]] = Vector(Set(), Set()
                                                  //| , Set(), Set(), Set(), Set(), Set(3), Set(), Set(1, 3), Set(2, 4), Set(1, 4)
                                                  //| , Set(2), Set(1), Set(2, 4), Set(1, 4), Set())
 unsolved.solved                                  //> res23: Boolean = false
 unsolved.unsolvable                              //> res24: Boolean = false
 val solved = unsolved.solve._2                   //> solved  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-----+-----+
                                                  //| | 4 3 | 2 1 |
                                                  //| | 2 1 | 3 4 |
                                                  //| +-----+-----+
                                                  //| | 3 4 | 1 2 |
                                                  //| | 1 2 | 4 3 |
                                                  //| +-----+-----+
                                                  //| 
 solved.solved                                    //> res25: Boolean = true
 solved.unsolvable                                //> res26: Boolean = false
 

  var grid4 = new Grid(9)                         //> grid4  : de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| 
  grid4 = grid4.createRandom(9)
  
  grid4                                           //> res27: de.htwg.sudoku.model.impl.Grid = 
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| |       |       |       |
                                                  //| |       |       | 1     |
                                                  //| +-------+-------+-------+
                                                  //| |       |       |       |
                                                  //| | 7 4 2 |       |     8 |
                                                  //| |       |     4 |       |
                                                  //| +-------+-------+-------+
                                                  //| |       |     5 |       |
                                                  //| | 5     |       |   9   |
                                                  //| |       |       |       |
                                                  //| +-------+-------+-------+
                                                  //| 
             
                
  
  

}