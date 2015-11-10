package de.htwg

object L10_Monads {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(80); 
  println("Welcome to the Scala worksheet");$skip(32); 
  
  def isEven(x:Int) = x%2==0;System.out.println("""isEven: (x: Int)Boolean""");$skip(78); val res$0 = 
  
  
  for {
  	i <- 1 to 4
  	j <- 1 to i
  	if isEven(i+j)
  } yield (i,j);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(92); val res$1 = 
  
  (1 to 4) flatMap ( i =>
    (1 to i) filter (j => isEven(i+j))
      map (j => (i,j)));System.out.println("""res1: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$1));$skip(30); 
  
  var list = List(1,2,3,4);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(28); val res$2 = 

	for (i <- list) yield i*i;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(20); val res$3 = 
	
	list.map(i=>i*i);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(43); 
	
	var pairs = List (List(1,2), List(3,4));System.out.println("""pairs  : List[List[Int]] = """ + $show(pairs ));$skip(47); val res$4 = 
	
	pairs.map(pair => pair.map(int => int*int));System.out.println("""res4: List[List[Int]] = """ + $show(res$4));$skip(29); val res$5 = 
	pairs.flatMap(pair => pair);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(43); val res$6 = 
	
	pairs.flatMap(pair => pair.map(i=>i*i))
	
	
	class Bottle {
	  var empty=false
		def consume = {
			println(" consuming... ")
			empty = true
			this
		}
		override def toString= if (empty) "b" else "B"
	}
	
	class Pack(val bottles:List[Bottle]) {
		def map(f:Bottle => Bottle) = bottles.map(bottle => f(bottle))
		override def toString="UUUU"
	}
	
	class Crate(val packs:List[Pack]) {
		def map(f:Pack => Pack) = packs.map(pack => f(pack))
		def flatMap(f:Pack => List[Bottle]) = packs.flatMap(pack => f(pack))
		override def toString="L_____J"
	};System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(586); 
	
	val pack = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle));System.out.println("""pack  : de.htwg.L10_Monads.Pack = """ + $show(pack ));$skip(41); 
	val crate = new Crate(List(pack, pack));System.out.println("""crate  : de.htwg.L10_Monads.Crate = """ + $show(crate ));$skip(36); val res$7 = 
  pack.map(bottle => bottle.cleans);System.out.println("""res7: <error> = """ + $show(res$7));$skip(53); val res$8 = 
	

	for (bottle <- pack.bottles) yield bottle.cleans;System.out.println("""res8: List[Nothing] = """ + $show(res$8));$skip(65); val res$9 = 
  for (pack <- crate;
       bottle <- pack) yield bottle.cleans;System.out.println("""res9: <error> = """ + $show(res$9));$skip(51); val res$10 = 
            

  pack.map(bottle => bottle.consume);System.out.println("""res10: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$10));$skip(53); val res$11 = 
	
	for (bottle <- pack.bottles) yield bottle.consume;System.out.println("""res11: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$11));$skip(83); 
	
	
	
  val pack1 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle));System.out.println("""pack1  : de.htwg.L10_Monads.Pack = """ + $show(pack1 ));$skip(76); 
	val pack2 = new Pack(List(new Bottle, new Bottle, new Bottle, new Bottle));System.out.println("""pack2  : de.htwg.L10_Monads.Pack = """ + $show(pack2 ));$skip(44); 
	val crate1 = new Crate(List(pack1, pack2));System.out.println("""crate1  : de.htwg.L10_Monads.Crate = """ + $show(crate1 ));$skip(178); 
	
	def consumeAll(crate:Crate) = {
		var packs = crate.packs
		packs.foreach {pack =>
			var bottles = pack.bottles
			bottles.foreach { bottle =>
				bottle.consume
			}
		}
	};System.out.println("""consumeAll: (crate: de.htwg.L10_Monads.Crate)Unit""");$skip(22); 
	
	consumeAll(crate1);$skip(111); 
	def consumeAllWithFor(crate:Crate) = {
	  for (pack <- crate1;
       bottle <- pack) yield bottle.consume
	};System.out.println("""consumeAllWithFor: (crate: de.htwg.L10_Monads.Crate)List[de.htwg.L10_Monads.Bottle]""");$skip(27); val res$12 = 
 consumeAllWithFor(crate1);System.out.println("""res12: List[de.htwg.L10_Monads.Bottle] = """ + $show(res$12));$skip(79); 
       
  val pack3 = new Pack(List(new Bottle, null, new Bottle, new Bottle));System.out.println("""pack3  : de.htwg.L10_Monads.Pack = """ + $show(pack3 ));$skip(70); 
	val pack4 = new Pack(List(new Bottle, new Bottle, null, new Bottle));System.out.println("""pack4  : de.htwg.L10_Monads.Pack = """ + $show(pack4 ));$skip(46); 
	
	val crate2 = new Crate(List(pack3, pack4));System.out.println("""crate2  : de.htwg.L10_Monads.Crate = """ + $show(crate2 ));$skip(671); 
	//for (pack <- crate2;
  //     bottle <- pack) yield bottle.cleans
  
 
   
  
 def consumeAllAssumeNull(crate:Crate) = {
 		if (crate != null) {
 			var packs = crate2.packs
 			if (packs != null) {
 					packs.foreach { pack =>
 						if (pack != null) {
 							var bottles = pack.bottles
 							if (bottles != null) {
 								bottles.foreach { bottle =>
 									if (bottle != null) bottle.consume
 									else println ("Found a null for bottle")
 								}
 							} else println ("Found a null for bottles")
 						} else println ("Found a null for pack")
 					}
 			} else println ("Found a null for packs")
 		}	else println ("Found a null for crate")
 };System.out.println("""consumeAllAssumeNull: (crate: de.htwg.L10_Monads.Crate)Unit""");$skip(33); 
 	
 consumeAllAssumeNull(crate2)
/*
trait Option[Bottle] {
	def map(f:Bottle => Bottle):Option[Bottle]
	def cleans
}

case class Some[Bottle](val b:Bottle) extends Option[Bottle] {
	def map(f:Bottle => Bottle) = new Some(f(b))
}

case class None[Bottle] extends Option[Bottle] {
	def map(f:Bottle => Bottle) = new None
}
*/
class PackT[T](val bottles:List[T]) {
		def map(f:T => T) = bottles.map(bottle => f(bottle))
		override def toString="UUUU"
	}
	
	class CrateT[T](val packs:List[T]) {
		def map(f:T => T) = packs.map(pack => f(pack))
		def flatMap(f:T => List[Bottle]) = packs.flatMap(pack => f(pack))
		override def toString="L_____J"
	};$skip(664); 
	
val maybeBottle:Option[Bottle] = Some(new Bottle);System.out.println("""maybeBottle  : Option[de.htwg.L10_Monads.Bottle] = """ + $show(maybeBottle ));$skip(88); 
val pack5= new PackT( List(Some(new Bottle), None, Some(new Bottle), Some(new Bottle)));System.out.println("""pack5  : de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]] = """ + $show(pack5 ));$skip(88); 
val pack6= new PackT( List(Some(new Bottle), Some(new Bottle), None, Some(new Bottle)));System.out.println("""pack6  : de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]] = """ + $show(pack6 ));$skip(55); 
val crate3 = new CrateT(List(Some(pack5),Some(pack6)));System.out.println("""crate3  : de.htwg.L10_Monads.CrateT[Some[de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]]]] = """ + $show(crate3 ));$skip(200); 


def consumeAllAssumeNullWithFor(pack:PackT[Option[Bottle]]) = {
		for (
		   bottle <- pack.bottles) yield bottle match {
			case Some(b) => b.consume
			case None => println("Found None")
		}
		
};System.out.println("""consumeAllAssumeNullWithFor: (pack: de.htwg.L10_Monads.PackT[Option[de.htwg.L10_Monads.Bottle]])List[Any]""");$skip(35); val res$13 = 
consumeAllAssumeNullWithFor(pack5);System.out.println("""res13: List[Any] = """ + $show(res$13))}
	
}
