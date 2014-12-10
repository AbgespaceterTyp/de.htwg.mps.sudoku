object L04_Classes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(24); val res$0 = 
1+2;System.out.println("""res0: Int(3) = """ + $show(res$0));$skip(4); val res$1 = 
2+4
  //Classes
  class Point1 {
    var x = 0
    var y = 0
  };System.out.println("""res1: Int(6) = """ + $show(res$1));$skip(84); 

  val p1 = new Point1;System.out.println("""p1  : L04_Classes.Point1 = """ + $show(p1 ));$skip(11); 
  p1.x = 3;$skip(11); 
  p1.y = 4;$skip(23); 

  println(p1.x, p1.y)
  
   // Parameter for Classes
  class Point2(ix: Int, iy: Int) {
    val x = ix
    val y = iy
  };$skip(129); 

  val p2 = new Point2(3, 4)
  
   // Parameter as public fields
  class Point3(val x: Int, val y: Int)
  
  // Default parameter
  class Point3D(val x:Int, val y:Int, z:Int=0);System.out.println("""p2  : L04_Classes.Point2 = """ + $show(p2 ));$skip(183); 
  
  val p3d1 = new Point3D(4,7,3);System.out.println("""p3d1  : L04_Classes.Point3D = """ + $show(p3d1 ));$skip(30); 
  val p3d2 = new Point3D(4,7)
  
  // Named parameter
  class PointN(val row:Int, val col:Int);System.out.println("""p3d2  : L04_Classes.Point3D = """ + $show(p3d2 ));$skip(107); 
  
  val pn1 = new PointN(row =5, col =8);System.out.println("""pn1  : L04_Classes.PointN = """ + $show(pn1 ));$skip(29); 
  println("row = " +pn1.row);$skip(41); 
  val pn2 = new PointN(col = 8, row = 5);System.out.println("""pn2  : L04_Classes.PointN = """ + $show(pn2 ));$skip(29); 
  println("row = " +pn2.row)
  
  // Methods for Classes
  class Point4(val x: Int, val y: Int) {
    def vectorAdd(newpt: Point4): Point4 = {
      new Point4(x + newpt.x, y + newpt.y)
    }
  };$skip(198); 

  val p31 = new Point4(3, 4);System.out.println("""p31  : L04_Classes.Point4 = """ + $show(p31 ));$skip(29); 
  val p32 = new Point4(7, 2);System.out.println("""p32  : L04_Classes.Point4 = """ + $show(p32 ));$skip(31); 
  val p33 = p31.vectorAdd(p32);System.out.println("""p33  : L04_Classes.Point4 = """ + $show(p33 ));$skip(24); 
  println(p33.x, p33.y)

  // Methods with more flexible names
  class Point5(val x: Int, val y: Int) {
    def +(newpt: Point5): Point5 = {
      new Point5(x + newpt.x, y + newpt.y)
    }
    def -(newpt: Point5): Point5 = {
      new Point5(x - newpt.x, y - newpt.y)
    }
    override def toString = "Point5(" + x + "," + y + ")"
  };$skip(343); 
  val p41 = new Point5(3, 4);System.out.println("""p41  : L04_Classes.Point5 = """ + $show(p41 ));$skip(29); 
  val p42 = new Point5(7, 2);System.out.println("""p42  : L04_Classes.Point5 = """ + $show(p42 ));$skip(30); 
  val p43 = new Point5(-2, 2);System.out.println("""p43  : L04_Classes.Point5 = """ + $show(p43 ));$skip(30); 
  val p44 = p41.+(p42).-(p43);System.out.println("""p44  : L04_Classes.Point5 = """ + $show(p44 ));$skip(15); 
  println(p44)

  // infix notation
  class Point6(val x: Int, val y: Int) {
    def +(newpt: Point6) = new Point6(x + newpt.x, y + newpt.y)
    def -(newpt: Point6) = new Point6(x - newpt.x, y - newpt.y)
    override def toString = "Point6(" + x + "," + y + ")"
  };$skip(281); 
  val p51 = new Point6(3, 4);System.out.println("""p51  : L04_Classes.Point6 = """ + $show(p51 ));$skip(29); 
  val p52 = new Point6(7, 2);System.out.println("""p52  : L04_Classes.Point6 = """ + $show(p52 ));$skip(30); 
  val p53 = new Point6(-2, 2);System.out.println("""p53  : L04_Classes.Point6 = """ + $show(p53 ));$skip(18); val res$2 = 
  p51 + p52 - p53

  // Case Class
  case class Point7(x: Int, y: Int) {
    def +(newpt: Point7) = Point7(x + newpt.x, y + newpt.y)
    def -(newpt: Point7) = Point7(x - newpt.x, y - newpt.y)
    override def toString = "Point7(" + x + "," + y + ")"
  };System.out.println("""res2: L04_Classes.Point6 = """ + $show(res$2));$skip(262); 
  val p61 = Point7(3, 4);System.out.println("""p61  : L04_Classes.Point7 = """ + $show(p61 ));$skip(25); 
  val p62 = Point7(7, 2);System.out.println("""p62  : L04_Classes.Point7 = """ + $show(p62 ));$skip(26); 
  val p63 = Point7(-2, 2);System.out.println("""p63  : L04_Classes.Point7 = """ + $show(p63 ));$skip(18); val res$3 = 
  p61 + p62 - p63
 
// TODO write a class for screen resolutions
// It should contain the width, the hight and a name of a resolution
// It should have a method to compute the number of pixels
// It should have a method to compare the size of two resolutions
 
 class Resolution (val width:Int, val height:Int, val name:String) {
 	 val  pixel = width * height
 	 val ratio = width.toDouble/height.toDouble
 	 def < (that:Resolution) = this.pixel < that.pixel
 	 def > (that:Resolution) = this.pixel > that.pixel
 };System.out.println("""res3: L04_Classes.Point7 = """ + $show(res$3));$skip(567); 
 
 val xga = new Resolution(width = 1024, height = 768, name= "XGA");System.out.println("""xga  : L04_Classes.Resolution = """ + $show(xga ));$skip(11); val res$4 = 
 xga.pixel;System.out.println("""res4: Int = """ + $show(res$4));$skip(11); val res$5 = 
 xga.ratio;System.out.println("""res5: Double = """ + $show(res$5));$skip(54); 
 
 val hd1080 = new Resolution (1920, 1080, "hd1080");System.out.println("""hd1080  : L04_Classes.Resolution = """ + $show(hd1080 ));$skip(14); val res$6 = 
 xga < hd1080;System.out.println("""res6: Boolean = """ + $show(res$6))}
}
