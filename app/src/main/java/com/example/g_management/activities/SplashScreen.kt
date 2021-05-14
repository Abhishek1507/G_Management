package com.example.g_management.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.ActionBar
import com.example.g_management.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Custom Action Bar
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            val dynamicTitle: String =  getString(R.string.app_name)
            //Setting a dynamic title at runtime. Here, it displays the current time.
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
            actionBar.setCustomView(R.layout.customtitlebar)
            actionBar.title = dynamicTitle
        }
        //Delay
        Handler().postDelayed({
            startActivity(Intent(this,Signin::class.java))
        },2500)
    }
}