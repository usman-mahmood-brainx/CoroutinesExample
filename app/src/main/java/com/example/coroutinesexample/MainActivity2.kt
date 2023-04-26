package com.example.coroutinesexample

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.graphics.green
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    private val TAG = "SUSPEND_FUN"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

//       CoroutineScope(Dispatchers.Main).launch {
//           task1()
//       }
//       CoroutineScope(Dispatchers.Main).launch {
//           task2()
//       }
    }

    private suspend fun printFollowers() {
        var fbFollower = 0
        var instaFollowers = 0
        val fb = CoroutineScope(Dispatchers.IO).async {
           getFbFollowers()
        }
        val insta = CoroutineScope(Dispatchers.IO).async {
            getInstaFollowers()
        }
//        job.join()
//        job2.join()
        Log.d(TAG,"FB - ${fb.await()} , Insta - ${insta.await()}")
    }

    
//    private suspend fun printFollowers() {
//       CoroutineScope(Dispatchers.IO).launch {
//           val fb = async {
//               getFbFollowers()
//           }
//           val insta = async {
//               getInstaFollowers()
//           }
//           Log.d(TAG,"FB - ${fb.await()} , Insta - ${insta.await()}")
//       }
//
//    }


    // Using Async
//    private suspend fun printFollowers() {
//        var fbFollower = 0
//        val job = CoroutineScope(Dispatchers.IO).async {
//            getFbFollowers()
//        }
//        job.join()
//        Log.d(TAG,job.await().toString())
//    }

    suspend fun getFbFollowers():Int {
        delay(1000)
        return 54
    }
    suspend fun getInstaFollowers():Int {
        delay(1000)
        return 113
    }
    
    suspend fun task1(){
        Log.d(TAG,"Starting Task 1")
        delay(200)
        //  yield()
        Log.d(TAG,"Ending Task 1")
    }
    
    suspend fun task2(){
        Log.d(TAG,"Starting Task 2")
        delay(200)
        //yield()
        Log.d(TAG,"Ending Task 2")
    }


}

