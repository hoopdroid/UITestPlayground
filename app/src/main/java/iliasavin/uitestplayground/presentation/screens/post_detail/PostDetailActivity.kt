package iliasavin.uitestplayground.presentation.screens.post_detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import iliasavin.uitestplayground.R
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.di.modules.PostDetailModule
import iliasavin.uitestplayground.util.customApplication
import iliasavin.uitestplayground.util.showToast
import kotlinx.android.synthetic.main.activity_post.postDescription
import kotlinx.android.synthetic.main.activity_post.postTitle
import kotlinx.android.synthetic.main.activity_post.updateButton

class PostDetailActivity : AppCompatActivity(), PostsDetailView {
  lateinit var presenter : PostDetailPresenter
  val component by lazy { customApplication.component.plus(PostDetailModule()) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = component.presenter()
    setContentView(R.layout.activity_post)
  }

  override fun onStart() {
    super.onStart()
    presenter.attachView(this)
    presenter.setPostInfo(intent.getParcelableExtra<Post>("post"))
  }

  override fun showProgress() {
  }

  override fun hideProgress() {
  }

  override fun showError(message: String) {
  }

  override fun showPostInfo(post: Post) {
    postTitle.setText(post.title)
    postDescription.setText(post.body)
    showToast("${post.title}  ${post.body}")
    updateButton.setOnClickListener { presenter.updatePostInfo() }
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}
