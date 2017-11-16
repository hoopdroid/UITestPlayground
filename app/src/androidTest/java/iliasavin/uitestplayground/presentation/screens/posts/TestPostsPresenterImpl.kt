package iliasavin.uitestplayground.presentation.screens.posts

import android.app.Activity
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.base.BaseLCEView
import java.util.concurrent.CountDownLatch


/**
 * Created by ilyasavin on 11/14/17.
 */
class TestPostsPresenterImpl : PostPresenter {
  var view: PostsView? = null
  var lock: CountDownLatch? = null

  override fun attachView(view: BaseLCEView) {
    this.view = view as PostsView
  }

  override fun detachView() {
    view = null
  }

  override fun getPosts() {
    view?.showProgress()
    view?.showPosts(getFakePosts())
    view?.hideProgress()
  }

  override fun onItemClicked(screen: Activity, post: Post) {
    lock?.countDown()
  }

  private fun getFakePosts(): List<Post> {
    return (1..100).map {
      val number = it
      Post(number.toInt(), "Long post title header$number",
          "Very long long long long description of post $number", number.toInt())
    }
  }

}