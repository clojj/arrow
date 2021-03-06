---
layout: docs-core
title: Profunctor
permalink: /arrow/typeclasses/profunctor/
---

## Profunctor




Before reading this typeclass, we recommend that you understand [Contravariance](https://typeclasses.com/contravariance) first. But, for making things easier, we will consider `Contravariance` as the ability to _flip composition_.

`Profunctors` are [`Bifunctors`]({{ '/arrow/typeclasses/bifunctor' | relative_url }}) that are contravariant in their first argument and covariant in the second one.

The core operation of the `Profunctor` typeclass is `dimap` (as `bimap` was already taken for `Bifunctor`).

`fun <A, B, C, D> Kind2<F, A, B>.dimap(fl: (C) -> A, fr: (B) -> D): Kind2<F, C, D>`

The main difference between `bimap` and `dimap` is the function they accept as their first argument:

* `bimap`: `fl: (A) -> C`
* `dimap`: `fl: (C) -> A`

And how does this work? Well, if we think in terms of function composition, functions can be composed in both directions:

```kotlin:ank
import arrow.core.*

val sum2: (Int) -> Int = { x -> x + 2 }
val str: (Int) -> String = { x -> x.toString() }

val f = str compose sum2
val g = sum2 andThen str
f(4) == g(4)
```

So, if we have a function `(A) -> B` and a `Profunctor` instance for it, we can make the following transformation with `dimap`: `((C) -> A) -> ((A) -> B) -> ((B) -> D)`.

### Main Combinators

#### Kind2<F, A, B>#bimap

Contramap on the first type parameter and map on the second type parameter.

`fun Kind2<F, A, B>.dimap(fl: (C) -> A, fr: (B) -> D): Kind2<F, C, D>`

#### Other combinators

For a full list of other useful combinators available in `Profunctor`, see the [Source][profunctor_source]{:target="_blank"}

### Laws

Arrow provides [`ProfunctorLaws`][profunctor_laws_source]{:target="_blank"} in the form of test cases for internal verification of lawful instances and third party apps creating their own Profunctor instances.

[profunctor_source]: https://github.com/arrow-kt/arrow/blob/master/arrow-libs/core/arrow-core-data/src/main/kotlin/arrow/typeclasses/Profunctor.kt
[profunctor_laws_source]: https://github.com/arrow-kt/arrow/blob/master/arrow-libs/core/arrow-core-test/src/main/kotlin/arrow/core/test/laws/ProfunctorLaws.kt
