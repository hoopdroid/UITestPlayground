package iliasavin.uitestplayground.presentation.base

/**
 * Created by ilyasavin on 11/14/17.
 */
interface BaseLCEView {
  fun showProgress()
  fun hideProgress()
  fun showError(message: String)
}
