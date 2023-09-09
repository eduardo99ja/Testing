package com.apodaca.testing.part4.data

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.apodaca.testing.part4.domain.AnalyticsLogger
import com.apodaca.testing.part4.domain.LogParam

class FirebaseAnalyticsLogger(
    private val analytics: FirebaseAnalytics = Firebase.analytics
): AnalyticsLogger {

    override fun logEvent(key: String, vararg params: LogParam<Any>) {
        analytics.logEvent("save_profile") {
            params.forEach { parameter ->
                param(parameter.key, parameter.value.toString())
            }
        }
    }
}