package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.UpdatePostInteractorImpl
import iliasavin.uitestplayground.presentation.screens.post_detail.PostDetailPresenterImpl

@Module
class PostDetailModule() {
  @Provides
  fun provideUpdatePosts(repo: PostsRepository) = UpdatePostInteractorImpl(repo)

  @Provides
  fun providePresenter(updatePostInteractor: UpdatePostInteractorImpl)
      = PostDetailPresenterImpl(updatePostInteractor)
}
