package com.rahul.dummy_module_ribs.ribs

import android.app.Activity
import android.os.Bundle
import com.rahul.dummy_module_ribs.dummyRouterModule
import com.rahul.core_ribs.controller.BaseNavigator
import com.rahul.core_ribs.ribs.BaseRouter
import com.rahul.core_ribs.ribs.RouterParams
import com.rahul.dummy_module_ribs.DummyActivity
import org.koin.core.context.unloadKoinModules

class DummyModuleRouter(routerParams: RouterParams) : BaseRouter(routerParams) {

    override fun openModule() {
        if (routerParams.context != null)
            BaseNavigator.goToActivity(
                routerParams.context as Activity,
                DummyActivity::class.java
            )
    }
    // this is when your are finishing the module
    override fun closeModule(bundle: Bundle?) {
        removeKoinModule()
        routerParams.interactor?.onFinish(bundle)
    }

    // this is when your are want to pause the module
    override fun pauseModule(bundle: Bundle?) {
        routerParams.interactor?.onPause(bundle)
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun restartModule(bundle: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addKoinModule() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun removeKoinModule() {
        unloadKoinModules(dummyRouterModule)
    }

}