package com.example.planets

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("planets")
    fun getPlanets(): Call<PlanetResponse>
}
