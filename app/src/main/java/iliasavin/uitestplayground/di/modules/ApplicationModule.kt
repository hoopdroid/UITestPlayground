package iliasavin.uitestplayground.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.data.repository.PostsRepositoryImpl
import iliasavin.uitestplayground.di.UITestPlaygroundApp
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(val application: UITestPlaygroundApp) {
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
    fun provideAppContext() : Context = application

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl(BASE_URL)
            .build()

    @Provides
    @Singleton
    fun providePostsRepository(retrofit: Retrofit): PostsRepository {
        return PostsRepositoryImpl()
    }
}
