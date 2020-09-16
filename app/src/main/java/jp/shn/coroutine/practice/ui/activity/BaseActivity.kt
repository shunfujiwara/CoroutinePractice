package jp.shn.coroutine.practice.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import jp.shn.coroutine.practice.App
import jp.shn.coroutine.practice.di.ActivityComponent
import jp.shn.coroutine.practice.di.ActivityModule


/**
 * Created by shn on 2020/09/15
 */
abstract class BaseActivity : AppCompatActivity() {

    private var _component: ActivityComponent? = null
    val component: ActivityComponent
        get() {
            if (_component == null) {
                _component = (application as App).component.plus(ActivityModule(this))
            }
            return _component ?: throw AssertionError("Set to null by another thread!!!")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }
}