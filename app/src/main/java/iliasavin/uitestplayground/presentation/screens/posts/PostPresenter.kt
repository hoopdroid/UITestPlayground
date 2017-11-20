package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/15/17.
 */
interface PostPresenter {
  fun getPosts()
  fun attachView(view: BaseLCEView)
  fun detachView()
  fun openDetailsScreen(post: Post)
}
