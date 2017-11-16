package iliasavin.uitestplayground.presentation.screens.post_detail

import android.app.Application
import android.support.annotation.NonNull
import android.support.test.runner.AndroidJUnit4
import iliasavin.uitestplayground.DaggerActivityTestRule
import iliasavin.uitestplayground.DaggerActivityTestRule.OnActivityLaunchedListener
import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.presentation.screens.posts.TestPostDetailPresenterImpl
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
class PostDetailActivityTest {
  private var lock = CountDownLatch(1)
  var activity: PostDetailActivity? = null

  @Rule
  @JvmField
  var rule = DaggerActivityTestRule(
      PostDetailActivity::class.java,
      object : OnActivityLaunchedListener<PostDetailActivity> {

        override fun beforeActivityLaunched(@NonNull application: Application) {
          //do nothing
        }

        override fun afterActivityLaunched(application: Application, activity: PostDetailActivity) {
          activity?.presenter = TestPostDetailPresenterImpl()
          this@PostDetailActivityTest.activity = activity
        }
      })

  @Before
  fun preparePresenter() {
    activity?.presenter = TestPostDetailPresenterImpl()

    with(activity?.presenter as TestPostDetailPresenterImpl) {
      lock = this@PostDetailActivityTest.lock
    }

  }

  @Test
  @Throws(Exception::class)
  fun testPostDetailActivity() {
    rule.runOnUiThread {
      activity?.presenter?.attachView(activity!!)
      activity?.presenter?.setPostInfo(Post())
    }
    println(activity!!.presenter.javaClass.simpleName)

    lock.await() //lock the test

    Assert.assertTrue(true)
  }

}