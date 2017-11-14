package iliasavin.uitestplayground.di.modules

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import iliasavin.uitestplayground.BuildConfig
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.data.repository.PostsRepositoryImpl
import iliasavin.uitestplayground.data.services.PostAPI
import iliasavin.uitestplayground.di.UITestPlaygroundApp
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.NANOSECONDS
import javax.inject.Singleton

private const val DEFAULT_CONNECT_TIMEOUT = 60000L
@Module
class ApplicationModule(val application: UITestPlaygroundApp) {
  private val HTTP_LOG_LEVEL: HttpLoggingInterceptor.Level = if (BuildConfig.DEBUG) BODY else BASIC
  private val BASE_URL = "https://jsonplaceholder.typicode.com/"

  @Provides
  @Singleton
  fun provideAppContext(): Context = application

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(DEFAULT_CONNECT_TIMEOUT, MILLISECONDS)
        .retryOnConnectionFailure(true)
        .readTimeout(DEFAULT_CONNECT_TIMEOUT, MILLISECONDS)
        .connectionPool(ConnectionPool(0, 1, NANOSECONDS))
        .writeTimeout(DEFAULT_CONNECT_TIMEOUT, MILLISECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply { level = HTTP_LOG_LEVEL })
        .build()
  }

  @Provides
  @Singleton
  fun providePostsRepository(httpClient: OkHttpClient,
     gson: Gson): PostsRepository {
    val retrofit = createRetrofit(httpClient, gson, BASE_URL)
    val api = retrofit.create(PostAPI::class.java)

    return PostsRepositoryImpl(api)
  }

  private fun createRetrofit(httpClient: OkHttpClient, gson: Gson, baseUrl: String): Retrofit {
    return Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(httpClient)
        .baseUrl(baseUrl)
        .build()
  }
}
