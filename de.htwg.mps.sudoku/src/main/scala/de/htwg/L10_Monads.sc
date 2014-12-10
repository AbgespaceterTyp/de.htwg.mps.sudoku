package de.htwg

object L10_Monads {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var list = List(1,2,3,4)                        //> list  : List[Int] = List(1, 2, 3, 4)

	for (i <- list) yield i*i                 //> res0: List[Int] = List(1, 4, 9, 16)
	
	list.map(i=>i*i)                          //> res1: List[Int] = List(1, 4, 9, 16)
	
	var pairs = List (List(1,2), List(3,4))   //> pairs  : List[List[Int]] = List(List(1, 2), List(3, 4))
	
	pairs.map(pair => pair.map(int => int*int))
                                                  //> res2: List[List[Int]] = List(List(1, 4), List(9, 16))
	pairs.flatMap(pair => pair)               //> res3: List[Int] = List(1, 2, 3, 4)
	
	pairs.flatMap(pair => pair.map(i=>i*i))   //> res4: List[Int] = List(1, 4, 9, 16)
	
	
	class Bottle {
	  var clean=false
		def cleans = {
			println(" cleaning... ")
			clean = true
			this
		}
		override def toString="B"
	}
	
	class Pack(val bottles:List[Bottle]) {
		def map(f:Bottle => Bottle) = bottles.map(bottle => f(bottle))
	}
	
	class Crate(val packs:List[Pack]) {
		def map(f:Pack => Pack) = packs.map(pack => f(pack))
		def flatMap(f:Pack => List[Bottle]) = packs.flatMap(pack => f(pack))
	}
	
	val pack = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle))
                                                  //> pack  : de.htwg.L10_Monads.Pack = de.htwg.L10_Monads$$anonfun$main$1$Pack$1@
                                                  //| 58f39b3a
	val crate = new Crate(List(pack, pack))   //> crate  : de.htwg.L10_Monads.Crate = de.htwg.L10_Monads$$anonfun$main$1$Crate
                                                  //| $1@5caf993e
  pack.map(bottle => bottle.cleans)               //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res5: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B)
	
	for (bottle <- pack.bottles) yield bottle.cleans
                                                  //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res6: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B)
  for (pack <- crate;
       bottle <- pack) yield bottle.cleans        //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res7: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B, B, B, B, B)
	
}