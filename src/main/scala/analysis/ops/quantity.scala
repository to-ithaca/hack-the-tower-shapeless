package analysis
package ops

import shapeless._
import singleton.ops._
import singleton.ops.impl._

object quantity {
  /**
    * Type class for multiplying quantities `L` and `R`
   */
  trait Multiply[L <: Quantity[_, _], R <: Quantity[_, _]] extends DepFn2[L, R] {
    type Out <: Quantity[_, _]
  }

  object Multiply {
    type Aux[L <: Quantity[_, _], R <: Quantity[_, _], Out0 <: Quantity[_, _]] = Multiply[L, R] { type Out = Out0 }

    implicit def quantityMultiply[IL <: Singleton with Int, DL <: Dimensions[_, _], IR <: Singleton with Int, DR <: Dimensions[_, _], IOut <: Singleton with Int, DOut <: Dimensions[_, _]](
      implicit dimensionsM: dimensions.Multiply.Aux[DL, DR, DOut],
      prefixM: OpInt.Aux[IL + IR, IOut]
    ): Multiply.Aux[Quantity[IL, DL], Quantity[IR, DR], Quantity[IOut, DOut]] =
      new Multiply[Quantity[IL, DL], Quantity[IR, DR]] {
      type Out = Quantity[IOut, DOut]
      def apply(l: Quantity[IL, DL], r: Quantity[IR, DR]): Quantity[IOut, DOut] = Quantity[IOut, DOut](l.value * r.value)
    }
  }
}
