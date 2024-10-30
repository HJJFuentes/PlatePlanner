package com.example.plateplanner

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.plateplanner.Function2Activity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val and var are key words used for declaring variables
        val buttonFunction1 = findViewById<Button>(R.id.btnFunction1)
        val buttonFunction2 = findViewById<Button>(R.id.btnFunction2)
        val buttonFunction3 = findViewById<Button>(R.id.btnFunction3)
        val buttonFunction4 = findViewById<Button>(R.id.btnFunction4)
        val buttonFunction5 = findViewById<Button>(R.id.btnFunction5)

        // seton blah is used for a button to preform an action
        // intent is used for one activity to move on to the other activity

        buttonFunction1.setOnClickListener {

            intent = Intent(this, Function1Activity::class.java)
            startActivity(intent)
        }

        buttonFunction2.setOnClickListener {

            intent = Intent(this, Function2Activity::class.java)
            startActivity(intent)
        }

        buttonFunction3.setOnClickListener {

            intent = Intent(this, Function3Activity::class.java)
            startActivity(intent)
        }

        buttonFunction4.setOnClickListener {

            intent = Intent(this, Function4Activity::class.java)
            startActivity(intent)
        }
        buttonFunction5.setOnClickListener {

            intent = Intent(this, Function5Activity::class.java)
            startActivity(intent)
        }
    }
}