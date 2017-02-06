package analysis
package ops

import shapeless._
import shapeless.ops.hlist._
import singleton.ops._
import singleton.ops.impl._

object dimensions {
  /**
   * Type class to simplify the numerator and denominator of dimensions `D`.
   * 
   * The output contains no shared elements in the numerator and denominator.
   */
  trait Simplify[D <: Dimensions[_,_]] {
    type Out <: Dimensions[_,_]
  }

  object Simplify {

    type Aux[D <: Dimensions[_, _], Out0 <: Dimensions[_, _]] = Simplify[D] { type Out = Out0 }

    implicit def dimensionsSimplify[N <: HList, D <: HList, NS <: HList, DS <: HList](
      implicit ev0: Diff.Aux[N, D, NS], ev1: Diff.Aux[D, N, DS]
    ): Simplify.Aux[Dimensions[N, D], Dimensions[NS, DS]] = new Simplify[Dimensions[N, D]] {
      type Out = Dimensions[NS, DS]
    }
  }


  /**
   * Type class to multiply dimensions `L` and `R` together.
   * 
   * The output contains a simplified combination of elements in `L` appended to elements in `R`
   */
  trait Multiply[L <: Dimensions[_, _], R <: Dimensions[_, _]] {
    type Out <: Dimensions[_, _]
  }

  object Multiply {
    type Aux[L <: Dimensions[_, _], R <: Dimensions[_, _], Out0 <: Dimensions[_, _]] = Multiply[L, R] { type Out = Out0 }

    implicit def dimensionsMultiply[NL <: HList, DL <: HList, NR <: HList, DR <: HList, NOut <: HList, DOut <: HList,
      DimOut <: Dimensions[_, _]](
      implicit evN: Prepend.Aux[NL, NR, NOut], evD: Prepend.Aux[DL, DR, DOut], s: Simplify.Aux[Dimensions[NOut, DOut], DimOut]
    ) : Multiply.Aux[Dimensions[NL, DL], Dimensions[NR, DR], DimOut] =
      new Multiply[Dimensions[NL, DL], Dimensions[NR, DR]] {
        type Out = DimOut
      }
  }
}
