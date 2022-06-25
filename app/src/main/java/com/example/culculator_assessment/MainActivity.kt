package com.example.culculator_assessment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.culculator_assessment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleClick()
    }
    fun handleClick(){
        binding.btnAdd.setOnClickListener{
            add(obtainInputs())
        }
        binding.btnSubtract.setOnClickListener{
            subtract(obtainInputs())
        }
        binding.btnModulus.setOnClickListener{
            modulus(obtainInputs())
        }
        binding.btnDivide.setOnClickListener{
            devide(obtainInputs())
        }
    }

    data class Inputs(var num1: Double,var num2: Double)
    //    Obtain the values of 2 numbers
    fun obtainInputs(): Inputs?{
        binding.tilFirstNumber.error = null
        binding.tilSecondNumber.error = null
        var num1 =binding.etFirstNumber.text.toString()
        var num2 =binding.etSecondNumber.text.toString()
        var error = false
        if (num1.isBlank()){
            binding.tilFirstNumber.error = "Number 1 is required"
            error = true
        }
        if (num2.isBlank()){
            binding.tilSecondNumber.error = "Number 2 is required"
            error = true
        }
        if (!error){
            return Inputs(num1.toDouble(),num2.toDouble())
        }
        return null

    }

    fun add(inputs: Inputs?){
        if (inputs!=null){
            var total = inputs.num1 + inputs.num2
            binding.tvResults.text = total.toString()

        }

    }
    fun subtract(inputs: Inputs?){
        if (inputs != null){
            var total = inputs.num1 - inputs.num2
            binding.tvResults.text = total.toString()

        }
    }
    fun modulus(inputs: Inputs?){
        if (inputs!= null){
            var total = inputs.num1 % inputs.num2
            binding.tvResults.text = total.toString()
        }

    }
    fun devide(inputs: Inputs?){
        if (inputs!= null){
            var total = inputs.num1 / inputs.num2
            binding.tvResults.text = total.toString()
        }
    }

}



