package com.ayn.ksqbsq

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class IntentModel(
    var ksq:Int,
    var isBsq: Boolean
) : Parcelable
