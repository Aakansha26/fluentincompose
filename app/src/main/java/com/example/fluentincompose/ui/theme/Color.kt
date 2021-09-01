package com.example.fluentincompose.ui.theme

import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse

class Colors(
    accent: Color,
    onAccent: Color,
    background: Color,
    surfacePrimary: Color,
    surfaceSecondary: Color,
    textPrimary: Color,
    textSecondary: Color,
    dividerOnPrimary: Color,
    dividerOnSecondary: Color,
    error: Color,
    isLight: Boolean
) {
    var accent by mutableStateOf(accent, structuralEqualityPolicy())
        internal set
    var onAccent by mutableStateOf(onAccent, structuralEqualityPolicy())
        internal set
    var background by mutableStateOf(background, structuralEqualityPolicy())
        internal set
    var surfacePrimary by mutableStateOf(surfacePrimary, structuralEqualityPolicy())
        internal set
    var surfaceSecondary by mutableStateOf(surfaceSecondary, structuralEqualityPolicy())
        internal set
    var textPrimary by mutableStateOf(textPrimary, structuralEqualityPolicy())
        internal set
    var textSecondary by mutableStateOf(textSecondary, structuralEqualityPolicy())
        internal set
    var dividerOnPrimary by mutableStateOf(dividerOnPrimary, structuralEqualityPolicy())
        internal set
    var dividerOnSecondary by mutableStateOf(dividerOnSecondary, structuralEqualityPolicy())
        internal set
    var error by mutableStateOf(error, structuralEqualityPolicy())
        internal set
    var isLight by mutableStateOf(isLight, structuralEqualityPolicy())
        internal set

    /**
     * Returns a copy of this Colors, optionally overriding some of the values.
     */
    fun copy(
        accent: Color = this.accent,
        onAccent: Color = this.onAccent,
        background: Color = this.background,
        surfacePrimary: Color = this.surfacePrimary,
        surfaceSecondary: Color = this.surfaceSecondary,
        textPrimary: Color = this.textPrimary,
        textSecondary: Color = this.textSecondary,
        dividerOnPrimary: Color = this.dividerOnPrimary,
        dividerOnSecondary: Color = this.dividerOnSecondary,
        error: Color = this.error,
        isLight: Boolean = this.isLight
    ): Colors = Colors(
        accent,
        onAccent,
        background,
        surfacePrimary,
        surfaceSecondary,
        textPrimary,
        textSecondary,
        dividerOnPrimary,
        dividerOnSecondary,
        error,
        isLight
    )

    override fun toString(): String {
        return "Colors(" +
                "accent=$accent, " +
                "onAccent=$onAccent, " +
                "background=$background, " +
                "surfacePrimary=$surfacePrimary, " +
                "surfaceSecondary=$surfaceSecondary, " +
                "textPrimary=$textPrimary, " +
                "textSecondary=$textSecondary, " +
                "dividerOnPrimary=$dividerOnPrimary, " +
                "dividerOnSecondary=$dividerOnSecondary, " +
                "error=$error, " +
                "isLight=$isLight" +
                ")"
    }
}

val Colors.surfaceAccent: Color get() = if (isLight) accent else surfaceSecondary

fun Colors.contentColorFor(backgroundColor: Color): Color {
    return when (backgroundColor) {
        accent -> onAccent
        background -> textPrimary
        else -> Color.Unspecified
    }
}

@Composable
@ReadOnlyComposable
fun contentColorFor(backgroundColor: Color) =
    FluentTheme.colors.contentColorFor(backgroundColor).takeOrElse { LocalContentColor.current }

internal object ColorConstants {

    // Neutral

    val Black = Color(0xFF000000)
    val Grey950 = Color(0xFF141414)
    val Grey900 = Color(0xFF212121)
    val Grey800 = Color(0xFF292929)
    val Grey700 = Color(0xFF303030)
    val Grey600 = Color(0xFF404040)
    val Grey500 = Color(0xFF6E6E6E)
    val Grey400 = Color(0xFF919191)
    val Grey300 = Color(0xFFACACAC)
    val Grey200 = Color(0xFFC8C8C8)
    val Grey100 = Color(0xFFE1E1E1)
    val Grey50 = Color(0xFFF1F1F1)
    val Grey25 = Color(0xFFF8F8F8)
    val White = Color(0xFFFFFFFF)


    // Communication blue

    val ComShade30Light = Color(0xFF004578)
    val ComShade20Light = Color(0xFF005A9E)
    val ComShade10Light = Color(0xFF106EBE)
    val ComPrimaryLight = Color(0xFF0078D4)
    val ComTint10Light = Color(0xFF2B88D8)
    val ComTint20Light = Color(0xFFC7E0F4)
    val ComTint30Light = Color(0xFFDEECF9)
    val ComTint40Light = Color(0xFFEFF6FC)

    val ComShade30Dark = Color(0xFF004578)
    val ComShade20Dark = Color(0xFF005A9E)
    val ComShade10Dark = Color(0xFF106EBE)
    val ComPrimaryDark = Color(0xFF0086F0)
    val ComTint10Dark = Color(0xFF2B88D8)
    val ComTint20Dark = Color(0xFFC7E0F4)
    val ComTint30Dark = Color(0xFFDEECF9)
    val ComTint40Dark = Color(0xFFEFF6FC)
    val ColorStream = Color(0xFFC30052)
    // Danger

    val DangerPrimaryLight = Color(0xFFD92C2C)

    val DangerPrimaryDark = Color(0xFFE83A3A)
}

fun lightColors(
    accent: Color = ColorConstants.ColorStream,
    onAccent: Color = ColorConstants.White,
    background: Color = ColorConstants.White,
    surfacePrimary: Color = ColorConstants.White,
    surfaceSecondary: Color = ColorConstants.Grey25,
    textPrimary: Color = ColorConstants.Grey900,
    textSecondary: Color = ColorConstants.Grey500,
    dividerOnPrimary: Color = ColorConstants.Grey100,
    dividerOnSecondary: Color = ColorConstants.Grey200,
    error: Color = ColorConstants.DangerPrimaryLight
): Colors = Colors(
    accent,
    onAccent,
    background,
    surfacePrimary,
    surfaceSecondary,
    textPrimary,
    textSecondary,
    dividerOnPrimary,
    dividerOnSecondary,
    error,
    true
)

fun darkColors(
    accent: Color = ColorConstants.ComPrimaryDark,
    onAccent: Color = ColorConstants.White,
    background: Color = ColorConstants.Black,
    surfacePrimary: Color = ColorConstants.Grey950,
    surfaceSecondary: Color = ColorConstants.Grey900,
    textPrimary: Color = ColorConstants.Grey100,
    textSecondary: Color = ColorConstants.Grey400,
    dividerOnPrimary: Color = ColorConstants.Grey800,
    dividerOnSecondary: Color = ColorConstants.Grey700,
    error: Color = ColorConstants.DangerPrimaryDark
): Colors = Colors(
    accent,
    onAccent,
    background,
    surfacePrimary,
    surfaceSecondary,
    textPrimary,
    textSecondary,
    dividerOnPrimary,
    dividerOnSecondary,
    error,
    false
)

internal fun Colors.updateColorsFrom(other: Colors) {
    accent = other.accent
    onAccent = other.onAccent
    background = other.background
    surfacePrimary = other.surfacePrimary
    surfaceSecondary = other.surfaceSecondary
    textPrimary = other.textPrimary
    textSecondary = other.textSecondary
    dividerOnPrimary = other.dividerOnPrimary
    dividerOnSecondary = other.dividerOnSecondary
    error = other.error
    isLight = other.isLight
}

internal val LocalColors = staticCompositionLocalOf { lightColors() }