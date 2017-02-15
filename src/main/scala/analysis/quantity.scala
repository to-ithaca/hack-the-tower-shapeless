package analysis

//TODO: make this parameterized on any type
case class Quantity[I <: Singleton with Int, D <: Dimensions[_, _]](value: Double)
