package iliasavin.uitestplayground.util

import android.content.Context
import android.widget.Toast

/**
 * Created by ilyasavin on 11/14/17.
 */
class Extensions {
  fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }
}