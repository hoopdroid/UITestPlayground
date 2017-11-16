package iliasavin.uitestplayground.presentation.screens.posts

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iliasavin.uitestplayground.R
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.di.modules.PostsModule
import iliasavin.uitestplayground.presentation.base.BaseRecyclerAdapter
import iliasavin.uitestplayground.util.customApplication
import iliasavin.uitestplayground.util.setVisibility
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.activity_posts.postsView
import kotlinx.android.synthetic.main.activity_posts.progressBar
import kotlinx.android.synthetic.main.post_item.view.body
import kotlinx.android.synthetic.main.post_item.view.title

class PostsActivity : AppCompatActivity(), PostsView {
  lateinit var presenter : PostPresenter
  val component by lazy { customApplication.component.plus(PostsModule()) }
  val adapter by lazy { PostsAdapter() }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    presenter = component.presenter()
    setContentView(R.layout.activity_posts)
  }

  override fun onStart() {
    super.onStart()
    presenter.attachView(this)
    presenter.getPosts()
  }

  override fun showProgress() {
    postsView.setVisibility(false)
    progressBar.setVisibility(true)
  }

  override fun hideProgress() {
    postsView.setVisibility(true)
    progressBar.setVisibility(false)
  }

  override fun showError(message: String) {
  }

  override fun showPosts(posts: List<Post>) {
    adapter.setData(posts)
    adapter.onItemSelectAction.subscribe { post -> presenter.onItemClicked(this, post) }
    postsView.adapter = adapter
  }

  override fun onDestroy() {
    super.onDestroy()
    presenter.detachView()
  }
}

class PostsAdapter : BaseRecyclerAdapter<Post>() {
  var onItemSelectAction: PublishSubject<Post> = PublishSubject.create()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Post> {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
    return ViewHolder(view)
  }

  private inner class ViewHolder(itemView: View) : BaseViewHolder<Post>(itemView) {


    override fun setItem(item: Post, position: Int) {
      itemView.title.text = item.title
      itemView.body.text = item.body
      itemView.setOnClickListener { onItemSelectAction.onNext(getItemAt(position)) }
    }
  }
}
