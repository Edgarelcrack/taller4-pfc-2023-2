/**
 * Taller 3 - Programación Funcional
 * Autores: <Edgar Andres Vargas Garcia-2259690 - Juan Pablo Escovar Viveros-2259519 >
 * Profesor: Carlos A Delgado
 */

package taller4
import common._
import org.scalameter.{Warmer, withWarmer}
import scala.collection.parallel.immutable.ParVector
import scala.util.Random

object Taller4{

 type Matriz = Vector[Vector[Int]]

 val random = new Random

 def matrizAlAzar(long: Int, vals: Int): Matriz = {
  val v = Vector.fill (long, long) {random.nextInt(vals)}
  v
 }

 def vectorAlAzar(long: Int, vals: Int): Vector[Int] = {
  val v = Vector.fill (long) {
   random.nextInt(vals)
  }
  v
 }

 def vectorAlAzarPar(long: Int, vals: Int): ParVector[Int] = {
  val random = new Random()
  val v = ParVector.fill(long) {
   random.nextInt(vals)
  }
  v
 }


 def prodPunto(v1: Vector[Int], v2: Vector[Int]): Int = {
  (v1 zip v2).map({
   case(i, j)
   => (i * j)
  }).sum
 }

 def prodPuntoParD(v1: ParVector[Int], v2: ParVector[Int]): Int = {
  (v1 zip v2).map({ case (i, j) => i * j }).sum
 }


 def transpuesta(m: Matriz): Matriz = {
  val l = m.length
  Vector.tabulate (l, l)((i, j) => m(j)(i))
 }

 def multMatriz(m1: Matriz, m2: Matriz): Matriz = {
  val m2Transpuesta = transpuesta(m2)
  Vector.tabulate(m1.length, m2Transpuesta.length) {
   (i, j) => prodPunto(m1(i), m2Transpuesta(j))
  }
 }

 def multMatrizParalelo(m1: Matriz, m2: Matriz): Matriz = {
  val m2Transpuesta = transpuesta(m2)
  val resultados = Vector.tabulate(m1.length, m2Transpuesta.length) {
   (i, j) =>
    task {
     prodPunto(m1(i), m2Transpuesta(j))
    }
  }

  resultados.map(row => row.map(_.join()))
 }



 def subMatriz(m: Matriz, i: Int, j: Int, l: Int): Matriz = {
  Vector.tabulate(l) { row =>
   Vector.tabulate(l) { col =>
    m(i + row)(j + col)
   }
  }
 }

 def sumMatriz(m1: Matriz, m2: Matriz): Matriz = {
  def sumaElementos(v1: Vector[Int], v2: Vector[Int]): Vector[Int] =
   Vector.tabulate(v1.length)(i => v1(i) + v2(i))

  def sumaMatrices(m1: Matriz, m2: Matriz): Matriz = {
   def sumaElementosMatrices(x1: Matriz, x2: Matriz): Matriz =
    Vector.tabulate(x1.length)(i => sumaElementos(x1(i), x2(i)))

   sumaElementosMatrices(m1, m2)
  }
  sumaMatrices(m1, m2)
 }

 def multMatrizRec(m1: Matriz, m2: Matriz): Matriz = {
  val n = m1.length
  if (n == 1) {
   Vector(Vector(m1(0)(0) * m2(0)(0)))
  } else {
   val (a11, a12, a21, a22) = (
     subMatriz(m1, 0, 0, n / 2),
     subMatriz(m1, 0, n / 2, n / 2),
     subMatriz(m1, n / 2, 0, n / 2),
     subMatriz(m1, n / 2, n / 2, n / 2)
   )
   val (b11, b12, b21, b22) = (
     subMatriz(m2, 0, 0, n / 2),
     subMatriz(m2, 0, n / 2, n / 2),
     subMatriz(m2, n / 2, 0, n / 2),
     subMatriz(m2, n / 2, n / 2, n / 2)
   )
   val c11 = sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21))
   val c12 = sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22))
   val c21 = sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21))
   val c22 = sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))

   Vector.tabulate(n) { i =>
    Vector.tabulate(n) { j =>
     if (i < n / 2 && j < n / 2) c11(i)(j)
     else if (i < n / 2 && j >= n / 2) c12(i)(j - n / 2)
     else if (i >= n / 2 && j < n / 2) c21(i - n / 2)(j)
     else c22(i - n / 2)(j - n / 2)
    }
   }
  }
 }
 def multMatrizRecParalelo(m1: Matriz, m2: Matriz): Matriz = {
  val n = m1.length
  if (n == 1) {
   Vector(Vector(m1(0)(0) * m2(0)(0)))
  } else {
   val (a11, a12, a21, a22) = parallel(
    subMatriz(m1, 0, 0, n / 2),
    subMatriz(m1, 0, n / 2, n / 2),
    subMatriz(m1, n / 2, 0, n / 2),
    subMatriz(m1, n / 2, n / 2, n / 2))

   val (b11, b12, b21, b22) = parallel (subMatriz(m2, 0, 0, n / 2), subMatriz(m2, 0, n / 2, n / 2), subMatriz(m2, n / 2, 0, n / 2), subMatriz(m2, n / 2, n / 2, n / 2))

   val (c11, c12, c21, c22) = parallel(
    sumMatriz(multMatrizRec(a11, b11), multMatrizRec(a12, b21)),
    sumMatriz(multMatrizRec(a11, b12), multMatrizRec(a12, b22)),
    sumMatriz(multMatrizRec(a21, b11), multMatrizRec(a22, b21)),
    sumMatriz(multMatrizRec(a21, b12), multMatrizRec(a22, b22))

   )

   Vector.tabulate(n) { i =>
    Vector.tabulate(n) { j =>
     if (i < n / 2 && j < n / 2) c11(i)(j)
     else if (i < n / 2 && j >= n / 2) c12(i)(j - n / 2)
     else if (i >= n / 2 && j < n / 2) c21(i - n / 2)(j)
     else c22(i - n / 2)(j - n / 2)
    }
   }
  }
 }


 def restaMatriz(m1: Matriz, m2: Matriz): Matriz = {
  def restaMatrices(m1: Matriz, m2: Matriz): Matriz = {
   def restaElementos(v1: Vector[Int], v2: Vector[Int]): Vector[Int] =
    Vector.tabulate(v1.length)(i => v1(i) - v2(i))
   def restaElementosMatrices(x1: Matriz, x2: Matriz): Matriz =
    Vector.tabulate(x1.length)(i => restaElementos(x1(i), x2(i)))
   restaElementosMatrices(m1, m2)
  }

  restaMatrices(m1, m2)
 }

 def multMatrizStrassen(m1: Matriz, m2: Matriz): Matriz = {
  val n = m1.length
  if (n == 1) {
   Vector(Vector(m1(0)(0) * m2(0)(0)))
  } else {

   val l = n / 2
   val a11 = subMatriz(m1, 0, 0, l)
   val a12 = subMatriz(m1, 0, l, l)
   val a21 = subMatriz(m1, l, 0, l)
   val a22 = subMatriz(m1, l, l, l)

   val b11 = subMatriz(m2, 0, 0, l)
   val b12 = subMatriz(m2, 0, l, l)
   val b21 = subMatriz(m2, l, 0, l)
   val b22 = subMatriz(m2, l, l, l)

   val s1 = restaMatriz(b12, b22)
   val s2 = sumMatriz(a11, a12)
   val s3 = sumMatriz(a21, a22)
   val s4 = restaMatriz(b21, b11)
   val s5 = sumMatriz(a11, a22)
   val s6 = sumMatriz(b11, b22)
   val s7 = restaMatriz(a12, a22)
   val s8 = sumMatriz(b21, b22)
   val s9 = restaMatriz(a11, a21)
   val s10 = sumMatriz(b11, b12)

   val p1 = multMatrizStrassen(a11, s1)
   val p2 = multMatrizStrassen(s2, b22)
   val p3 = multMatrizStrassen(s3, b11)
   val p4 = multMatrizStrassen(a22, s4)
   val p5 = multMatrizStrassen(s5, s6)
   val p6 = multMatrizStrassen(s7, s8)
   val p7 = multMatrizStrassen(s9, s10)

   val c11 = sumMatriz(restaMatriz(sumMatriz(p5,p4),p2),p6)
   val c12 = sumMatriz(p1, p2)
   val c21 = sumMatriz(p3, p4)
   val c22 = restaMatriz(restaMatriz(sumMatriz(p5,p1),p3),p7)

   Vector.tabulate(n) { i =>
    Vector.tabulate(n) { j =>
     if (i < l && j < l) c11(i)(j)
     else if (i < l && j >= l) c12(i)(j - l)
     else if (i >= l && j < l) c21(i - l)(j)
     else c22(i - l)(j - l)
    }
   }
  }
 }

 def multMatrizStrassenParalelo(m1: Matriz, m2: Matriz): Matriz = {
  val n = m1.length
  if (n == 1) {
   Vector(Vector(m1(0)(0) * m2(0)(0)))
  } else {
   val l = n / 2

   val (a11, a12, a21, a22) = parallel(
    subMatriz(m1, 0, 0, l), subMatriz(m1, 0, l, l),
    subMatriz(m1, l, 0, l), subMatriz(m1, l, l, l)
   )

   val (b11, b12, b21, b22) = parallel(
    subMatriz(m2, 0, 0, l), subMatriz(m2, 0, l, l),
    subMatriz(m2, l, 0, l), subMatriz(m2, l, l, l)
   )

   val (s1, s2, s3, s4) = parallel(
    restaMatriz(b12, b22),
    sumMatriz(a11, a12),
    sumMatriz(a21, a22),
    restaMatriz(b21, b11)
   )
   val (s5, s6, s7, s8) = parallel(
    sumMatriz(a11, a22),
    sumMatriz(b11, b22),
    restaMatriz(a12, a22),
    sumMatriz(b21, b22),

   )
   val (s9, s10) = parallel(
    restaMatriz(a11, a21),
    sumMatriz(b11, b12)
   )

   val ( p5, p6) = parallel(
    multMatrizStrassen(s5, s6),
    multMatrizStrassen(s7, s8)
   )
   val (p1, p2, p3, p4) = parallel(
    multMatrizStrassen(a11, s1),
    multMatrizStrassen(s2, b22),
    multMatrizStrassen(s3, b11),
    multMatrizStrassen(a22, s4)

   )
   val p7 = multMatrizStrassen(s9, s10)

   val (c11, c12, c21, c22) = parallel(
    sumMatriz(restaMatriz(sumMatriz(p5, p4), p2), p6),
    sumMatriz(p1, p2),
    sumMatriz(p3, p4),
    restaMatriz(restaMatriz(sumMatriz(p5, p1), p3), p7)
   )

   Vector.tabulate(n) { i =>
    Vector.tabulate(n) { j =>
     if (i < l && j < l) c11(i)(j)
     else if (i < l && j >= l) c12(i)(j - l)
     else if (i >= l && j < l) c21(i - l)(j)
     else c22(i - l)(j - l)
    }
   }
  }
 }
 def main(args: Array[String]): Unit = {

  val matriz1 = matrizAlAzar(2, 2)
  val matriz2 = matrizAlAzar(2, 2)


  println(
   withWarmer(new Warmer.Default) measure {
    multMatriz(matriz1, matriz2)
   }
  )

  println(
   withWarmer(new Warmer.Default) measure {
    multMatrizParalelo(matriz1, matriz2)
   }
  )

  println(
   withWarmer(new Warmer.Default) measure {
    multMatrizRec(matriz1, matriz2)
   }
  )

  println(
   withWarmer(new Warmer.Default) measure {
    multMatrizRecParalelo(matriz1, matriz2)
   }
  )

  println(
   withWarmer(new Warmer.Default) measure {
    multMatrizStrassen(matriz1, matriz2)
   }
  )

  println(
   withWarmer(new Warmer.Default) measure {
    multMatrizStrassenParalelo(matriz1, matriz2)
   }
  )

   def compararProdPunto(l: Int): (Double, Double, Double) = {
    val v1 = vectorAlAzar(l, 2)
    val v2 = vectorAlAzar(l, 2)
    val v1Par = vectorAlAzarPar(l, 2)
    val v2Par = vectorAlAzarPar(l, 2)

    val tiempoAlgoritmo1 = withWarmer(new Warmer.Default) measure {
     prodPunto(v1, v2)
    }
    val tiempoAlgoritmo2 = withWarmer(new Warmer.Default) measure {
     prodPuntoParD(v1Par, v2Par)
    }

    val promedio = tiempoAlgoritmo1.value / tiempoAlgoritmo2.value
    (tiempoAlgoritmo1.value, tiempoAlgoritmo2.value, promedio)

   }
  println(compararProdPunto(1000))
 }
}
