package com.android.fruitdetectorapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.fruitdetectorapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnBack.setOnClickListener{
            finish()
        }

        binding.btnInstagram.setOnClickListener{
            val uri = Uri.parse("https://instagram.com/rizkiakbar13?igshid=YmMyMTA2M2Y")
            try {
                Intent(Intent.ACTION_VIEW, uri).apply {
                    setPackage("com.instagram.android")
                    startActivity(this)
                }
            } catch (e : ActivityNotFoundException){
                Intent(Intent.ACTION_VIEW, uri).apply {
                    startActivity(this)
                }
            }
        }

        binding.btnGithub.setOnClickListener{
            val uri = Uri.parse("http://github.com/rizqiakbarr13")
            Intent(Intent.ACTION_VIEW, uri).apply {
                startActivity(this)
            }
        }
    }
}