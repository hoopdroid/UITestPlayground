package iliasavin.uitestplayground.domain.interactors

import iliasavin.uitestplayground.data.repository.PostsRepository
import io.reactivex.Single

class GetPosts(private val userRepository: PostsRepository) {

  fun execute(): Single<List<Any>>? {
    return null
  }
}
