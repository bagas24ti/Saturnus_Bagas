package com.example.saturnus_bagas.Data.Api

import com.example.saturnus_bagas.Data.Model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}