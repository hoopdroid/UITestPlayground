package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.GetPostsInteractor
import iliasavin.uitestplayground.presentation.base.BaseLCEView
import iliasavin.uitestplayground.presentation.base.BasePresenter

@Module
class PostsModule() {
  @Provides
  fun provideGetPosts(repo: PostsRepository) = GetPostsInteractor(repo)

  @Provides
  fun providePresenter(getPostsInteractor: GetPostsInteractor)
      = BasePresenter<BaseLCEView>(getPostsInteractor)
}
