package com.example.fluentincompose.ui.theme
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Immutable
data class Typography internal constructor(
        val headline: TextStyle,
        val title1: TextStyle,
        val title2: TextStyle,
        val heading: TextStyle,
        val subheading1: TextStyle,
        val subheading2: TextStyle,
        val body1: TextStyle,
        val body2: TextStyle,
        val caption: TextStyle,
) {
        constructor(
                defaultFontFamily: FontFamily = FontFamily.Default,
                headline: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 28.sp,
                        lineHeight = 33.sp,
                ),
                title1: TextStyle = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                ),
                title2: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 20.sp,
                        lineHeight = 24.sp,
                ),
                heading: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 18.sp,
                        lineHeight = 24.sp,
                ),
                subheading1: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                ),
                subheading2: TextStyle = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                ),
                body1: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                ),
                body2: TextStyle = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        lineHeight = 16.sp,
                ),
                caption: TextStyle = TextStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                ),
        ) : this(
                headline = headline.withDefaultFontFamily(defaultFontFamily),
                title1 = title1.withDefaultFontFamily(defaultFontFamily),
                title2 = title2.withDefaultFontFamily(defaultFontFamily),
                heading = heading.withDefaultFontFamily(defaultFontFamily),
                subheading1 = subheading1.withDefaultFontFamily(defaultFontFamily),
                subheading2 = subheading2.withDefaultFontFamily(defaultFontFamily),
                body1 = body1.withDefaultFontFamily(defaultFontFamily),
                body2 = body2.withDefaultFontFamily(defaultFontFamily),
                caption = caption.withDefaultFontFamily(defaultFontFamily)
        )
}

private fun TextStyle.withDefaultFontFamily(default: FontFamily): TextStyle {
        return if (fontFamily != null) this else copy(fontFamily = default)
}

internal val LocalTypography = staticCompositionLocalOf { Typography() }