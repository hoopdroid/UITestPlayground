package iliasavin.uitestplayground.di.modules

import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.domain.interactors.GetPosts
import iliasavin.uitestplayground.presentation.base.BaseLCEView
import iliasavin.uitestplayground.presentation.base.BasePresenter

@Module
class PostsModule() {
  @Provides
  fun provideGetUsers(repo: PostsRepository) = GetPosts(repo)

  @Provides
  fun providePresenter(getUsers: GetPosts, schedulerProvider: SchedulerProvider)
      = BasePresenter<BaseLCEView>(getUsers, schedulerProvider)
}
