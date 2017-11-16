package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView
import iliasavin.uitestplayground.presentation.screens.post_detail.PostDetailPresenter
import iliasavin.uitestplayground.presentation.screens.post_detail.PostsDetailView
import java.util.concurrent.CountDownLatch


/**
 * Created by ilyasavin on 11/14/17.
 */
class TestPostDetailPresenterImpl : PostDetailPresenter {
  var view: PostsDetailView? = null
  var lock: CountDownLatch? = null
  var post: Post? = null

  override fun attachView(view: BaseLCEView) {
    this.view = view as PostsDetailView
  }

  override fun detachView() {
    view = null
  }

  override fun setPostInfo(post: Post?) {
    this.post = getFakePost()
    view?.showPostInfo(post)
  }

  override fun updatePostInfo() {
    lock?.countDown()
  }

  override fun onTitleChanged() {
  }

  override fun onDescriptionChanged() {
  }

  private fun getFakePost(): Post {
    return Post(0, "Long post title header",
        "Very long long long long description of post", 0)


  }
}