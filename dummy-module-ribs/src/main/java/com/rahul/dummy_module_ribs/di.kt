package com.rahul.dummy_module_ribs

import com.rahul.dummy_module_ribs.ribs.DummyModuleRouter
import com.rahul.core_ribs.ribs.RouterParams
import org.koin.dsl.module

val dummyRouterModule = module {
    // Network API
    single { (params: RouterParams) -> DummyModuleRouter(params) }
}