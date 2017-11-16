package iliasavin.uitestplayground.presentation.screens.post_detail

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/15/17.
 */
interface PostDetailPresenter {
  fun setPostInfo(post: Post)
  fun updatePostInfo()
  fun attachView(view: BaseLCEView)
  fun detachView()
  fun onTitleChanged()
  fun onDescriptionChanged()
}
