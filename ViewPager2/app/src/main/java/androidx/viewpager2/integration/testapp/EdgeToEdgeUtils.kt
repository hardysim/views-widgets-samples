package androidx.viewpager2.integration.testapp

import android.content.res.Configuration
import android.view.View
import android.view.ViewGroup
import androidx.core.view.*

fun View.addSystemWindowInsetToPadding(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false
) {
    val (initialLeft, initialTop, initialRight, initialBottom) =
        listOf(paddingLeft, paddingTop, paddingRight, paddingBottom)

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        view.updatePadding(
            left = initialLeft + (if (left) insets.systemWindowInsetLeft else 0),
            top = initialTop + (if (top) insets.systemWindowInsetTop else 0),
            right = initialRight + (if (right) insets.systemWindowInsetRight else 0),
            bottom = initialBottom + (if (bottom) insets.systemWindowInsetBottom else 0)
        )

        insets
    }
}

fun View.addSystemWindowInsetToMargin(
    left: Boolean = false,
    top: Boolean = false,
    right: Boolean = false,
    bottom: Boolean = false
) {
    val (initialLeft, initialTop, initialRight, initialBottom) =
        listOf(marginLeft, marginTop, marginRight, marginBottom)

    ViewCompat.setOnApplyWindowInsetsListener(this) { view, insets ->
        view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
            leftMargin = initialLeft + (if (left) insets.systemWindowInsetLeft else 0)
            topMargin = initialTop + (if (top) insets.systemWindowInsetTop else 0)
            rightMargin = initialRight + (if (right) insets.systemWindowInsetRight else 0)
            bottomMargin = initialBottom + (if (bottom) insets.systemWindowInsetBottom else 0)
        }

        insets
    }
}

fun View.goEdgeToEdge() {
    if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
        systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}
