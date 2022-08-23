package com.hendadev.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Logic for my application
        diceImage = findViewById(R.id.dice_image)
        rollButton = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
            //Toast.makeText(this, "Botão clicado", Toast.LENGTH_SHORT).show()
            //Snackbar.make(this, R.id.number_text, Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun rollDice() {
        val drawableResource = when (Random().nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}