package com.rahul.core_ribs.core_components

import android.os.Bundle
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    val LOG_TAG: String = this::class.java.simpleName
    lateinit var mActivity: BaseActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivity = this.activity as BaseActivity
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /**
     * override this function to handle the onBackPressed and return true
     */
    open fun onBackPressed(): Boolean {
        return false
    }
}

