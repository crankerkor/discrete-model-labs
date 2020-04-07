import com.oleksandr.isomorphism_lab5.Isomorphism
import com.oleksandr.postman_lab2.PostMan
import com.oleksandr.prim_lab1.Prim
import com.oleksandr.salesman_lab4.Salesman
import com.oleksandr.{Edge, Graph}

import scala.collection.mutable.ListBuffer

object Main {
  def main(args: Array[String]): Unit = {
    val graph = new Graph(fillPostManGraph())
    new Prim(graph).findPrim()

    new PostMan(graph).postManPath()

    new Salesman(new com.oleksandr.Graph(fillSalesmanGraph())).gamiltonCycle()

    val isomorph = new Graph(fillIsomorphicGraph())
    val isomorphic = new Graph(fill2IsomorphicGraph())
    val isomorphismChecker = new Isomorphism(isomorph)

    isomorphismChecker.changeVerticeNames(isomorphic)
    isomorphismChecker.antiFlex(isomorphic, isomorphic.getVertices.size - 1)
    println("Are isomorphic? " + isomorphismChecker.general)
  }

  def fillGraph(): ListBuffer[Edge] = {
    new ListBuffer[Edge] ++= Seq(Edge("A", "B", 7)
      , Edge("A", "D", 5)
      , Edge("B", "C", 8)
      , Edge("B", "E", 7)
      , Edge("B", "D", 9)
      , Edge("C", "E", 5)
      , Edge("D", "E", 15)
      , Edge("D", "F", 6)
      , Edge("F", "G", 11)
      , Edge("G", "E", 9)
      , Edge("F", "E", 8))
  }

  def fillIsomorphicGraph(): ListBuffer[Edge] = {
    new ListBuffer[Edge] ++= Seq(Edge("A", "E", 1)
      , Edge("A", "F", 1)
      , Edge("A", "G", 1)
      , Edge("B", "E", 1)
      , Edge("B", "F", 1)
      , Edge("B", "H", 1)
      , Edge("C", "E", 1)
      , Edge("C", "G", 1)
      , Edge("C", "H", 1)
      , Edge("D", "F", 1)
      , Edge("D", "G", 1)
      , Edge("D", "H", 1)
    )
  }

  def fill2IsomorphicGraph(): ListBuffer[Edge] = {
    new ListBuffer[Edge] ++= Seq(Edge("A", "G", 1)
      , Edge("A", "H", 1)
      , Edge("A", "E", 1)
      , Edge("B", "G", 1)
      ,Edge("B", "H", 1)
      ,Edge("B", "F", 1)
      ,Edge("C", "G", 1)
      ,Edge("C", "E", 1)
      ,Edge("C", "F", 1)
      ,Edge("D", "H", 1)
      ,Edge("D", "E", 1)
      ,Edge("D", "F", 1))

  }

  def fillSalesmanGraph(): ListBuffer[Edge] = {
    new ListBuffer[Edge] ++= Seq(
      Edge("A", "B", 12)
      , Edge("A", "C", 5)
      , Edge("A", "D", 17)
      , Edge("E", "A", 6)
      , Edge("B", "C", 13)
      , Edge("B", "D", 9)
      , Edge("B", "E", 13)
      , Edge("C", "D", 7)
      , Edge("C", "E", 8)
      , Edge("D", "E", 2))
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
    new ListBuffer[Edge] ++= Seq(
      Edge("C", "G", 1)
      , Edge("B", "C", 1)
      , Edge("A", "B", 1)
      , Edge("E", "C", 1)
      , Edge("D", "E", 1)
      , Edge("C", "D", 1)
      , Edge("A", "C", 1)
      , Edge("C", "F", 1)
      , Edge("G", "F", 1))

  }

}
