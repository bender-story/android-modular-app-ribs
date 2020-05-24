package com.rahul.core_ribs.ribs

import android.os.Bundle

/**
 * Base interactor that would be need to call back to the main module
 */
interface BaseInteractor {
    //when module completes its job and ready to be killed
    fun onFinish(bundle: Bundle?)
    // when other module needs to be opened and keep the present module in Background
    fun onPause(bundle: Bundle?)
}