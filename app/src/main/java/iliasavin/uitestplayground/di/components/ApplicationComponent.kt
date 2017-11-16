package iliasavin.uitestplayground.di.components

import dagger.Component
import iliasavin.uitestplayground.di.UITestPlaygroundApp
import iliasavin.uitestplayground.di.modules.ApplicationModule
import iliasavin.uitestplayground.di.modules.PostDetailModule
import iliasavin.uitestplayground.di.modules.PostsModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
  fun inject(application: UITestPlaygroundApp)
  fun plus(postsModule: PostsModule): PostsScreenComponent
  fun plus(postsModule: PostDetailModule): PostDetailScreenComponent
}
