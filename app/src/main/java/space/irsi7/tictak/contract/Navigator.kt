package space.irsi7.tictak.contract

import androidx.fragment.app.Fragment

fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun showFullScreenClock()

    fun showTableClock()

    fun goBack()

}