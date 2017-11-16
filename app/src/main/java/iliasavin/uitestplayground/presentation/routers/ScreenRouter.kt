package iliasavin.uitestplayground.presentation.routers

import android.app.Activity
import android.content.Intent
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.screens.post_detail.PostDetailActivity

/**
 * Created by ilyasavin on 11/16/17.
 */
class ScreenRouter {
  // TODO Add router as DI
  fun openPostDetailsScreen(screen: Activity, post: Post){
    val intent = Intent(screen, PostDetailActivity::class.java)
    intent.putExtra("post", post)
    screen.startActivity(intent)
  }
}
