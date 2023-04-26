package com.example.coroutinesexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private val Tag = "KOTLINFUN"
    lateinit var tvCounter:TextView
    lateinit var btnUpdate:Button
    lateinit var btnExecute:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)

        Log.d(Tag,"${Thread.currentThread().name}")
        tvCounter = findViewById(R.id.counter)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnExecute = findViewById(R.id.btnExecute)

        btnUpdate.setOnClickListener {
            tvCounter.text = "${tvCounter.text.toString().toInt()+1}"
        }
        btnExecute.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                println("First Coroutine Start")
                Log.d(Tag,"1 - ${Thread.currentThread().name}")
                Thread.sleep(3000)
                println("First Coroutine End")
            }

            GlobalScope.launch (Dispatchers.Main){
                println("Second Coroutine Start")
                Log.d(Tag,"2 - ${Thread.currentThread().name}")
                println("Second Coroutine End")
            }
            MainScope().launch(Dispatchers.Default){
                println("Third Coroutine Start")
                Thread.sleep(3000)
                Log.d(Tag,"3 - ${Thread.currentThread().name}")
                println("Third Coroutine end")
            }
//            thread(start=true) {
//                Thread.sleep(5000)
//            }
        }

    }
}