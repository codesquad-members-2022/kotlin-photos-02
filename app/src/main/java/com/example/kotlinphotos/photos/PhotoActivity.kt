package com.example.kotlinphotos.photos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinphotos.R

class PhotoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
    }
}