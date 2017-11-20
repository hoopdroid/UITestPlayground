package iliasavin.uitestplayground.domain.interactors

import iliasavin.uitestplayground.data.entities.Post
import io.reactivex.Single

interface UpdatePostsInteractor {
  fun execute(): Single<List<Post>>
}
