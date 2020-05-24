package com.rahul.core_ribs.ribs


import android.content.Context
import android.os.Bundle

/**
 * Builder that helps you to build the router object and
 * all the required components to it.
 */
abstract class BaseBuilder(val context: Context) {
    var routerParams: RouterParams = RouterParams()

    init {
        routerParams.context = context
    }

    fun addInteractor(interactor: BaseInteractor): BaseBuilder {
        routerParams.interactor = interactor
        return this
    }

    fun addConfigs(baseConfigs: BaseConfigs): BaseBuilder {
        routerParams.baseConfigs = baseConfigs
        return this
    }

    fun addBundle(bundle: Bundle?): BaseBuilder {
        routerParams.bundle = bundle
        return this
    }

    abstract fun initRouter(): BaseBuilder

    abstract fun createRouter(): BaseRouter


}