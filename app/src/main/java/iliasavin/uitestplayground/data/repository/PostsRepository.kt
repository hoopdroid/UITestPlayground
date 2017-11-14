package iliasavin.uitestplayground.data.repository

import iliasavin.uitestplayground.data.entities.Post
import io.reactivex.Single

/**
 * Created by ilyasavin on 11/14/17.
 */
interface PostsRepository {
  fun getPosts(): Single<List<Post>>
}
