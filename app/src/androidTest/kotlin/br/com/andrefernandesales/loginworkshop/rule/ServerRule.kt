package rule

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

class ServerRule : TestRule {

    val mockWebServer = MockWebServer()

    override fun apply(base: Statement, description: Description?): Statement {
        return object : Statement () {
            override fun evaluate() {
                mockWebServer.start(8080)
                base.evaluate()
            }
        }
    }

    fun turnOff() {
        mockWebServer.shutdown()
    }

    fun enqueue(code: Int, response: String = "") {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(code)
        mockResponse.setBody(response)
        mockWebServer.enqueue(mockResponse)
    }
}