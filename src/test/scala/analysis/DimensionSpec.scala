package analysis

import shapeless._
import analysis.ops.dimensions._

import baseDimensions._

object DimensionSpec {

  object ShouldEq {
    type LM_SS = Dimensions[Length :: Mass :: HNil, Time :: Time :: HNil]
    type ML_SS = Dimensions[Mass :: Length :: HNil, Time :: Time :: HNil]
    the[Eq[LM_SS, ML_SS]]
  }

  object ShouldSimplify {
    type Unsimplified = Dimensions[Length :: Mass :: Length :: HNil, Length :: Length :: HNil]
    type Simplified = Dimensions[Mass :: HNil, HNil]
    the[Simplify.Aux[Unsimplified, Simplified]]
  }

  object ShouldMultiply {
    type LM_SS = Dimensions[Length :: Mass :: HNil, Time :: Time :: HNil]
    type SS_L = Dimensions[Time :: Time :: HNil, Length :: HNil]
    type M = Dimensions[Mass :: HNil, HNil]
    the[Multiply.Aux[LM_SS, SS_L, M]]
  }

  object ShouldInvert {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    type S_LM = Dimensions[Time :: HNil, Length :: Mass :: HNil]
    the[Invert.Aux[LM_S, S_LM]]
  }

  object ShouldDivide {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    type EmptyDim = Dimensions[HNil, HNil]
    the[Divide.Aux[LM_S, LM_S, EmptyDim]]
  }

  object ShouldPowerPositive {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    type LLMM_SS = Dimensions[Length :: Length :: Mass :: Mass :: HNil, Time :: Time :: HNil]
    val power = the[Power[LM_S, 2]]
    the[Eq[power.Out, LLMM_SS]]
  }

  object ShouldPowerNegative {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    type SS_LLMM = Dimensions[Time :: Time :: HNil, Length :: Length :: Mass :: Mass :: HNil]
    val power = the[Power[LM_S, -2]]
    the[Eq[power.Out, SS_LLMM]]
  }

  object ShouldPowerZero {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    the[Power.Aux[LM_S, 0, Dimensions[HNil, HNil]]]
  }

  object ShouldShowDimension {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    the[ShowDimension[LM_S]]
  }

  object ShouldShowUnit extends App {
    type LM_S = Dimensions[Length :: Mass :: HNil, Time :: HNil]
    the[ShowUnit[LM_S]]
  }
}
