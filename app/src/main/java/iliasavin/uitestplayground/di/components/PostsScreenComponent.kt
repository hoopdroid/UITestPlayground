package iliasavin.uitestplayground.di.components

import dagger.Subcomponent
import iliasavin.uitestplayground.di.modules.PostsModule
import iliasavin.uitestplayground.presentation.screens.posts.PostsPresenter

@Subcomponent(modules = arrayOf(PostsModule::class))
interface PostsScreenComponent {
  fun presenter(): PostsPresenter
}
