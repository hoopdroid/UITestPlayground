package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import iliasavin.uitestplayground.presentation.base.BasePresenter

/**
 * Created by ilyasavin on 11/14/17.
 */
class PostsPresenter(private val getPostsInteractor: GetPostsInteractor): BasePresenter<PostsView>(){

  fun getPosts(){
    getPostsInteractor.execute().subscribe(
        { posts ->
          view?.showPosts(posts)
        },
        { error ->
          view?.showError("no posts")
        }
    )
  }

}