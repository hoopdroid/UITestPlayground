package iliasavin.uitestplayground.util

import android.content.Context
import android.view.View
import android.widget.Toast

/**
 * Created by ilyasavin on 11/14/17.
 */
fun Context.showToast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun View.setVisibility(isVisible: Boolean) {
  if (isVisible) {
    this.visibility = View.VISIBLE
    return
  }
  this.visibility = View.GONE
}
