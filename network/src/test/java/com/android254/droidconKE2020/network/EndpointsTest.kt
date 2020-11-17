package com.android254.droidconKE2020.network

import com.android254.droidconKE2020.network.payloads.GoogleToken
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.inject
import org.koin.test.mock.declare

class EndpointsTest : KoinTest {

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        modules(networkModule, fakeModule)
    }

    val service: ApiService by inject()

    lateinit var server: MockWebServer

    @Before
    fun setup() {
        server = MockWebServer()
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun testGetSponsors() = runBlocking {
        server.enqueue(MockResponse().setBody("""{"data": [{"name": "test"}]}"""))
        server.start()
        declare {
            server.url("/")
        }
        val sponsors = service.events.getSponsors()
        assertThat(sponsors.data.size, `is`(1))
    }

    @Test
    fun testGetAccessToken() = runBlocking {
        server.enqueue(MockResponse().setBody("""{"token": "abc", "user": {"name": "abc"}}"""))
        server.start()
        declare {
            server.url("/")
        }
        val token = service.auth.googleLogin(GoogleToken("some token"))
        assertThat(token.token, `is`("abc"))
    }

    @Test
    fun testLogout() = runBlocking {
        server.enqueue(MockResponse().setBody("""{"message": "Success"}"""))
        server.start()
        declare {
            server.url("/")
        }
        val message = service.auth.logout()
        assertThat(message.message, `is`("Success"))
    }
}