package iliasavin.uitestplayground.presentation.screens.post_detail

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.domain.interactors.UpdatePostsInteractor
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/14/17.
 */
class PostDetailPresenterImpl(
    private val updatePostInteractor: UpdatePostsInteractor) : PostDetailPresenter {
  var view: PostsDetailView? = null
  var post: Post? = null

  override fun attachView(view: BaseLCEView) {
    this.view = view as PostsDetailView
  }

  override fun detachView() {
    view = null
  }

  override fun setPostInfo(post: Post?) {
    renderPostInfo(post)
  }

  override fun updatePostInfo() {
    renderPostInfo(post!!)
  }

  private fun renderPostInfo(post: Post?) {
    view?.showProgress()
    this.post = post
    if (post != null) view?.showPostInfo(post)
    view?.hideProgress()
  }

}
