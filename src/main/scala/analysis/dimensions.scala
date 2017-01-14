package analysis

import shapeless._
/**
  * Represents the dimensions of a quantity, in base units
  * e.g. an acceleration of 3ms-2 in SI Units would have Dimensions[Length :: HNil, Time :: Time :: HNil]
  */
trait Dimensions[Numerator <: HList, Denominator <: HList]

object baseDimensions {
  type Length
  type Time
  type Mass

  implicit def lengthShowDimension: analysis.ops.dimensions.ShowDimension[Length] = new analysis.ops.dimensions.ShowDimension[Length] {
    def apply(): String = "L"
  }
  implicit def massShowDimension: analysis.ops.dimensions.ShowDimension[Mass] = new analysis.ops.dimensions.ShowDimension[Mass] {
    def apply(): String = "M"
  }
  implicit def timeShowDimension: analysis.ops.dimensions.ShowDimension[Time] = new analysis.ops.dimensions.ShowDimension[Time] {
    def apply(): String = "T"
  }
  implicit def lengthShowUnit: analysis.ops.dimensions.ShowUnit[Length] = new analysis.ops.dimensions.ShowUnit[Length] {
    def apply(): String = "m"
  }
  implicit def massShowUnit: analysis.ops.dimensions.ShowUnit[Mass] = new analysis.ops.dimensions.ShowUnit[Mass] {
    def apply(): String = "kg"
  }
  implicit def timeShowUnit: analysis.ops.dimensions.ShowUnit[Time] = new analysis.ops.dimensions.ShowUnit[Time] {
    def apply(): String = "s"
  }
}
