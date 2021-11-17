package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.ViewDebug
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton = findViewById<Button>(R.id.dice_roller)

        val edittext : EditText = findViewById(R.id.EditText1)


        edittext.addTextChangedListener(object: TextWatcher {

            var delay : Long = 5000 // 1
            var timer = Timer()

            override fun afterTextChanged(p0: Editable?) {

                timer = Timer()
                timer.schedule(object : TimerTask() {
                    override fun run() {

                        //2
                    }
                }, delay)
                val x = Integer.parseInt(EditText1.getText().toString())
                rollButton.setOnClickListener {
                    Toast.makeText(applicationContext, "Dé lancé", Toast.LENGTH_SHORT).show()
                    val rnd = (1..x).random()
                    val rnd2 = (1..x).random()
                    Nombre.text = rnd.toString()
                    Nombre2.text = rnd2.toString()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                timer.cancel() //3
                timer.purge()
            }
        })






        }


    }

