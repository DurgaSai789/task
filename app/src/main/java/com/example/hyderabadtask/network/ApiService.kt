package com.example.hyderabadtask.network

import com.example.hyderabadtask.ui.schedulepic.model.ServiceResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("servicesNames")
    suspend fun getServices() :Response<ServiceResponse>
}


