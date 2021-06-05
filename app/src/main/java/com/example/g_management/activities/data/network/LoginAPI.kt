package com.example.g_management.activities.data.network

import com.example.g_management.activities.util.BASE_URL
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginAPI {
    @FormUrlEncoded
    @POST("login")
    fun userLogin(
        @Field("username") username : String,
        @Field("password") password : String
        ) : Call<ResponseBody>

    companion object{
        operator fun invoke() : LoginAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginAPI::class.java)
        }

    }

}