package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import javax.inject.Singleton

@Module
class FakeApplicationModule(val postsRepository: PostsRepository) {

    @Provides
    @Singleton
    fun providePostsRepository() : PostsRepository {
        return postsRepository
    }
}