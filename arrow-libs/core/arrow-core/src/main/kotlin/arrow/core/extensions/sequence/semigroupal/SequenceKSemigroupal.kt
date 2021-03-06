package arrow.core.extensions.sequence.semigroupal

import arrow.core.Tuple2
import arrow.core.extensions.SequenceKSemigroupal
import kotlin.sequences.Sequence

/**
 *  Multiplicatively combine F<A> and F<B> into F<Tuple2<A, B>>
 */
@JvmName("product")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith(
    "this.zip(arg1, ::Pair)"
  ),
  DeprecationLevel.WARNING
)
fun <A, B> Sequence<A>.product(arg1: Sequence<B>): Sequence<Tuple2<A, B>> =
  arrow.core.extensions.sequence.semigroupal.Sequence.semigroupal().run {
    arrow.core.SequenceK(this@product).product<A, B>(arrow.core.SequenceK(arg1)) as
      kotlin.sequences.Sequence<arrow.core.Tuple2<A, B>>
  }

/**
 * syntax
 */
@JvmName("times")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith(
    "this.zip(arg1, ::Pair)"
  ),
  DeprecationLevel.WARNING
)
operator fun <A, B> Sequence<A>.times(arg1: Sequence<B>): Sequence<Tuple2<A, B>> =
  arrow.core.extensions.sequence.semigroupal.Sequence.semigroupal().run {
    arrow.core.SequenceK(this@times).times<A, B>(arrow.core.SequenceK(arg1)) as
      kotlin.sequences.Sequence<arrow.core.Tuple2<A, B>>
  }

/**
 * cached extension
 */
@PublishedApi()
internal val semigroupal_singleton: SequenceKSemigroupal = object :
  arrow.core.extensions.SequenceKSemigroupal {}

@Deprecated(
  "Receiver Sequence object is deprecated, prefer to turn Sequence functions into top-level functions",
  level = DeprecationLevel.WARNING
)
object Sequence {
  /**
   *  The [Semigroupal] type class for a given type `F` can be seen as an abstraction over the [cartesian product](https://en.wikipedia.org/wiki/Cartesian_product).
   *  It defines the function [product].
   *
   *  The [product] function for a given type `F`, `A` and `B` combines a `Kind<F, A>` and a `Kind<F, B>` into a `Kind<F, Tuple2<A, B>>`.
   *  This function guarantees compliance with the following laws:
   *
   *  [Semigroupal]s are associative under the bijection `f = (a,(b,c)) -> ((a,b),c)` or `f = ((a,b),c) -> (a,(b,c))`.
   *  Therefore, the following laws also apply:
   *
   *  ```kotlin
   *  f((a.product(b)).product(c)) == a.product(b.product(c))
   *  ```
   *
   *  ```kotlin
   *  f(a.product(b.product(c))) == (a.product(b)).product(c)
   *  ```
   *
   *  Currently, [Semigroupal] instances are defined for [Option], [ListK], [SequenceK] and [SetK].
   *
   *  ```kotlin:ank:playground
   *  import arrow.core.*
   * import arrow.core.extensions.sequencek.semigroupal.*
   * import arrow.core.*
   *
   *
   *
   *  fun main(args: Array<String>) {
   *   val result =
   *   //sampleStart
   *   SequenceK.semigroupal()
   *   //sampleEnd
   *   println(result)
   *  }
   *  ```
   *
   *  ### Examples
   *
   *  Here a some examples:
   *
   *  ```kotlin:ank:playground
   *  import arrow.core.Option
   *  import arrow.core.extensions.option.semigroupal.semigroupal
   *
   *  fun main(args: Array<String>) {
   *   val result =
   *   //sampleStart
   *   Option.semigroupal().run {
   *       Option.just(1).product(Option.just(1))
   *   }
   *   //sampleEnd
   *   println(result)
   *  }
   *  ```
   *
   *  [Semigroupal] also has support of the `*` syntax:
   *
   *  ```kotlin:ank:playground
   *  import arrow.core.Option
   *  import arrow.core.extensions.option.semigroupal.semigroupal
   *
   *  fun main(args: Array<String>) {
   *   val result =
   *   //sampleStart
   *   Option.semigroupal().run {
   * Option.just(2)
   *   }
   *   //sampleEnd
   *   println(result)
   *  }
   *  ```
   *  The same applies to [ListK], [SequenceK] and [SetK] instances:
   *
   *  ```kotlin:ank:playground
   *  import arrow.core.ListK
   *  import arrow.core.extensions.listk.semigroupal.semigroupal
   *  import arrow.core.k
   *
   *  fun main(args: Array<String>) {
   *   val result =
   *   //sampleStart
   *   ListK.semigroupal().run {
   * listOf('a','b','c').k()
   *   }
   *   //sampleEnd
   *   println(result)
   *  }
   *  ```
   */
  @Suppress(
    "UNCHECKED_CAST",
    "NOTHING_TO_INLINE"
  )
  @Deprecated(
    "Semigroupal typeclass is deprecated. Use concrete methods on Sequence",
    level = DeprecationLevel.WARNING
  )
  inline fun semigroupal(): SequenceKSemigroupal = semigroupal_singleton
}
