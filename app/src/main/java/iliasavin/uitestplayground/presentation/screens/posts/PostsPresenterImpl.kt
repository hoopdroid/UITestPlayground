package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import iliasavin.uitestplayground.presentation.base.BaseLCEView

/**
 * Created by ilyasavin on 11/14/17.
 */
class PostsPresenterImpl(
    private val getPostsInteractor: GetPostsInteractor) : PostPresenter {
  var view: PostsView? = null

  override fun attachView(view: BaseLCEView) {
    this.view = view as PostsView
  }

  override fun detachView() {
    view = null
  }

  override fun getPosts() {
    view?.showProgress()
    getPostsInteractor.execute().subscribe(
        { posts ->
          view?.showPosts(posts)
          view?.hideProgress()
        },
        { error ->
          view?.showError("no posts")
          view?.hideProgress()
        }
    )
  }

  override fun onItemClicked() {
    // Go to details screen
  }
}