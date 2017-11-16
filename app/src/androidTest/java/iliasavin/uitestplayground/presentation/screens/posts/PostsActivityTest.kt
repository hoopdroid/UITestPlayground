package iliasavin.uitestplayground.presentation.screens.posts

import android.app.Application
import android.support.annotation.NonNull
import android.support.test.runner.AndroidJUnit4
import iliasavin.uitestplayground.DaggerActivityTestRule
import iliasavin.uitestplayground.DaggerActivityTestRule.OnActivityLaunchedListener
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

/**
 * Created by ilyasavin on 11/14/17.
 */
@RunWith(AndroidJUnit4::class)
class PostsActivityTest {
  private var lock = CountDownLatch(1)
  var activity: PostsActivity? = null

  @Rule
  @JvmField
  var rule = DaggerActivityTestRule(
      PostsActivity::class.java,
      object : OnActivityLaunchedListener<PostsActivity> {

        override fun beforeActivityLaunched(@NonNull application: Application) {
          //do nothing
        }

        override fun afterActivityLaunched(application: Application, activity: PostsActivity) {
          activity?.presenter = TestPostsPresenterImpl()
          this@PostsActivityTest.activity = activity
        }
      })

  @Before
  fun preparePresenter() {
    activity?.presenter = TestPostsPresenterImpl()


    with(activity?.presenter as TestPostsPresenterImpl) {
      lock = this@PostsActivityTest.lock
    }

  }

  @Test
  @Throws(Exception::class)
  fun testPostsActivity() {
    rule.runOnUiThread {
      activity?.presenter?.attachView(activity!!)
      activity?.presenter?.getPosts()
    }
    println(activity!!.presenter.javaClass.simpleName)

    lock.await() //lock the test

    Assert.assertTrue(true)
  }

}