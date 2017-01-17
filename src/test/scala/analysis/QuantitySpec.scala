package analysis

import org.scalatest._

import shapeless._
import analysis.ops.quantity._
import baseDimensions._

import singleton.ops._
import singleton.ops.impl._

class QuantitySpec extends FlatSpec {
  it should "prefix" in {
    type D = Dimensions[Length :: Mass :: HNil, HNil]
   //the[Prefix[Quantity[4, D], 5]]
  }

  it should "add" in {
    type D0 = Dimensions[Length :: Mass :: HNil, HNil]
    type D1 = Dimensions[Mass :: Length :: HNil, HNil]
    type Q0 = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    type Q1 = Quantity[4, Dimensions[Mass :: Length :: HNil, HNil]]
    //the[Add[Q0, Q1]]
  }

  it should "multiply" in {
    type D0 = Dimensions[Length :: Mass :: HNil, HNil]
    type D1 = Dimensions[Mass :: Length :: HNil, HNil]
    type Q0 = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    type Q1 = Quantity[4, Dimensions[Mass :: Length :: HNil, HNil]]
    the[Multiply[Q0, Q1]]
  }

  it should "invert" in {
    type Q = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type Inverse = Quantity[-3, Dimensions[HNil, Length :: HNil]]
    the[Invert.Aux[Q, Inverse]]
  }

  it should "divide" in {
    type Q0 = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type Q1 = Quantity[2, Dimensions[Length :: HNil, HNil]]
    type Result = Quantity[1, Dimensions[HNil, HNil]]
    the[Divide.Aux[Q0, Q1, Result]]
  }

  it should "power" in {
    type Q = Quantity[3, Dimensions[Length :: HNil, HNil]]
    type QRaised = Quantity[6, Dimensions[Length :: Length ::HNil, HNil]]
    the[Power.Aux[Q, 2, QRaised]]
  }

  it should "show" in {
    type Q = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    the[Show[Q]]
  }
}
