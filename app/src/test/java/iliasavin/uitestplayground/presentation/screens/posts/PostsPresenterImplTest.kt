package iliasavin.uitestplayground.presentation.screens.posts

import iliasavin.uitestplayground.data.entities.Post
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

/**
 * Created by ilyasavin on 11/17/17.
 */
class PostsPresenterImplTest {
  lateinit var mockView: PostsView
  lateinit var presenter: PostsPresenterImpl

  @Before
  fun setUp() {
    mockView = mock(PostsView::class.java)
    val mockInteractor: MockGetPostsInteractor = MockGetPostsInteractor()
    presenter = PostsPresenterImpl(mockInteractor)
    presenter.attachView(mockView)
  }

  @Test
  fun test_presenter_has_attached_notnull_view() {
    Assert.assertNotNull(presenter.view)
  }

  @Test
  fun test_presenter_detached_from_view() {
    presenter.detachView()
    Assert.assertEquals(presenter.view, null)
  }

  @Test
  fun test_posts_success_loaded() {
    presenter.getPosts()
    verify(mockView).showPosts(ArrayList<Post>())
  }

  @Test
  fun test_detail_screen_opened_after_click() {
    presenter.openDetailsScreen(Post())
    verify(mockView).showDetailsScreen(Post())
  }
}