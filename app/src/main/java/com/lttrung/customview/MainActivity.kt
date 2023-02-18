package com.lttrung.customview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lttrung.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        Thread {
            while (true) {
                Thread.sleep(1000)
                binding.customClock.invalidate()
            }
        }.start()
    }
}