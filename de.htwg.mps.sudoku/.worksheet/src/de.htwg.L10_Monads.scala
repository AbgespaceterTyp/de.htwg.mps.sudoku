package de.htwg

object L10_Monads {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(30); 
  
  var list = List(1,2,3,4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(28); val res$0 = 

	for (i <- list) yield i*i;System.out.println("""res0: List[Int] = """ + $show(res$0));$skip(20); val res$1 = 
	
	list.map(i=>i*i);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(43); 
	
	var pairs = List (List(1,2), List(3,4));System.out.println("""pairs  : List[List[Int]] = """ + $show(pairs ));$skip(47); val res$2 = 
	
	pairs.map(pair => pair.map(int => int*int));System.out.println("""res2: List[List[Int]] = """ + $show(res$2));$skip(29); val res$3 = 
	pairs.flatMap(pair => pair);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(43); val res$4 = 
	
	pairs.flatMap(pair => pair.map(i=>i*i))
	
	
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
	};System.out.println("""res4: List[Int] = """ + $show(res$4));$skip(498); 
	
	val pack = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle));System.out.println("""pack  : de.htwg.L10_Monads.Pack = """ + $show(pack ));$skip(41); 
	val crate = new Crate(List(pack, pack));System.out.println("""crate  : de.htwg.L10_Monads.Crate = """ + $show(crate ));$skip(36); val res$5 = 
  pack.map(bottle => bottle.cleans);System.out.println("""res5: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$5));$skip(52); val res$6 = 
	
	for (bottle <- pack.bottles) yield bottle.cleans;System.out.println("""res6: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$6));$skip(65); val res$7 = 
  for (pack <- crate;
       bottle <- pack) yield bottle.cleans;System.out.println("""res7: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$7))}
	
}
