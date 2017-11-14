package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import iliasavin.uitestplayground.presentation.base.BasePresenter

/**
 * Created by ilyasavin on 11/14/17.
 */
class PostsPresenter(private val getPostsInteractor: GetPostsInteractor): BasePresenter<PostsView>(){

  fun getPosts(){
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

}