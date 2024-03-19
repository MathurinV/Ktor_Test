package com.example.ktor_test.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable

@Serializable
data class MyBody(val name:String)

class SampleScreenViewModel(private val http: HttpClient) : ViewModel() {
    fun fetchSomething() = viewModelScope.launch {
        http.get("https://example.com")
    }
    fun postSomething() = viewModelScope.launch{
        http.post("https://example.com"){
            setBody(MyBody("Test"))
        }
    }
}