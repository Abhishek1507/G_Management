package com.example.g_management.activities.ui.auth

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.g_management.R
import com.example.g_management.activities.util.toast
import com.example.g_management.databinding.ActivitySigninBinding


class Signin : AppCompatActivity(),AuthListener {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data binding
        val binding : ActivitySigninBinding = DataBindingUtil.setContentView<ActivitySigninBinding>(this,R.layout.activity_signin)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.authListener = this

        //Custom Action Bar
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            val dynamicTitle: String =  getString(R.string.app_name)
            //Setting a dynamic title at runtime. Here, it displays the current time.
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            actionBar.setCustomView(R.layout.customtitlebar)
            actionBar.title = dynamicTitle
        }
    }

//Implementing AuthListener Methods
    override fun onStarted() {

    }
    override fun onSuccess() {
        toast("Login Successful")
    }
    override fun onFailed(message: String) {
        toast(message)
    }

}