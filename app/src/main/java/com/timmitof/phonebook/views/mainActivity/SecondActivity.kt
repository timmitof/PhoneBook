package com.timmitof.phonebook.views.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.timmitof.phonebook.R
import com.timmitof.phonebook.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}