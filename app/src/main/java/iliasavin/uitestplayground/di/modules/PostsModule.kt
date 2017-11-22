package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.GetPostsInteractorImpl
import iliasavin.uitestplayground.presentation.screens.posts.PostsPresenterImpl

@Module
class PostsModule() {
  @Provides
  fun provideGetPosts(repo: PostsRepository) = GetPostsInteractorImpl(repo)

  @Provides
  fun providePresenter(getPostsInteractor: GetPostsInteractorImpl)
      = PostsPresenterImpl(getPostsInteractor)
}
