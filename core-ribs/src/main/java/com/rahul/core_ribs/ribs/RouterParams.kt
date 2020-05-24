package com.rahul.core_ribs.ribs

import android.content.Context
import android.os.Bundle
import com.rahul.core_ribs.ribs.BaseConfigs
import com.rahul.core_ribs.ribs.BaseInteractor

class RouterParams(
    var context: Context? = null,
    var interactor: BaseInteractor? = null,
    var baseConfigs: BaseConfigs = BaseConfigs(),
    var bundle: Bundle? = null
)