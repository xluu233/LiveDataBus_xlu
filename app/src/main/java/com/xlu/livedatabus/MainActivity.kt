package com.xlu.livedatabus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xlu.livedatabus.databinding.ActivityMainBinding
import com.xlu.livedatabus.util.viewBinding

class MainActivity : AppCompatActivity() {



    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}