package com.example.hyderabadtask.di

import android.content.Context
import com.example.hyderabadtask.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context) = context


    @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiService {
        return Retrofit.Builder()
                .baseUrl("https://richlabz.com/sparkles_app/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            .create(ApiService::class.java)
        }
}