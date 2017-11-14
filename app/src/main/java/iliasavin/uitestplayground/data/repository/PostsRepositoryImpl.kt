package iliasavin.uitestplayground.data.repository

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.data.services.PostAPI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by ilyasavin on 11/14/17.
 */
class PostsRepositoryImpl(private val postsService: PostAPI) : PostsRepository {
  override fun getPosts(): Single<List<Post>> {
    return postsService.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map { it }
  }
}

