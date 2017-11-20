package iliasavin.uitestplayground.presentation.screens.post_detail

import iliasavin.uitestplayground.data.entities.Post
import iliasavin.uitestplayground.domain.interactors.UpdatePostsInteractor
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify

/**
 * Created by ilyasavin on 11/20/17.
 */
class PostDetailPresenterImplTest {
  lateinit var mockView: PostsDetailView
  lateinit var presenter: PostDetailPresenterImpl

  @Before
  fun setUp() {
    mockView = Mockito.mock(PostsDetailView::class.java)
    val mockInteractor: UpdatePostsInteractor = MockUpdatePostInteractor()
    presenter = PostDetailPresenterImpl(mockInteractor)
    presenter.attachView(mockView)
  }

  @Test
  fun test_presenter_has_attached_notnull_view() {
    presenter.attachView(mockView)
    Assert.assertNotNull(presenter.view)
  }

  @Test
  fun test_presenter_detached_from_view() {
    presenter.detachView()
    Assert.assertEquals(presenter.view, null)
  }

  @Test
  fun test_details_info_was_opened() {
    val testPost = Post()
    presenter.setPostInfo(testPost)
    verify(mockView).showPostInfo(presenter.post)
  }

  @Test
  fun test_details_were_updated() {
    val testPost = Post()
    presenter.post = testPost
    presenter.updatePostInfo()
    verify(mockView).showPostInfo(testPost)
  }
}