package com.example.fluentincompose.controls

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fluentincompose.ui.theme.ColorConstants
import com.example.fluentincompose.ui.theme.FluentTheme
import com.example.fluentincompose.ui.theme.contentColorFor

@Composable
fun FluentButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(2.dp),
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable RowScope.() -> Unit
) {

    val contentPadding = PaddingValues(16.dp, 8.5.dp)
    val textStyle = FluentTheme.typography.body2

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        colors = colors
    ) {

        ProvideTextStyle(value = textStyle) {
            content()
        }
    }

}

@Composable
fun FluentOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(2.dp),
    border: BorderStroke? = ButtonDefaults.outlinedBorderButtonEnabled,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    content: @Composable RowScope.() -> Unit
) {
    val contentPadding = PaddingValues(16.dp, 8.5.dp)
    val textStyle = FluentTheme.typography.body2

    if(enabled)
    {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            shape = shape,
            border = border,
            contentPadding = contentPadding,
            colors = colors
        ) {

            ProvideTextStyle(value = textStyle) {
                content()
            }
        }
    }

    else
    {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            interactionSource = interactionSource,
            shape = shape,
            border = ButtonDefaults.outlinedBorderButtonDisabled,
            contentPadding = contentPadding,
            colors = colors
        ) {

            ProvideTextStyle(value = textStyle) {
                content()
            }
        }
    }

}

@Composable
fun FluentTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(2.dp),
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    content: @Composable RowScope.() -> Unit
) {
    val contentPadding = PaddingValues(8.dp, 8.5.dp)
    val textStyle = FluentTheme.typography.body2

    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        contentPadding = contentPadding,
        colors = colors
    ) {

        ProvideTextStyle(value = textStyle) {
            content()
        }
    }
}

@Composable
fun FluentButtonLarge(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = RoundedCornerShape(2.dp),
    border: BorderStroke? = null,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    content: @Composable RowScope.() -> Unit
) {

    val contentPadding = PaddingValues(8.dp, 16.dp)
    val textStyle = FluentTheme.typography.body2

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        interactionSource = interactionSource,
        shape = shape,
        border = border,
        contentPadding = contentPadding,
        colors = colors
    ) {

        ProvideTextStyle(value = textStyle) {
            content()
        }
    }

}

object ButtonDefaults {

    @Composable
    fun buttonColors(
        backgroundColor: Color = FluentTheme.colors.accent,
        contentColor: Color = contentColorFor(backgroundColor),
        disabledBackgroundColor: Color = ColorConstants.Grey50,
        disabledContentColor: Color = ColorConstants.Grey300,//MaterialTheme.colors.onSurface
        //.copy(alpha = ContentAlpha.disabled)
    ): ButtonColors = DefaultButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = disabledBackgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun outlinedButtonColors(
        backgroundColor: Color = Color.Transparent,
        contentColor: Color = FluentTheme.colors.accent,
        disabledContentColor: Color = ColorConstants.Grey300
    ): ButtonColors = DefaultButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = backgroundColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun textButtonColors(
        backgroundColor: Color = Color.Transparent,
        contentColor: Color = FluentTheme.colors.accent,
        disabledContentColor: Color = ColorConstants.Grey300
    ): ButtonColors = DefaultButtonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = backgroundColor,
        disabledContentColor = disabledContentColor
    )

    val OutlinedBorderSize = 1.dp

    val outlinedBorderButtonEnabled: BorderStroke
        @Composable
        get() = BorderStroke(OutlinedBorderSize, FluentTheme.colors.accent)

    val outlinedBorderButtonDisabled: BorderStroke
        @Composable
        get() = BorderStroke(OutlinedBorderSize, ColorConstants.Grey50)

}

@Immutable
private data class DefaultButtonColors(
    private val backgroundColor: Color,
    private val contentColor: Color,
    private val disabledBackgroundColor: Color,
    private val disabledContentColor: Color
) : ButtonColors {
    @Composable
    override fun backgroundColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) backgroundColor else disabledBackgroundColor)
    }

    @Composable
    override fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }
}
