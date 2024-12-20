package com.neoutils.highlight.core.scope

import com.neoutils.highlight.core.util.Match
import com.neoutils.highlight.core.scheme.BackgroundColorScheme
import com.neoutils.highlight.core.util.UiColor

class BackgroundColorScope internal constructor() :
    SchemeScope<UiColor, BackgroundColorScheme>() {

    override fun match(
        regex: Regex,
        match: Match<UiColor>
    ) {
        builder.add(
            BackgroundColorScheme(
                regex,
                match
            )
        )
    }
}