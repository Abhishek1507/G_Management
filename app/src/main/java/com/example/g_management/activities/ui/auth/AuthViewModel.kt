package com.example.g_management.activities.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.g_management.activities.data.repositories.UserRepository

class AuthViewModel : ViewModel() {
    var username: String? = null
    var password: String? = null

    var authListener : AuthListener? = null

    fun onLoginButtonClicked(view: View){
        if(username.isNullOrBlank() || password.isNullOrBlank()){
            authListener?.onFailed("You can't leave a field blank")

            return
        }
        val loginResponse = UserRepository().userLogin(username!!,password!!)
        authListener?.onSuccess(loginResponse)


    }

    fun forgetPassword(view: View){

    }
}