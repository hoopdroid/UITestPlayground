package iliasavin.uitestplayground.presentation.screens.posts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import iliasavin.uitestplayground.R
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.di.UITestPlaygroundApp
import iliasavin.uitestplayground.di.modules.PostsModule

class PostsActivity : AppCompatActivity(), PostsView {
  private val presenter: PostsPresenter by lazy { component.presenter() }
  private val component by lazy { UITestPlaygroundApp.component.plus(PostsModule()) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_posts)
    presenter.attachView(this)
    presenter.getPosts()
  }

  override fun showProgress() {
  }

  override fun hideProgress() {
  }

  override fun showError(message: String) {
  }

  override fun showPosts(posts: List<Post>) {
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}
