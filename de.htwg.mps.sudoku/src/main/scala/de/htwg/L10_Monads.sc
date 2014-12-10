package de.htwg

object L10_Monads {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def isEven(x:Int) = x%2==0                      //> isEven: (x: Int)Boolean
  
  for {
  	i <- 1 to 4
  	j <- 1 to i
  	if isEven(i+j)
  } yield (i,j)                                   //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,2
                                                  //| ), (3,1), (3,3), (4,2), (4,4))
  
  (1 to 4) flatMap ( i =>
    (1 to i) filter (j => isEven(i+j))
      map (j => (i,j)))                           //> res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,1), (2,2
                                                  //| ), (3,1), (3,3), (4,2), (4,4))
  
  var list = List(1,2,3,4)                        //> list  : List[Int] = List(1, 2, 3, 4)

	for (i <- list) yield i*i                 //> res2: List[Int] = List(1, 4, 9, 16)
	
	list.map(i=>i*i)                          //> res3: List[Int] = List(1, 4, 9, 16)
	
	var pairs = List (List(1,2), List(3,4))   //> pairs  : List[List[Int]] = List(List(1, 2), List(3, 4))
	
	pairs.map(pair => pair.map(int => int*int))
                                                  //> res4: List[List[Int]] = List(List(1, 4), List(9, 16))
	pairs.flatMap(pair => pair)               //> res5: List[Int] = List(1, 2, 3, 4)
	
	pairs.flatMap(pair => pair.map(i=>i*i))   //> res6: List[Int] = List(1, 4, 9, 16)
	
	
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
                                                  //> pack  : de.htwg.L10_Monads.Pack = de.htwg.L10_Monads$$anonfun$main$1$Pack$1
                                                  //| @45db05b2
	val crate = new Crate(List(pack, pack))   //> crate  : de.htwg.L10_Monads.Crate = de.htwg.L10_Monads$$anonfun$main$1$Crat
                                                  //| e$1@4e76fba0
  pack.map(bottle => bottle.cleans)               //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res7: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B)
	
	for (bottle <- pack.bottles) yield bottle.cleans
                                                  //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res8: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B)
  for (pack <- crate;
       bottle <- pack) yield bottle.cleans        //>  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //|  cleaning... 
                                                  //| res9: List[de.htwg.L10_Monads.Bottle] = List(B, B, B, B, B, B, B, B)
	
}