package com.rahul.core_ribs.core_components

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


open class BaseActivity : AppCompatActivity() {
    val LOG_TAG: String = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // for vector drawables support to android < 21
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun onStart() {
        super.onStart()
        //hides the action bar
        supportActionBar?.hide()
    }

    /**
     * code that helps to handle the back press in fragments
     */
    override fun onBackPressed() {
        //Fetch the list of fragments
        val fragmentList: List<*> = supportFragmentManager.fragments
        var handled = false
        for (f in fragmentList) {
            //checks if the fragment is base fragment
            if (f is BaseFragment) {
                // check if the on back pressed returns true
                handled = f.onBackPressed()
                //if true on back pressed will be handle by fragment and ignores the next step
                if (handled) {
                    break
                }
            }
        }
        // if false on back pressed is handled by the activity
        if (!handled) {
            super.onBackPressed()
        }
    }
}