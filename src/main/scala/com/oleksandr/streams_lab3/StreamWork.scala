package com.oleksandr.streams_lab3

object StreamWork {
  val T = 7
  val N = 6
  val Sr: Array[KeyPoint] = new Array[KeyPoint](N)
  var maxTer: Int = 0

  def fillThread(): Seq[Stream] = {
    Seq(Stream(4, 0, 3)
    ,Stream(4, 1, 5)
    ,Stream(0, 3, 7)
    ,Stream(1, 2, 4)
    ,Stream(2, 5, 7)
    ,Stream(4, 3, 8)
    ,Stream(3, 5, 9)
    )
  }

  def main(args: Array[String]): Unit = {

    val thread = fillThread()


    for (i <- 0 until N) {
      Sr(i) = KeyPoint(i, 0, 0)
    }

    for (i <- 0 until N)
      for (j <- 0 until T) {
        if (Sr(i).name == thread(j).a)
          Sr(i).output += thread(j).c
        if (Sr(i).name == thread(j).b)
          Sr(i).input += thread(j).c
      }
    Sr(N - 2).input = Sr(N - 2).output
    Sr(N - 1).output = Sr(N - 1).input
    for (i <- 0 until N)
      Sr(i).capacity = Math.max(Sr(i).input, Sr(i).output)
    maxTer = Math.max(Sr(N - 1).capacity, Sr(N - 2).capacity)

    for (j <- 0 until N)
      if (thread(j).b == N - 1)
        Sr(N - 1).capacity -= Math.min(thread(j).c, Sr(thread(j).a).capacity)

    for (i <- N - 3 until(0, -1))
      for (j <- 0 until T)
        if (thread(j).b == i)
          Sr(i).capacity -= Math.min(thread(j).c, Sr(thread(j).a).capacity)

    System.out.println("Thread: " + maxTer)

  }

  case class Stream(a: Int, b: Int, c: Int)

  case class KeyPoint(name: Int, var input: Int, var output: Int) {
    var capacity: Int = 0
  }

  case class Transformer() {
      def numToUpperLetter(num: Int) : String = {
        (num + 65).toString
      }
      def upperLetterToNum(s: Char): Int = s.toInt - 65
  }

}
