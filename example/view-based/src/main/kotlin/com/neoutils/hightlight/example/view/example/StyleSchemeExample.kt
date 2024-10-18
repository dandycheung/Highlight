package com.neoutils.hightlight.example.view.example

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.neoutils.highlight.core.ktx.highlight
import com.neoutils.highlight.core.utils.UiStyle
import com.neoutils.highlight.view.extension.toSpannedString

class StyleSchemeExample(
    content: Context,
    attr: AttributeSet? = null,
) : AppCompatTextView(
    content,
    attr
) {

    init {
        text = highlight {
            textStyle {
                fully(
                    regex = "style",
                    value = UiStyle(UiStyle.Style.BOLD)
                )
            }
        }.toSpannedString(
            text = "Example of style."
        )
    }
}
