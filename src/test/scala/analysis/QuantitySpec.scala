package analysis

import shapeless._
import analysis.ops.quantity._
import baseDimensions._

import singleton.ops._
import singleton.ops.impl._

object QuantitySpec {

  object ShouldPrefix {
    type D = Dimensions[Length :: Mass :: HNil, HNil]
    //the[Prefix[Quantity[4, D], 5]]
  }

  object ShouldAdd {
    type D0 = Dimensions[Length :: Mass :: HNil, HNil]
    type D1 = Dimensions[Mass :: Length :: HNil, HNil]
    type Q0 = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    type Q1 = Quantity[4, Dimensions[Mass :: Length :: HNil, HNil]]

    // ops.quantity.Add.quantityAdd[3, D0, 4, D1, 4, 1, 0](
    // the[analysis.ops.dimensions.Eq[Dimensions[Length :: Mass :: HNil, HNil], Dimensions[Mass :: Length :: HNil, HNil]]],
    // the[OpInt.Aux[Max[3, 4], 4]],
    // the[OpInt.Aux[4 - 3, 1]],
    // the[OpInt.Aux[4 - 4, 0]],
    // the[ValueOf[1]],
    // the[ValueOf[0]]
    // )
    //the[Add[Q0, Q1]]
  }

  object ShouldSubtract

  object ShouldMultiply {
    type D0 = Dimensions[Length :: Mass :: HNil, HNil]
    type D1 = Dimensions[Mass :: Length :: HNil, HNil]
    type Q0 = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    type Q1 = Quantity[4, Dimensions[Mass :: Length :: HNil, HNil]]
    the[Multiply[Q0, Q1]]
  }

  object ShouldInvert {
    type Q = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type Inverse = Quantity[-3, Dimensions[HNil, Length :: HNil]]
    the[Invert.Aux[Q, Inverse]]
  }

  object ShouldDivide {
    type Q0 = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type Q1 = Quantity[2, Dimensions[Length :: HNil, HNil]]
    type Result = Quantity[1, Dimensions[HNil, HNil]]
    the[Divide.Aux[Q0, Q1, Result]]
  }

  object ShouldPower {
    type Q = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type QRaised = Quantity[6, Dimensions[Length :: Length ::HNil, HNil]]
    the[Power.Aux[Q, 2, QRaised]]
  }

  object ShouldShow {
    type Q = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    the[Show[Q]]
  }
}
// package analysis


// class QuantitySpec extends FlatSpec {


//   it should "subtract quantities of the same dimensions" in pending
//   it should "fail subtracting quantities of different dimensions" in pending
//   it should "pretty print base dimensions" in pending
//   it should "pretty print with base units" in pending
// }

