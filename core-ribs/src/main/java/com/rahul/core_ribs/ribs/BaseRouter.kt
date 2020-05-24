package com.rahul.core_ribs.ribs

import android.os.Bundle

/**
 * Router is main class that helps you to route through the modules
 */
abstract class BaseRouter(val routerParams: RouterParams) {
    // called when module is opened
    abstract fun openModule()

    // called when module needs to be finished
    abstract fun closeModule(bundle: Bundle?)

    // called when module needs to be paused
    abstract fun pauseModule(bundle: Bundle?)

    // called when module comes back from background
    abstract fun restartModule(bundle: Bundle?)

    // add the koin module on the launch of the module
    abstract fun addKoinModule()

    // remove module when module is killed
    abstract fun removeKoinModule()
}