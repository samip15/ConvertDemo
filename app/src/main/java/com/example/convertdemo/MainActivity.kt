package com.example.convertdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(){
    lateinit var editText: EditText
    lateinit var buttonClickMe: Button
    lateinit var textVal: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editText = findViewById(R.id.edit_degree)
        buttonClickMe = findViewById(R.id.btn_convert)
        textVal = findViewById(R.id.text_View)
        buttonClickMe.setOnClickListener({onButtonClick()})
    }
    fun onButtonClick() {
        val degreeVal: String = editText.text.toString()
        try {
            val degreeInNumber = degreeVal.toDouble()
            var result: Double = degreeInNumber.convertTODegree(degreeVal.toDouble())
            textVal.text = "Your Result Is " + result
        }catch (e: NumberFormatException){
            null
            Toast.makeText(this, "Enter Some Number", Toast.LENGTH_SHORT).show()
        }
    }
    fun Double.convertTODegree(number: Double): Double{
        return this * 9/5 +32
    }
}
