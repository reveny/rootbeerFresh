package com.kimchangyoun.rootbeerFresh.sample.ui

import android.content.Context
import android.util.AttributeSet
import com.kimchangyoun.rootbeerFresh.sample.R

class ResultIconView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatImageView(context, attrs, defStyleAttr) {

    private fun showPass() = setImageResource(R.drawable.ic_check_circle_green_24dp)

    private fun showFail() = setImageResource(R.drawable.ic_error_circle_outline_red_24dp)

    fun update(isRooted: Boolean) {
        if (isRooted) {
            showFail()
        } else {
            showPass()
        }
    }
}
