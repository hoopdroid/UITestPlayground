package iliasavin.uitestplayground

import android.app.Activity
import android.app.Application
import android.support.test.InstrumentationRegistry
import android.support.test.rule.ActivityTestRule

/**
 * Created by ilyasavin on 11/16/17.
 */

/**
 * Created by anton.alifanov on 5/10/17
 */

class DaggerActivityTestRule<T : Activity>(activityClass: Class<T>,
    initialTouchMode: Boolean,
    launchActivity: Boolean,
    private val mListener:
    DaggerActivityTestRule.OnActivityLaunchedListener<T>)
  : ActivityTestRule<T>(activityClass, initialTouchMode, launchActivity) {

  constructor(activityClass: Class<T>,
      listener: OnActivityLaunchedListener<T>) : this(activityClass, false, listener)

  constructor(activityClass: Class<T>, initialTouchMode: Boolean,
      listener: OnActivityLaunchedListener<T>) : this(activityClass, initialTouchMode, true, listener)

  override fun beforeActivityLaunched() {
    super.beforeActivityLaunched()
    mListener.beforeActivityLaunched(InstrumentationRegistry.getInstrumentation()
        .targetContext.applicationContext as Application)
  }

  override fun afterActivityLaunched() {
    super.afterActivityLaunched()
    mListener.afterActivityLaunched(InstrumentationRegistry.getInstrumentation()
        .targetContext.applicationContext as Application, activity)
  }

  interface OnActivityLaunchedListener<in T> {
    fun beforeActivityLaunched(application: Application)
    fun afterActivityLaunched(application: Application, activity: T)
  }
}
