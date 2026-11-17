package com.example.saturnus_bagas.Data.Api

import com.example.saturnus_bagas.Data.Model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}