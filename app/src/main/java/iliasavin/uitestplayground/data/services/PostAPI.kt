package iliasavin.uitestplayground.data.services

import iliasavin.uitestplayground.data.entities.Post
import io.reactivex.Single
import retrofit2.http.GET

interface PostAPI {
    @GET("/posts")
    fun getPosts() : Single<List<Post>>
}