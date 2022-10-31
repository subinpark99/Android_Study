package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

//버튼 클릭할 때 마다 랜덤으로 텍스트 값 변경
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countButton: Button = findViewById(R.id.count_up)
        countButton.setOnClickListener { countUp() }

    }

    private fun rollDice() {

        val resultText: TextView = findViewById(R.id.result_text)

        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()

//        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
//        토스트 메시지 표시
    }

    private fun countUp(){

        val resultText: TextView = findViewById(R.id.result_text)

        if(resultText.text=="Hello World!")
            resultText.text="1"
        else{
            var randomInt = resultText.text.toString().toInt()
            if(randomInt<6) {
                randomInt++
                resultText.text = randomInt.toString()
            }
        }
    }
}