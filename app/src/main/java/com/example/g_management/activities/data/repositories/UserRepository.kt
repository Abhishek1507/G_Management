package com.example.g_management.activities.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.g_management.activities.data.network.LoginAPI
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun userLogin (username:String,password:String):LiveData<String>{
        val loginResponse = MutableLiveData<String>()
        LoginAPI().userLogin(username,password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {

                    if(response.isSuccessful){
                        loginResponse.value = response.body()?.string()
                    }
                    else {
                        loginResponse.value = response.errorBody()?.string()
                    }

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

            })
        return loginResponse
    }
}