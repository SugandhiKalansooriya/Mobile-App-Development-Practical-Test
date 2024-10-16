package com.example.planets

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetViewModel : ViewModel() {
    private val planets = MutableLiveData<List<Planet>>()

    fun getPlanets(): LiveData<List<Planet>> {
        RetrofitClient.instance.getPlanets().enqueue(object : Callback<PlanetResponse> {
            override fun onResponse(call: Call<PlanetResponse>, response: Response<PlanetResponse>) {
                if (response.isSuccessful) {
                    planets.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<PlanetResponse>, t: Throwable) {
                planets.value = emptyList()
            }
        })
        return planets
    }
}
