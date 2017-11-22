package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import io.reactivex.Single

/**
 * Created by ilyasavin on 11/17/17.
 */
class MockGetPostsInteractor: GetPostsInteractor {
  override fun execute(): Single<List<Post>> {
    val postsList = ArrayList<Post>()
    return Single.just(postsList)
  }
}
