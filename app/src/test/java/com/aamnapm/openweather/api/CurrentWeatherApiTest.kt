package com.aamnapm.openweather.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aamnapm.openweather.LiveDataTestUtil
import com.aamnapm.openweather.data.api.CurrentWeatherApi
import com.aamnapm.openweather.model.CurrentWeather
import com.aamnapm.openweather.utils.api.apikotlin.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.BufferedSource
import okio.buffer
import okio.source
import org.hamcrest.CoreMatchers
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CurrentWeatherApiTest {


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var mockWebServer: MockWebServer

    private lateinit var service: CurrentWeatherApi

    @Before
    fun createService() {
        mockWebServer = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(CurrentWeatherApi::class.java)
    }


    @Test
    fun success() {

        var data = getDataFromResource("success-current-weather.json")
        setBodyAndStatusCode(data, 200)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiSuccessResponse<CurrentWeather>).body

        Assert.assertThat(apiResponse.name, CoreMatchers.`is`("Tehran"))
    }

    @Test
    fun unavailableError() {

        var data = getDataFromResource("success-current-weather.json")
        setBodyAndStatusCode(data, 503)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiServiceUnavailableErrorResponse<*>)

        Assert.assertEquals(apiResponse.errorCode, 503)
    }

    @Test
    fun internalServerError() {

        var data = getDataFromResource("success-current-weather.json")
        setBodyAndStatusCode(data, 500)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiInternalServerErrorResponse<*>)

        Assert.assertEquals(apiResponse.errorCode, 500)
    }

    @Test
    fun notFoundError() {

        var data = getDataFromResource("success-current-weather.json")
        setBodyAndStatusCode(data, 404)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiNotFoundErrorResponse<*>)

        Assert.assertEquals(apiResponse.errorCode, 404)
    }

    @Test
    fun badRequestError() {

        var data = getDataFromResource("success-current-weather.json")
        setBodyAndStatusCode(data, 400)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiBadRequestErrorResponse<*>)

        Assert.assertEquals(apiResponse.errorCode, 400)
    }

    @Test
    fun emptySuccess() {

        var data = getDataFromResource("")
        setBodyAndStatusCode(data, 204)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiEmptyResponse)

        Assert.assertThat(apiResponse, CoreMatchers.`is`(ApiEmptyResponse::class.java))

    }

    @Test
    fun authenticateError() {

        var data = getDataFromResource("authentication-error-current-weather.json")
        setBodyAndStatusCode(data, 401)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                ""
            )
        ) as ApiAuthenticateErrorResponse)

        Assert.assertEquals(apiResponse.errorCode, 401)
    }

    @Test
    fun conflictError() {

        var data = getDataFromResource("")
        setBodyAndStatusCode(data, 409)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiConflictErrorResponse)

        Assert.assertEquals(apiResponse.errorCode, 409)

    }

    @Test
    fun forbiddenError() {

        var data = getDataFromResource("")
        setBodyAndStatusCode(data, 403)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiForbiddenErrorResponse)

        Assert.assertEquals(apiResponse.errorCode, 403)

    }

    @Test
    fun methodNotAllowedError() {

        var data = getDataFromResource("")
        setBodyAndStatusCode(data, 405)

        var apiResponse = (LiveDataTestUtil.getValue(
            service.currentWeather(
                "Tehran",
                "metric",
                "0a73c3a66de1a0f4cc2597d2801582b4"
            )
        ) as ApiMethodNotAllowedErrorResponse)

        Assert.assertEquals(apiResponse.errorCode, 405)

    }


    private fun getDataFromResource(filename: String): BufferedSource? {
        if (!filename.equals("")) {
            val inputStream = javaClass.classLoader?.getResourceAsStream("api-response/$filename")
            return inputStream?.source()?.buffer()
        } else {
            return null
        }
    }

    private fun setBodyAndStatusCode(
        bufferedSource: BufferedSource?,
        statusCode: Int,
        headers: Map<String, String> = emptyMap()
    ) {
        val mockResponse = MockResponse()

        for ((key, value) in headers) {
            mockResponse.addHeader(key, value)
        }

        if (bufferedSource == null) {
            mockWebServer.enqueue(
                mockResponse.setResponseCode(statusCode)
            )
        } else {
            mockWebServer.enqueue(
                mockResponse
                    .setBody(bufferedSource?.readString(Charsets.UTF_8)!!)
                    .setResponseCode(statusCode)
            )
        }
    }


}