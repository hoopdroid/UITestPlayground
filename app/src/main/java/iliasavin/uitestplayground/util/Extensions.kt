package iliasavin.uitestplayground.util

import android.app.Activity
import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import iliasavin.uitestplayground.di.UITestPlaygroundApp

/**
 * Created by ilyasavin on 11/14/17.
 */
fun Context.showToast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Context.showSnackBar(coordinatorLayout: CoordinatorLayout, message: String) {
  Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show()
}

fun View.setVisibility(isVisible: Boolean) {
  if (isVisible) {
    this.visibility = View.VISIBLE
    return
  }
  this.visibility = View.GONE
}

val Activity.customApplication: UITestPlaygroundApp
  get() = application as UITestPlaygroundApp
