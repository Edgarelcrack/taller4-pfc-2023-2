/**
 * Plantilla para pruebas
 * Autores: <Edgar Andres Vargas Garcia-2259690 - Juan Pablo Escovar Viveros-2259519 >
* @version 1.0
* @note 22 de Noviembre de 2023 
 */
package taller4


import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestTaller4 extends AnyFunSuite {

  test("Multiplicación de Matrices") {
    type Matriz = Vector[Vector[Int]]

    val matriz1: Matriz = Vector(Vector(0, 1), Vector(1, 1))
    val matriz2: Matriz = Vector(Vector(1, 1), Vector(1, 0))

    val resultadoNormal = Taller4.multMatriz(matriz1, matriz2)
    val resultadoParalelo = Taller4.multMatrizParalelo(matriz1, matriz2)
    val resultadoRecursivo = Taller4.multMatrizRec(matriz1, matriz2)
    val resultadoRecursivoParalelo = Taller4.multMatrizRecParalelo(matriz1, matriz2)
    val resultadoStrassen = Taller4.multMatrizStrassen(matriz1, matriz2)
    val resultadoStrassenParalelo = Taller4.multMatrizStrassenParalelo(matriz1, matriz2)

    assert(resultadoNormal == Vector(Vector(1, 0), Vector(2, 1)))
    assert(resultadoParalelo == Vector(Vector(1, 0), Vector(2, 1)))
    assert(resultadoRecursivo == Vector(Vector(1, 0), Vector(2, 1)))
    assert(resultadoRecursivoParalelo == Vector(Vector(1, 0), Vector(2, 1)))
    assert(resultadoStrassen == Vector(Vector(1, 0), Vector(2, 1)))
    assert(resultadoStrassenParalelo == Vector(Vector(1, 0), Vector(2, 1)))
  }
  test("Multiplicación de Matrices 4x4") {
    type Matriz = Vector[Vector[Int]]
    val matriz1: Matriz = Vector(Vector(1, 0, 1, 0), Vector(0, 1, 0, 1), Vector(1, 0, 1, 0), Vector(1, 1, 1, 0))
    val matriz2: Matriz = Vector(Vector(1, 1, 1, 0), Vector(0, 1, 0, 1), Vector(1, 0, 1, 0), Vector(1, 1, 1, 0))

    val resultadoNormal = Taller4.multMatriz(matriz1, matriz2)
    val resultadoParalelo = Taller4.multMatrizParalelo(matriz1, matriz2)
    val resultadoRecursivo = Taller4.multMatrizRec(matriz1, matriz2)
    val resultadoRecursivoParalelo = Taller4.multMatrizRecParalelo(matriz1, matriz2)
    val resultadoStrassen = Taller4.multMatrizStrassen(matriz1, matriz2)
    val resultadoStrassenParalelo = Taller4.multMatrizStrassenParalelo(matriz1, matriz2)

    assert(resultadoNormal == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
    assert(resultadoParalelo == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
    assert(resultadoRecursivo == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
    assert(resultadoRecursivoParalelo == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
    assert(resultadoStrassen == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
    assert(resultadoStrassenParalelo == Vector(Vector(2, 1, 2, 0), Vector(1, 2, 1, 1), Vector(2, 1, 2, 0), Vector(2, 2, 2, 1)))
  }

  test("Multiplicación de Matrices 8x8") {
    type Matriz = Vector[Vector[Int]]

    val matriz1: Matriz = Vector(
      Vector(0, 1, 1, 0, 1, 0, 1, 1),
      Vector(1, 0, 1, 0, 1, 1, 0, 1),
      Vector(1, 1, 0, 0, 0, 1, 1, 0),
      Vector(0, 1, 1, 1, 0, 0, 1, 1),
      Vector(0, 0, 1, 0, 1, 1, 0, 0),
      Vector(1, 1, 1, 0, 0, 1, 1, 1),
      Vector(0, 0, 1, 1, 1, 0, 1, 0),
      Vector(1, 1, 0, 1, 0, 1, 0, 0)
    )


    val matriz2: Matriz = Vector(
      Vector(1, 0, 1, 1, 0, 1, 0, 1),
      Vector(0, 1, 0, 1, 1, 0, 1, 0),
      Vector(1, 1, 0, 0, 1, 0, 1, 1),
      Vector(0, 1, 1, 1, 0, 1, 0, 0),
      Vector(1, 0, 1, 0, 0, 1, 1, 1),
      Vector(0, 1, 0, 1, 1, 0, 0, 1),
      Vector(1, 0, 1, 0, 0, 1, 1, 0),
      Vector(0, 1, 1, 1, 1, 0, 0, 0)
    )
    val resultadoNormal = Taller4.multMatriz(matriz1, matriz2)
    val resultadoParalelo = Taller4.multMatrizParalelo(matriz1, matriz2)
    val resultadoRecursivo = Taller4.multMatrizRec(matriz1, matriz2)
    val resultadoRecursivoParalelo = Taller4.multMatrizRecParalelo(matriz1, matriz2)
    val resultadoStrassen = Taller4.multMatrizStrassen(matriz1, matriz2)
    val resultadoStrassenParalelo = Taller4.multMatrizStrassenParalelo(matriz1, matriz2)

    assert(resultadoNormal == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
    assert(resultadoParalelo == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
    assert(resultadoRecursivo == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
    assert(resultadoRecursivoParalelo == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
    assert(resultadoStrassen == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
    assert(resultadoStrassenParalelo == Vector(Vector(3, 3, 3, 2, 3, 2, 4, 2), Vector(3, 3, 3, 3, 3, 2, 2, 4), Vector(2, 2, 2, 3, 2, 2, 2, 2), Vector(2, 4, 3, 3, 3, 2, 3, 1), Vector(2, 2, 1, 1, 2, 1, 2, 3), Vector(3, 4, 3, 4, 4, 2, 3, 3), Vector(3, 2, 3, 1, 1, 3, 3, 2), Vector(1, 3, 2, 4, 2, 2, 1, 2)))
  }
  test("Multiplicación de Matrices 16x16") {


    import scala.util.Random


    val matriz1 = Vector(Vector(1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0), Vector(0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1), Vector(0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0), Vector(1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0), Vector(1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0), Vector(1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0), Vector(1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1), Vector(1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1), Vector(1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1), Vector(0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1), Vector(1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1), Vector(0, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0), Vector(1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0), Vector(0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0), Vector(1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0), Vector(1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0))

    val matriz2 = Vector(Vector(1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1), Vector(0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1), Vector(0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0), Vector(0, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1), Vector(0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0), Vector(0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1), Vector(1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0), Vector(1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1), Vector(0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1), Vector(0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0), Vector(0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1), Vector(0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1), Vector(0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0), Vector(0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0), Vector(0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 1), Vector(1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0))


    val resultadoNormal = Taller4.multMatriz(matriz1, matriz2)
    val resultadoParalelo = Taller4.multMatrizParalelo(matriz1, matriz2)
    val resultadoRecursivo = Taller4.multMatrizRec(matriz1, matriz2)
    val resultadoRecursivoParalelo = Taller4.multMatrizRecParalelo(matriz1, matriz2)
    val resultadoStrassen = Taller4.multMatrizStrassen(matriz1, matriz2)
    val resultadoStrassenParalelo = Taller4.multMatrizStrassenParalelo(matriz1, matriz2)

    assert(resultadoNormal == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
    assert(resultadoParalelo == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
    assert(resultadoRecursivo == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
    assert(resultadoRecursivoParalelo == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
    assert(resultadoStrassen == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
    assert(resultadoStrassenParalelo == Vector(Vector(3, 6, 6, 5, 7, 4, 6, 5, 9, 7, 7, 5, 6, 4, 6, 7), Vector(1, 4, 1, 3, 3, 3, 4, 4, 6, 4, 3, 4, 3, 5, 4, 3), Vector(2, 2, 2, 4, 3, 2, 4, 1, 4, 3, 4, 3, 3, 3, 4, 2), Vector(2, 6, 6, 5, 8, 5, 5, 6, 8, 7, 7, 5, 8, 6, 6, 7), Vector(3, 4, 4, 4, 5, 3, 6, 2, 8, 5, 6, 4, 5, 4, 6, 6), Vector(2, 4, 4, 3, 5, 3, 3, 4, 5, 6, 4, 3, 4, 4, 4, 5), Vector(4, 5, 4, 4, 5, 4, 4, 3, 6, 7, 6, 4, 5, 4, 5, 5), Vector(2, 6, 3, 4, 4, 4, 5, 3, 7, 6, 4, 4, 5, 4, 2, 4), Vector(4, 6, 5, 4, 8, 3, 6, 4, 9, 9, 5, 6, 7, 6, 7, 7), Vector(3, 4, 1, 2, 4, 4, 5, 2, 6, 4, 4, 2, 5, 6, 4, 3), Vector(3, 6, 5, 5, 8, 4, 4, 5, 8, 8, 7, 8, 8, 5, 6, 5), Vector(0, 3, 2, 2, 3, 1, 2, 3, 3, 4, 2, 3, 3, 3, 4, 3), Vector(1, 5, 4, 4, 4, 2, 4, 2, 6, 5, 4, 2, 5, 3, 4, 6), Vector(0, 4, 3, 4, 4, 2, 3, 4, 4, 5, 4, 2, 5, 4, 5, 5), Vector(2, 3, 3, 2, 2, 2, 4, 1, 5, 3, 4, 2, 4, 3, 3, 4), Vector(3, 6, 4, 5, 6, 5, 8, 4, 9, 7, 7, 4, 7, 6, 5, 6)))
  }

  import scala.util.Random

  test("Test Valores Random") {
    val size = 8
    val m1 = Vector.fill(size, size)(Random.nextInt(10))
    val m2 = m1.transpose

    val resEsperado = Taller4.multMatriz(m1, m2)

    val resMultMatriz = Taller4.multMatriz(m1, m2)
    val resMultPar = Taller4.multMatrizParalelo(m1, m2)
    val resRec = Taller4.multMatrizRec(m1, m2)
    val resRecParalelo = Taller4.multMatrizRecParalelo(m1, m2)
    val resStrassen = Taller4.multMatrizStrassen(m1, m2)
    val resStrassenPar = Taller4.multMatrizStrassenParalelo(m1, m2)

    assert(resMultMatriz == resEsperado)
    assert(resMultPar == resEsperado)
    assert(resRec == resEsperado)
    assert(resRecParalelo == resEsperado)
    assert(resStrassen == resEsperado)
    assert(resStrassenPar == resEsperado)
  }

}
