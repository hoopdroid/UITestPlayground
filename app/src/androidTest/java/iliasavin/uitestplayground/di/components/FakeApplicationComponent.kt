package iliasavin.uitestplayground.di.components

import dagger.Component
import iliasavin.uitestplayground.di.modules.FakeApplicationModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(FakeApplicationModule::class))
interface FakeApplicationComponent : ApplicationComponent