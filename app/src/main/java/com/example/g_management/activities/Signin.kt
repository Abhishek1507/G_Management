package com.example.g_management.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.example.g_management.R



class Signin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

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
}