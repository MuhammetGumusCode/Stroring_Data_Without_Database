package com.muhammetgumus.storingdata

import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muhammetgumus.storingdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  var agepreferences : Int? = null

    private lateinit var binding: ActivityMainBinding
    private  lateinit var sharedPreferences : SharedPreferences
    private var a :Int?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // SharedPreferences -XML - Key-Value
        sharedPreferences = this.getSharedPreferences("com.muhammetgumus.storingdata", MODE_PRIVATE)

          agepreferences = sharedPreferences.getInt("Age", -1)

        if (agepreferences != -1) {
            binding.Textview.text = " Your Age :  ${agepreferences.toString()}"

        } else {
            binding.Textview.text = " Your Age : "

        }

    }


    fun save (view  : View) {
        a =  binding.editTextText.text.toString().toIntOrNull()


            if (a!=null) {
                binding.Textview.text = " Your Age :  ${a.toString()}"
                sharedPreferences.edit().putInt("Age",a!!).apply()
            }
            else "Gecersiz sayi"
}



    fun delete (view : View) {


        if (agepreferences!=-1) {

           sharedPreferences.edit().remove("Age").apply()
            binding.Textview.text = " Your Age : "


        }



    }



}