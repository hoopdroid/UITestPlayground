package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/14/17.
 */
interface PostsView : BaseLCEView {
  fun showPosts(posts: List<Post>)
}