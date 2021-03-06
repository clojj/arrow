package arrow.core.extensions.option.eqK

import arrow.Kind
import arrow.core.ForOption
import arrow.core.Option.Companion
import arrow.core.extensions.OptionEqK
import arrow.typeclasses.Eq
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.PublishedApi
import kotlin.Suppress
import kotlin.jvm.JvmName

/**
 * cached extension
 */
@PublishedApi()
internal val eqK_singleton: OptionEqK = object : arrow.core.extensions.OptionEqK {}

@JvmName("eqK")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith(
    "eqK(arg1, arg2)",
    "arrow.core.eqK"
  ),
  DeprecationLevel.WARNING
)
fun <A> Kind<ForOption, A>.eqK(arg1: Kind<ForOption, A>, arg2: Eq<A>): Boolean =
  arrow.core.Option.eqK().run {
    this@eqK.eqK<A>(arg1, arg2) as kotlin.Boolean
  }

@JvmName("liftEq")
@Suppress(
  "UNCHECKED_CAST",
  "USELESS_CAST",
  "EXTENSION_SHADOWED_BY_MEMBER",
  "UNUSED_PARAMETER"
)
@Deprecated(
  "@extension kinded projected functions are deprecated",
  ReplaceWith(
    "liftEq(arg0)",
    "arrow.core.Option.liftEq"
  ),
  DeprecationLevel.WARNING
)
fun <A> liftEq(arg0: Eq<A>): Eq<Kind<ForOption, A>> = arrow.core.Option
  .eqK()
  .liftEq<A>(arg0) as arrow.typeclasses.Eq<arrow.Kind<arrow.core.ForOption, A>>

@Suppress(
  "UNCHECKED_CAST",
  "NOTHING_TO_INLINE"
)
inline fun Companion.eqK(): OptionEqK = eqK_singleton
