package com.rahul.core_ribs.controller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity

// This class makes the navigation easy.
object BaseNavigator {

    /**
     * Add fragment to the activity
     * @param context parent fragment
     * @param fragmentName name of the fragment
     * @param addToBackStack if the fragment has to be added to the stack
     * @param bundle data that needs to passed to the fragment
     * @param tag tag name
     * @param fragmentId container id where the fragment needs to be added
     */
    fun addFragment(
        context: FragmentActivity?,
        fragmentName: String,
        addToBackStack: Boolean,
        bundle: Bundle?,
        tag: String,
        fragmentId: Int = 0
    ) {
        val manager = context?.supportFragmentManager
        val ft = manager?.beginTransaction()

//        ft?.setCustomAnimations(
//            R.anim.enter_from_right,
//            R.anim.exit_to_left,
//            R.anim.enter_from_left,
//            R.anim.exit_to_right
//        )

        if (addToBackStack) {
            ft?.addToBackStack(tag)
        }
        val fragment =
            androidx.fragment.app.Fragment.instantiate(context!!.baseContext, fragmentName, bundle)
        ft?.replace(fragmentId, fragment, tag)
        ft?.commitAllowingStateLoss()
    }

    /**
     * create a new activty
     * @param fromActivity from activity
     * @param toActivity to activity
     * @param finish finish the previous activity
     * @param bundle data that needs to passed to the activity
     * @param startFresh clear all the stack and start fresh
     */
    fun goToActivity(
        fromActivity: Activity,
        toActivity: Class<out Any>,
        finish: Boolean = false,
        bundle: Bundle? = null,
        startFresh: Boolean = false
    ) {
        val intent = Intent(fromActivity, toActivity)
        intent.putExtras(bundle ?: Bundle())

        if (startFresh) intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        fromActivity.startActivity(intent)

        if (finish) fromActivity.finish()
    }

    /**
     * create a new activty with a callback(Call activity with result)
     * @param fromActivity from activity
     * @param toActivity to activity
     * @param finish finish the previous activity
     * @param bundle data that needs to passed to the activity
     * @param startFresh clear all the stack and start fresh
     */
    fun goToActivityWithResult(
        fromActivity: Activity,
        toActivity: Class<out Any>,
        finish: Boolean = false,
        bundle: Bundle? = null,
        startFresh: Boolean = false,
        requestCode: Int? = 0
    ) {
        val intent = Intent(fromActivity, toActivity)
        intent.putExtras(bundle ?: Bundle())

        if (startFresh) intent.flags =
            Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

        fromActivity.startActivityForResult(intent, requestCode ?:0)

        if (finish) fromActivity.finish()
    }

}