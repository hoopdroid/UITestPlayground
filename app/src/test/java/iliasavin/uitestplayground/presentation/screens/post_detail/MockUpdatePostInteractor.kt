package iliasavin.uitestplayground.presentation.screens.post_detail

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.domain.interactors.UpdatePostsInteractor
import io.reactivex.Single

class MockUpdatePostInteractor() : UpdatePostsInteractor {

  override fun execute(): Single<List<Post>> {
    return Single.just(ArrayList<Post>())
  }
}
