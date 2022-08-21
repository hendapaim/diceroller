package com.hendadev.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        val numberText: TextView = findViewById(R.id.number_text)
        rollButton.setOnClickListener {
            numberText.text = numberRandom()
            //Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
        }
    }

    private fun numberRandom(): String {
        val number = arrayOf(1,2,3,4,5,6)
        return number[Random().nextInt(6)].toString()
    }
}