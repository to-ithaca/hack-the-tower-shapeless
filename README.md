# Step 0 - Dimensional Analysis

## The Problem
Physical quantities are related to each other in different ways. For example, take the formula

`speed = distance / time`

Unfortunately, it's easy to make a mistake using basic Numeric types.

```scala
val roadLength = 5 //metres
val carSpeed = 10 //metres per second
val traversalTime = 10 / 5 //gives 2 seconds^-1 Oh noes!
```
We've gotten our formula wrong!  Our `traversalTime` is clearly going to be wrong, but we have no way of knowing it.

## A solution
It would be great if we could somehow tell the compiler that `traversalTime` should be in seconds.

We could do that using classes.

```scala
class Distance(val value: Double) extends AnyVal {
  def /(s: Speed): Time = new Time(value / s.value)
}
class Time(val value: Double) extends AnyVal
class Speed(val value: Double) extends AnyVal
```

We've effectively coded our formula into the compilation step.  We'll now find any errors at compile time.

But this introduces a lot of boilerplate.  It would be better if we could get compile time safety without having to write a load of functions for every formula we want.

Later on, we'll use dependent types to do just that!  But first, an aside on dimensional analysis.

## The essence of dimensional analysis
