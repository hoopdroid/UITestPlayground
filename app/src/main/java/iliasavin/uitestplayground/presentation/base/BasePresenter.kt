package iliasavin.uitestplayground.presentation.base

/**
 * Created by ilyasavin on 11/14/17.
 */
abstract class BasePresenter<T> {
  var view: T? = null
    private set

  fun attachView(view: T) {
    this.view = view
  }

  fun detachView() {
    this.view = null
  }

  val isViewAttached: Boolean
    get() = view != null
}
