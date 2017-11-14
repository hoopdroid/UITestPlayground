package iliasavin.uitestplayground

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.data.repository.PostsRepository
import iliasavin.uitestplayground.di.UITestPlaygroundApp
import iliasavin.uitestplayground.di.components.DaggerFakeApplicationComponent
import iliasavin.uitestplayground.di.modules.FakeApplicationModule
import iliasavin.uitestplayground.presentation.screens.posts.PostsActivity
import io.reactivex.Single
import io.reactivex.SingleEmitter
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by ilyasavin on 11/14/17.
 */
@RunWith(AndroidJUnit4::class)
class PostsActvityTest {

  @Rule
  @JvmField
  var activityRule = ActivityTestRule(PostsActivity::class.java, true, false)

  private lateinit var mockRepository: PostsRepository

  private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
    return RecyclerViewMatcher(recyclerViewId)
  }

  @Before
  fun setUp() {
    mockRepository = mock()

    val instrumentation = InstrumentationRegistry.getInstrumentation()
    val app = instrumentation.targetContext.applicationContext as UITestPlaygroundApp

    val testComponent = DaggerFakeApplicationComponent.builder()
        .fakeApplicationModule(FakeApplicationModule(mockRepository))
        .build()
    app.component = testComponent
  }

  @Test
  fun testRecyclerViewShowingCorrectItems() {
    mockPostsRepo()

    activityRule.launchActivity(Intent())

    checkTitleAtPosition(0, "Post 1")
    checkTitleAtPosition(2, "Post 3")
  }

  private fun checkTitleAtPosition(position: Int, expectedName: String) {
    Espresso.onView(withRecyclerView(R.id.postsView).atPositionOnView(position, R.id.title))
        .check(ViewAssertions.matches(ViewMatchers.withText(expectedName)))
  }

  @Test
  fun testOpenDetailsOnItemClick() {
    mockPostsRepo()

    activityRule.launchActivity(Intent())

    Espresso.onView(ViewMatchers.withId(R.id.postsView))
        .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))

    val expectedText = "Post 1"

    Espresso.onView(Matchers.allOf(ViewMatchers.withId(android.support.design.R.id.snackbar_text), ViewMatchers.withText(expectedText)))
        .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
  }

  private fun mockPostsRepo() {
    val fakePosts = (1..100).map {
      val number = it
      Post(number.toInt(), "Post $number",  "body $number", number.toInt())
    }

    val mockSingle = Single.create<List<Post>> { emitter: SingleEmitter<List<Post>> ->
      emitter.onSuccess(fakePosts)
    }

    whenever(mockRepository.getPosts()).thenReturn(mockSingle)
  }

  private fun mockRepoError(page: Int) {
    val mockSingle = Single.create<List<Post>> { emitter: SingleEmitter<List<Post>> ->
      emitter.onError(Throwable("Error"))
    }

    whenever(mockRepository.getPosts()).thenReturn(mockSingle)
  }
}