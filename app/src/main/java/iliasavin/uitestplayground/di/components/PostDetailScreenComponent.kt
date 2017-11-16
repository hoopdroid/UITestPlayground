package iliasavin.uitestplayground.di.components

import dagger.Subcomponent
import iliasavin.uitestplayground.di.modules.PostDetailModule
import iliasavin.uitestplayground.presentation.screens.post_detail.PostDetailPresenterImpl

@Subcomponent(modules = arrayOf(PostDetailModule::class))
interface PostDetailScreenComponent {
  fun presenter(): PostDetailPresenterImpl
}
