package analysis

import org.scalatest._

import shapeless._
import analysis.ops.quantity._
import baseDimensions._

import singleton.ops.{Length => _, _}
import singleton.ops.impl._

class QuantitySpec extends FlatSpec {
  it should "prefix" in pending

  it should "add" in pending

  it should "multiply" in {
    type D0 = Dimensions[Length :: Mass :: HNil, HNil]
    type D1 = Dimensions[Mass :: Length :: HNil, HNil]
    type Q0 = Quantity[3, Dimensions[Length :: Mass :: HNil, HNil]]
    type Q1 = Quantity[4, Dimensions[Mass :: Length :: HNil, HNil]]
    the[Multiply[Q0, Q1]]

    val q0 = Quantity[3, D0](2.0)
    val q1 = Quantity[4, D1](3.0)
    assert(q0.multiply(q1) === Quantity[7, Dimensions[Length :: Mass :: Mass :: Length :: HNil, HNil]](6.0))
  }

  it should "invert" in pending

  it should "divide" in pending

  it should "power" in pending

  it should "show" in pending
}
