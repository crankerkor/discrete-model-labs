import com.oleksandr.isomorphism_lab5.Isomorphism
import com.oleksandr.postman_lab2.PostMan
import com.oleksandr.prim_lab1.Prim
import com.oleksandr.salesman_lab4.Salesman
import com.oleksandr.{Edge, Graph}

import scala.io.Source

import scala.collection.mutable.ListBuffer

object Main {
  private val fullPath = "C:\\Users\\oleksandr_lutsenko\\Desktop\\graphs\\src\\main\\scala\\"
  def main(args: Array[String]): Unit = {
    val graph = new Graph(fillPostManGraph())
    /*new Prim(graph).findPrim()*/
    /*new PostMan(graph).postManPath()*/
    /*new Salesman(new com.oleksandr.Graph(fillSalesmanGraph())).gamiltonCycle()*/

    val isomorph = new Graph(fillIsomorphicGraph())
    val isomorphic = new Graph(fill2IsomorphicGraph())
    println(isomorph.edges)
    println(isomorphic.edges)
    val isomorphismChecker = new Isomorphism(isomorph)

    isomorphismChecker.changeVerticeNames(isomorphic)
    isomorphismChecker.antiFlex(isomorphic, isomorphic.getVertices.size - 1)
    println("Are isomorphic? " + isomorphismChecker.general)
  }

  def fillGraph(): ListBuffer[Edge] = {
    readFromFile("graphPrim.txt")
  }

  def readFromFile(filePath: String): ListBuffer[Edge] = {
    val edges = new ListBuffer[Edge]

    val bufferedSource = Source.fromFile(fullPath + filePath)
    for (line <- bufferedSource.getLines) {
      val edgeParams = line.split(" ")
      if (edgeParams.length > 2)
        edges += Edge(edgeParams(0), edgeParams(1), edgeParams(2).toInt)
      else edges += Edge(edgeParams(0), edgeParams(1))
    }

    bufferedSource.close

    edges
    }

  def fillIsomorphicGraph(): ListBuffer[Edge] = {
    readFromFile("isomorphic.txt")
  }

  def fill2IsomorphicGraph(): ListBuffer[Edge] = {
    readFromFile("isomorphism1.txt")
  }

  def fillSalesmanGraph(): ListBuffer[Edge] = {
      readFromFile("salesman.txt")
  }


  def fillDziuGraph(): ListBuffer[Edge] = {
    new ListBuffer[Edge] ++= Seq(Edge("A", "B", 7)
      , Edge("A", "C", 8)
      , Edge("A", "D", 33)
      , Edge("A", "E", 30)
      , Edge("A", "F", 37)
      , Edge("A", "G", 29)
      , Edge("B", "C", 9)
      , Edge("D", "E", 47)
      , Edge("F", "G", 15))
  }

  def fillPostManGraph(): ListBuffer[Edge] = {
    readFromFile("postman.txt")
  }

}
