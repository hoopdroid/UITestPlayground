package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import iliasavin.uitestplayground.presentation.screens.posts.PostsPresenter

@Module
class PostsModule() {
  @Provides
  fun provideGetPosts(repo: PostsRepository) = GetPostsInteractor(repo)

  @Provides
  fun providePresenter(getPostsInteractor: GetPostsInteractor)
      = PostsPresenter(getPostsInteractor)
}
