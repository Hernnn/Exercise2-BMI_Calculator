package com.example.exercise2_bmi_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var BMIPicture : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        BMIPicture = findViewById(R.id.imageViewProfile)

        val cal: Button = findViewById(R.id.buttonCalculate)
        cal.setOnClickListener {calculate()}

        val rst: Button = findViewById(R.id.buttonReset)
        rst.setOnClickListener {rstt()}
    }

    private fun calculate(){
        val height: EditText = findViewById(R.id.editTextHeight)
        val weight: EditText = findViewById(R.id.editTextWeight)

        val BMIresult = weight.text.toString().toDouble() / ((height.text.toString().toDouble()/100)*(height.text.toString().toDouble()/100))

        textBMI.text = BMIresult.toString()

        Toast.makeText(this, "button clicked",
            Toast.LENGTH_SHORT).show()

        if(BMIresult < 18.5){
            val underr = BMIresult
            val BMI = when(BMIresult){
                underr -> R.drawable.under
                else -> R.drawable.empty
            }
            BMIPicture.setImageResource(BMI)
        }else if(BMIresult >= 18.5 && BMIresult <=24.9){
            val norm = BMIresult
            val BMI = when(BMIresult){
                norm -> R.drawable.normal
                else -> R.drawable.empty
            }
            BMIPicture.setImageResource(BMI)
        }else if( BMIresult > 25){
            val overr = BMIresult
            val BMI = when(BMIresult){
                overr -> R.drawable.over
                else -> R.drawable.empty
            }
            BMIPicture.setImageResource(BMI)
        }
    }

    private fun rstt(){
        val height: EditText = findViewById(R.id.editTextHeight)
        val weight: EditText = findViewById(R.id.editTextWeight)

        val bmi: TextView = findViewById(R.id.textViewBMI)

        height.text = null
        weight.text = null
        bmi.text = null
    }
}
