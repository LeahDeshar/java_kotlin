package com.example.lotteryapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class LottoActivity : AppCompatActivity() {
    private lateinit var resView: TextView
    private lateinit var share: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lotto)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resView = findViewById(R.id.lottoView)
        share = findViewById(R.id.shareBtn)
    val randomNumbers = generateRandomNumber(6)
        Log.d("randomNumbers", "generateRandomNumber: $randomNumbers")
        resView.text = randomNumbers

        var username = receiveUserName()


        share.setOnClickListener {
            shareResult(username,randomNumbers)
        }
    }


    fun generateRandomNumber(count:Int):String{
        val randomNumbers = List(count){
            (0..42).random()


        }
        return randomNumbers.joinToString(" ")
    }

    fun receiveUserName():String{
        var bundle:Bundle? = intent.extras
        return bundle?.getString("name").toString()

    }

    fun shareResult(username:String,genNums:String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "$username generates these numbers")
        intent.putExtra(Intent.EXTRA_TEXT, "The Lottery Numbers are: $genNums")
        val chooser = Intent.createChooser(intent, "Share this number using...")
        startActivity(chooser)
    }
}