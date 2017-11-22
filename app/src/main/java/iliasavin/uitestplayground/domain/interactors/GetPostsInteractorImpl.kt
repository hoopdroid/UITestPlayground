package iliasavin.uitestplayground.domain.interactors

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.data.repository.PostsRepository
import io.reactivex.Single

class GetPostsInteractorImpl(private val postsRepo: PostsRepository): GetPostsInteractor {

  override fun execute(): Single<List<Post>> {
    val postsList = postsRepo.getPosts()
    return postsList
  }
}
