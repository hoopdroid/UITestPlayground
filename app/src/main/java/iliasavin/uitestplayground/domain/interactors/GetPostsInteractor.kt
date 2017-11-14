package iliasavin.uitestplayground.domain.interactors

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.data.repository.PostsRepository
import io.reactivex.Single

class GetPostsInteractor(private val postsRepo: PostsRepository) {

  fun execute(): Single<List<Post>> {
    val postsList = postsRepo.getPosts()
    return postsList
  }
}
