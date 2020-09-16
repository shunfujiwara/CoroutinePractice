package jp.shn.coroutine.practice.ui.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import jp.gignote.android.di.FragmentModule
import jp.shn.coroutine.practice.di.FragmentComponent
import jp.shn.coroutine.practice.ui.activity.BaseActivity
import java.lang.AssertionError
import java.lang.IllegalStateException


/**
 * Created by shn on 2020/09/15
 */
abstract class BaseFragment : Fragment() {

    private var _component: FragmentComponent? = null
    val component: FragmentComponent
        get() {
            if (_component == null) {

                if (activity is BaseActivity) {
                    _component = (activity as BaseActivity).component.plus(FragmentModule(this))

                } else {
                    throw IllegalStateException(
                        "The activity of this fragment is not an instance of BaseActivity"
                    )
                }
            }
            return _component ?: throw AssertionError("Set to null by another thread!!!")
        }

    override fun getContext(): Context {
        return super.getContext()!!
    }
}