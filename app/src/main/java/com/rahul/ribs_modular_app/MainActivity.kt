package com.rahul.ribs_modular_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.dummy_module_ribs.ribs.DummyModuleBuilder
import com.rahul.dummy_module_ribs.ribs.DummyModuleInteractor
import com.rahul.core_ribs.ribs.BaseConfigs

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callDummyModule()

    }
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
    // call a new dummy module
    fun callDummyModule2() {
        var router = DummyModuleBuilder(this)
            .addBundle(intent.extras)
            .addConfigs(BaseConfigs())
            .addInteractor(object : DummyModuleInteractor {
                override fun onFinish(bundle: Bundle?) {

                }

                override fun onPause(bundle: Bundle?) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
            .initRouter()
            .createRouter()
        router.openModule()
    }
}
