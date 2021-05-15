package com.example.g_management.activities.ui.auth

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.g_management.R
import com.example.g_management.activities.util.*
import com.example.g_management.databinding.ActivitySigninBinding


class Signin : AppCompatActivity(),AuthListener {

    private lateinit var binding: ActivitySigninBinding
    private lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //data binding
         binding  = DataBindingUtil.setContentView<ActivitySigninBinding>(this,R.layout.activity_signin)
         viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
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
    binding.loginProgress.show()
    }
    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this,  {
            binding.loginProgress.hide()
            toastShort(it)
            logi("loginRes",it.toString())
        })
    }
    override fun onFailed(message: String) {
        binding.loginProgress.hide()
        toastShort(message)
    }



}