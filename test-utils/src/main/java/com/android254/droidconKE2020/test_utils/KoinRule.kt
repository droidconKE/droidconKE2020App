package com.android254.droidconKE2020.test_utils

import androidx.test.platform.app.InstrumentationRegistry
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class KoinRule : TestRule {

    val app = InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as KoinTestApp

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {
            override fun evaluate() {
                base?.evaluate()
            }
        }
    }
}