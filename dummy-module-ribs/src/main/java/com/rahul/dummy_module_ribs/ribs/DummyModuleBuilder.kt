package com.rahul.dummy_module_ribs.ribs

import android.content.Context
import com.rahul.dummy_module_ribs.dummyRouterModule
import com.rahul.core_ribs.ribs.BaseBuilder
import com.rahul.core_ribs.ribs.BaseRouter
import com.rahul.core_ribs.utils.getKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf

/**
 * Dummy modules builder class
 */
class DummyModuleBuilder(context: Context) : BaseBuilder(context) {

    override fun initRouter(): BaseBuilder {
        initKoinModules()
        return this
    }

    private fun initKoinModules() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(dummyRouterModule)
        }
    }

    /**
     * creates a router class
     */
    override fun createRouter(): BaseRouter {
        val router : DummyModuleRouter by getKoin.inject { parametersOf(routerParams) }
        return router
    }
}