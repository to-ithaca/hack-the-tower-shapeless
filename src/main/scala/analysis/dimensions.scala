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
}
