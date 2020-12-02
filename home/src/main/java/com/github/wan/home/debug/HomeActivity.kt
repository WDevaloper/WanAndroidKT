package com.github.wan.home.debug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.github.wan.home.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}