package com.example.simpleapp.util

import android.content.Context
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

var toast: Toast? = null


/** Shows a toast in the receiving context, cancelling any previous. */
fun Context.toast(message: Int) {
    toast?.cancel()
    toast = Toast.makeText(this, message, LENGTH_LONG)
        .apply {
            show()
        }
}

/** Shows a toast in the receiving context, cancelling any previous. */
fun Context.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(this, message, LENGTH_LONG)
        .apply {
            show()
        }
}


/** Shows a toast in the receiving context, cancelling any previous. */
fun Fragment.toast(message: Int) {
    toast?.cancel()
    toast = Toast.makeText(context, message, LENGTH_LONG)
        .apply {
            show()
        }
}

/** Shows a toast in the receiving context, cancelling any previous. */
fun Fragment.toast(message: String) {
    toast?.cancel()
    toast = Toast.makeText(context, message, LENGTH_LONG)
        .apply {
            show()
        }
}

