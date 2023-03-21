package com.jetbrains.handson.kmm.shared.network

import RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class SpaceXApi {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }

    suspend fun getAllLaunches(): List<RocketLaunch> {
        // print("Out put start")

        return httpClient.get("https://api.spacexdata.com/v3/launches").body()
        // return httpClient.get("https://api.nytimes.com/svc/topstories/v2/home.json?api-key=uHzA2h2Gl0sCdTZGMhYMhYhWGRg6t2we").body()
    }
}