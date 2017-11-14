package iliasavin.uitestplayground.di.components

import dagger.Subcomponent
import iliasavin.uitestplayground.di.modules.PostsModule
import iliasavin.uitestplayground.presentation.base.BaseLCEView
import iliasavin.uitestplayground.presentation.base.BasePresenter

@Subcomponent(modules = arrayOf(PostsModule::class))
interface PostsScreenComponent {
  fun presenter(): BasePresenter<BaseLCEView>
}
