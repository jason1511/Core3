package com.example.core3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val textView = findViewById<TextView>(R.id.lastcountry)
        val titletext = intent.getStringExtra("title").toString()
        val ioctext = intent.getStringExtra("IOC").toString()
        val str = "Last Country Selected was $titletext (${ioctext})"
        textView.text = str
    }
}