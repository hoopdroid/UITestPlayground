package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.UpdatePostInteractor
import iliasavin.uitestplayground.presentation.screens.post_detail.PostDetailPresenterImpl

@Module
class PostDetailModule() {
  @Provides
  fun provideUpdatePosts(repo: PostsRepository) = UpdatePostInteractor(repo)

  @Provides
  fun providePresenter(updatePostInteractor: UpdatePostInteractor)
      = PostDetailPresenterImpl(updatePostInteractor)
}
