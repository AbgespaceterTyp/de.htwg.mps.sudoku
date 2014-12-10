object L01_Expressions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); val res$0 = 
  // Simple Expressions
  1 + 2 + 3;System.out.println("""res0: Int = """ + $show(res$0));$skip(18); val res$1 = 
  3 + 4 * (2 - 3);System.out.println("""res1: Int = """ + $show(res$1));$skip(9); val res$2 = 
  23 % 5;System.out.println("""res2: Int(3) = """ + $show(res$2));$skip(20); val res$3 = 
  3.5 * 9.4 + 6 / 4;System.out.println("""res3: Double = """ + $show(res$3));$skip(54); val res$4 = 
  
  // Simple String operations
  "Hello " + "World";System.out.println("""res4: String("Hello World") = """ + $show(res$4));$skip(30); 
  println("Hello " + "World");$skip(35); 

  // Variables
  val width = 1024;System.out.println("""width  : Int = """ + $show(width ));$skip(30); 
  var height = width * 9 / 16;System.out.println("""height  : Int = """ + $show(height ));$skip(18); 
  println(height);$skip(81); 

  //width = 1440  //reassignment on val is not allowed
  height = width * 3 / 4;$skip(9); val res$5 = 
  height;System.out.println("""res5: Int = """ + $show(res$5));$skip(15); 

  var inc = 5;System.out.println("""inc  : Int = """ + $show(inc ));$skip(11); 
  inc += 5;$skip(23); 
  
  val name ="Marko";System.out.println("""name  : String = """ + $show(name ));$skip(32); 
  val message = "Hello " + name;System.out.println("""message  : String = """ + $show(message ));$skip(19); 
  println(message);$skip(136); 
  
  // TODO Calculate the width of a HD 1080 resolution
  // It has a hight of 1080 and a ratio of 16:9
  val width_HD1080 = 1080*16/9;System.out.println("""width_HD1080  : Int = """ + $show(width_HD1080 ));$skip(44); val res$6 = 

  // Bit operations
  3 & 2;System.out.println("""res6: Int(2) = """ + $show(res$6));$skip(22); val res$7 =  // logical and
  1 | 2;System.out.println("""res7: Int(3) = """ + $show(res$7));$skip(23); val res$8 =  // logical or
  1 ^ 2;System.out.println("""res8: Int(3) = """ + $show(res$8));$skip(23); val res$9 =  // logical xor
  1 << 2;System.out.println("""res9: Int(4) = """ + $show(res$9));$skip(32); val res$10 =  // shift left

  // Boolean operations
  true;System.out.println("""res10: Boolean(true) = """ + $show(res$10));$skip(8); val res$11 = 
  false;System.out.println("""res11: Boolean(false) = """ + $show(res$11));$skip(24); val res$12 = 
  1 > 2;System.out.println("""res12: Boolean(false) = """ + $show(res$12));$skip(21); val res$13 =  // greater than
  1 < 2;System.out.println("""res13: Boolean(true) = """ + $show(res$13));$skip(19); val res$14 =  // less than
  1 == 2;System.out.println("""res14: Boolean(false) = """ + $show(res$14));$skip(34); val res$15 =  // equals
  1 >= 2;System.out.println("""res15: Boolean(false) = """ + $show(res$15));$skip(31); val res$16 =  // greater than or equal
  1 != 2;System.out.println("""res16: Boolean(true) = """ + $show(res$16));$skip(22); val res$17 =  // less than or equal
  true || false;System.out.println("""res17: Boolean(true) = """ + $show(res$17));$skip(23); val res$18 =  // or
  true && false;System.out.println("""res18: Boolean(false) = """ + $show(res$18));$skip(58); val res$19 =  // and

  // If-Expression
  if (1 > 2) 4 else 5;System.out.println("""res19: Int = """ + $show(res$19));$skip(35); val res$20 =  // greater than
  if (1 < 2) 6 else 7;System.out.println("""res20: Int = """ + $show(res$20));$skip(44); val res$21 =  // less than
  if (width == 1024 && height == 576) "PAL";System.out.println("""res21: Any = """ + $show(res$21));$skip(38); val res$22 = 
  if (width / height == 16 / 9) "PAL";System.out.println("""res22: Any = """ + $show(res$22));$skip(55); 
  val resolution = if (width / height == 16 / 9) "PAL";System.out.println("""resolution  : Any = """ + $show(resolution ));$skip(53); val res$23 = 
  if (width / height == 16 / 9) "PAL" else "Unknown";System.out.println("""res23: String = """ + $show(res$23));$skip(180); 
  
  // TODO Develop an if-expression that can distinguish
  // between SXGA(1280x1024), HD 720(16:9) and a HD 1080(16:9) resolution based on width, height and ratio
val h = 1080;System.out.println("""h  : Int = """ + $show(h ));$skip(18); 
val w = 1080*16/9;System.out.println("""w  : Int = """ + $show(w ));$skip(148); val res$24 = 
if (w == 1280 && h == 1024) "SXGA" else
	if (h == 1080 && w == 1080*16/9) "HD 1080" else
		if (h ==720 && w == 720*16/9) "HD 720" else
			"unknown";System.out.println("""res24: String = """ + $show(res$24));$skip(29); 
  // Loops
  var total1 = 18;System.out.println("""total1  : Int = """ + $show(total1 ));$skip(34); 
  while (total1 < 17) total1 += 3;$skip(9); val res$25 = 
  total1;System.out.println("""res25: Int = """ + $show(res$25));$skip(19); 

  var total2 = 18;System.out.println("""total2  : Int = """ + $show(total2 ));$skip(47); 
  do {
    total2 += 3
  } while (total2 < 17);$skip(9); val res$26 = 
  total2;System.out.println("""res26: Int = """ + $show(res$26));$skip(52); 

  // find the greatest common divisor
  var x = 36;System.out.println("""x  : Int = """ + $show(x ));$skip(13); 
  var y = 99;System.out.println("""y  : Int = """ + $show(y ));$skip(67); 
  while (x != 0) {
    val temp = x
    x = y % x
    y = temp
  };$skip(24); 
  println("gcd is" + y);$skip(61); 
 
  // For-Expression
  for (i <- 1 to 4) println("hi five");$skip(34); 
  for (i <- 1 until 4) println(i);$skip(50); 
  for (i <- 1 until 4; j <- 1 to 3) println(i, j);$skip(32); 
  for (c <- "hello") println(c);$skip(239); 
// TODO Write a for-loop that produces the following output
// 12345678
// 22345678
// 33345678
// 44445678
// 55555678
// 66666678
// 77777778
// 88888888

for (i <-1 to 8; j <- 1 to 8) {
	print( if (i>j) i else j)
  if (j== 8) println
}}
}
