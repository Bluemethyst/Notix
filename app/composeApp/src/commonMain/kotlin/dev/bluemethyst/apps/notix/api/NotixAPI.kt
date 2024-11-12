package dev.bluemethyst.apps.notix.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*

suspend fun getNotes(userid: Int): List<String> {
    val client = HttpClient()
    val response = client.get("https://ktor.io/")
    return response.body()
}