package com.mynews.srijanassignment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val texxt = findViewById<TextView>(R.id.tte)
        val us = intent.getStringExtra("us")

        texxt.setText("Hello   "+ us)
    }
}