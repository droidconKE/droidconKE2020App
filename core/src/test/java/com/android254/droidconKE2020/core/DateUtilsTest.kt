package com.android254.droidconKE2020.core

import com.android254.droidconKE2020.core.utils.sessionStartTimeSuffix
import com.android254.droidconKE2020.core.utils.toDate
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Test

class DateUtilsTest {

    @Test
    fun `test that toDate converts date properly`() {
        val date = "2021-05-07 08:00:00"
        val result = date.toDate()
        assertThat(result, `is`("08:00 AM"))
    }

    @Test
    fun `test that sessionStartTimeSuffix returns AM or PM`() {
        val result = "2021-05-07 08:00:00".toDate()
        val amOrPm = result.sessionStartTimeSuffix()
        assertThat(amOrPm, `is`("AM"))
    }
}