package iliasavin.uitestplayground.presentation.screens.post_detail

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/14/17.
 */
interface PostsDetailView : BaseLCEView {
  fun showPostInfo(post: Post?)
}
