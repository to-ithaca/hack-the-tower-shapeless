package analysis
package syntax

import analysis.ops.quantity._

final class QuantityOps[P0 <: Singleton with Int, D0 <: Dimensions[_, _]](val q0: Quantity[P0, D0]) {
  def multiply[P1 <: Singleton with Int, D1 <: Dimensions[_, _]](q1: Quantity[P1, D1])(implicit m: Multiply[Quantity[P0, D0], Quantity[P1, D1]]): m.Out = m(q0, q1)
}
