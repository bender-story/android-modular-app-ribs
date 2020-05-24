package com.rahul.dummy_module_ribs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rahul.dummy_module_ribs.ribs.DummyModuleRouter
import org.koin.android.ext.android.inject

class DummyActivity : AppCompatActivity() {

    val router : DummyModuleRouter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        router.closeModule(intent.extras)
    }

    override fun onRestart() {
        super.onRestart()
    }
}
