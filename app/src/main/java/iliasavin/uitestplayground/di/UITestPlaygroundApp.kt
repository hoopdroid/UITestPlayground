package iliasavin.uitestplayground.di

import android.app.Application
import iliasavin.uitestplayground.di.components.ApplicationComponent
import iliasavin.uitestplayground.di.components.DaggerApplicationComponent
import iliasavin.uitestplayground.di.modules.ApplicationModule

/**
 * Created by ilyasavin on 11/14/17.
 */
class UITestPlaygroundApp : Application() {

  override fun onCreate() {
    super.onCreate()

    initAppComponent()

    component.inject(this)
  }

  private fun initAppComponent() {
    component = DaggerApplicationComponent
        .builder()
        .applicationModule(ApplicationModule(this))
        .build()
  }

  companion object {
    lateinit var component: ApplicationComponent
  }
}