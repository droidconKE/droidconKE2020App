package com.android254.droidconKE2020.test_utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runners.model.Statement

@ExperimentalCoroutinesApi
class CoroutineTestRule(private val dispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()) :
    TestWatcher() {

    val testCoroutineScope = TestCoroutineScope(dispatcher)

    override fun apply(base: Statement?, description: Description?): Statement {
        return object : Statement() {

            override fun evaluate() {
                Dispatchers.setMain(dispatcher)
                base?.evaluate()
                Dispatchers.resetMain()
                try {
                    testCoroutineScope.cleanupTestCoroutines()
                } catch (exception: Exception) {
                    exception.printStackTrace()
                }
            }
        }
    }

    fun runBlockingTest(block: suspend TestCoroutineScope.() -> Unit) =
        testCoroutineScope.runBlockingTest { block() }
}