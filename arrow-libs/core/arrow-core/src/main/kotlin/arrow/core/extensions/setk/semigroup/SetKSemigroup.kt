package arrow.core.extensions.setk.semigroup

import arrow.core.SetK
import arrow.core.SetK.Companion
import arrow.core.extensions.SetKSemigroup
import kotlin.Any
import kotlin.Deprecated
import kotlin.PublishedApi
import kotlin.Suppress
import kotlin.jvm.JvmName

/**
 * cached extension
 */
@PublishedApi()
internal val semigroup_singleton: SetKSemigroup<Any?> = object : SetKSemigroup<Any?> {}

@JvmName("plus")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith("this + arg1"),
  DeprecationLevel.WARNING
)
operator fun <A> SetK<A>.plus(arg1: SetK<A>): SetK<A> = arrow.core.SetK.semigroup<A>().run {
  this@plus.plus(arg1) as arrow.core.SetK<A>
}

@JvmName("maybeCombine")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith("arg1?.plus(this)"),
  DeprecationLevel.WARNING
)
fun <A> SetK<A>.maybeCombine(arg1: SetK<A>): SetK<A> = arrow.core.SetK.semigroup<A>().run {
  this@maybeCombine.maybeCombine(arg1) as arrow.core.SetK<A>
}

@Suppress(
  "UNCHECKED_CAST",
  "NOTHING_TO_INLINE"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith(
    "Semigroup.set<A>()",
    "arrow.core.set",
    "arrow.typeclasses.Semigroup"
  ),
  DeprecationLevel.WARNING
)
inline fun <A> Companion.semigroup(): SetKSemigroup<A> = semigroup_singleton as
  arrow.core.extensions.SetKSemigroup<A>
