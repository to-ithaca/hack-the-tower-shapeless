package analysis
package ops

import shapeless._

object quantity {

  /**
   * Type class for adding quantities `L` and `R`.
   * This only exists if `L` and `R` have the same dimensions.
   */
  trait Add[L <: Quantity[_, _], R <: Quantity[_, _]] extends DepFn2[L, R] {
    type Out <: Quantity[_, _]
  }

  object Add {
    type Aux[L <: Quantity[_, _], R <: Quantity[_, _], Out0 <: Quantity[_, _]] = Add[L, R] { type Out = Out0 }
  }
}
