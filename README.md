# android-modular-app-ribs
# Fully inspired from https://github.com/uber/RIBs

## why did I use this
I was trying to create a moduler android app which should be kind of super app. To achive this I tried few things like android   navigation a jetpack component but they had few issues in achiving full modular app.

I looked into uber ribs and liked the arcitecture, so I tried created a simple ribs architecture which uses activities and fragments instead of views. You can have single activity app aswell as multiple activity app using this.

## where to start
Create a android project with an empty activity.

## What does it have - core parts
Add a core module which would have a router, interactor and a builder.

### Core Bulder - that helps to build the router
```
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
```

### Base Router - That helps to route through the modules
```
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
```

### Base Interactor - This helps to interact back to the main module
```
interface BaseInteractor {
    //when module completes its job and ready to be killed
    fun onFinish(bundle: Bundle?)
    // when other module needs to be opened and keep the present module in Background
    fun onPause(bundle: Bundle?)
}
```

## How to use core parts
 create a Dummy module and extend the core components
 
### Dummy module builder
```
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
```

### Dummy module router
```
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
```

### Dummy module Interactor
```
interface DummyModuleInteractor : BaseInteractor {

}
```

## How does it work
In the main app activity you just need to build the dummy module router using its builder.
check the following code
```
 //call the dummy module
    private fun callDummyModule() {
        var router = DummyModuleBuilder(this)
            .addBundle(intent.extras)
            .addConfigs(BaseConfigs())
            .addInteractor(object : DummyModuleInteractor {
                override fun onFinish(bundle: Bundle?) {

                }

                override fun onPause(bundle: Bundle?) {
                    callDummyModule2()
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            .initRouter()
            .createRouter()
        router.openModule()
    }
```

Throw your suggestions.
