/**
 * Plantilla para pruebas
* @author Carlos Delgado
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
  test("Multiplicación de Matrices") {


    import scala.util.Random
    type Matriz = Vector[Vector[Int]]

    // Genera una matriz de tamaño n x m con valores aleatorios de 0 y 1
    def generarMatriz(n: Int, m: Int): Matriz = {
      Vector.tabulate(n) { _ =>
        Vector.tabulate(m) { _ =>
          Random.nextInt(2)
        }
      }
    }

    val matriz1 = generarMatriz(1024, 1024)
    val matriz2 = generarMatriz(1024, 1024)

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

}
