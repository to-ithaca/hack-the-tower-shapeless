package analysis

import org.scalatest._

import shapeless._
import shapeless.test._
import analysis.ops.dimensions._

import baseDimensions._

class DimensionsSpec extends FlatSpec {
  it should "eq same dimensions" in pending

  it should "not eq different dimensions" in pending

  it should "simplify" in {
    type Unsimplified = Dimensions[Length :: Mass :: Length :: HNil, Length :: Length :: HNil]
    type Simplified = Dimensions[Mass :: HNil, HNil]
    the[Simplify.Aux[Unsimplified, Simplified]]
  }

  it should "multiply" in {
    type LM_SS = Dimensions[Length :: Mass :: HNil, Time :: Time :: HNil]
    type SS_L = Dimensions[Time :: Time :: HNil, Length :: HNil]
    type M = Dimensions[Mass :: HNil, HNil]
    the[Multiply.Aux[LM_SS, SS_L, M]]
  }

  it should "invert" in pending

  it should "divide" in pending

  it should "raise to a positive power" in pending

  it should "raise to a negative power" in pending

  it should "raise to the power 0" in pending

  it should "show dimensions" in pending

  it should "show units" in pending
}
