package de.htwg

import java.net.URL
import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

object L12_Future {

  def loadTime(host: String) = {
    val url = new URL("http://" + host)
    val start = System.currentTimeMillis()
    url.openConnection()
    url.getContent()
    val end = System.currentTimeMillis()
    end - start
  }                                               //> loadTime: (host: String)Long

  loadTime("www.htwg-konstanz.de")                //> res0: Long = 199
  loadTime("www.google.de")                       //> res1: Long = 109
  
  Future(loadTime("www.spiegel.de"))              //> res2: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@52ccff1e
  Future(loadTime("www.htwg-konstanz.de"))        //> res3: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@482ef8a9
  Future(loadTime("www.google.de"))               //> res4: scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$DefaultP
                                                  //| romise@163c2261
  val future1 = Future(loadTime("www.spiegel.de"))//> future1  : scala.concurrent.Future[Long] = scala.concurrent.impl.Promise$Def
                                                  //| aultPromise@44365201
  future1.onComplete{
  	case Success(time) => println(time)
  	case Failure(e) => println("failed")
  }
  
}