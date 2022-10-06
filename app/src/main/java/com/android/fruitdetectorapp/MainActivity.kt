package com.android.fruitdetectorapp

import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.fruitdetectorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //initialize binding layout
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMulai.setOnClickListener{
            Intent(this, IntroActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnTentangAplikasi.setOnClickListener{
            Intent(this, AboutActivity::class.java).apply {
                startActivity(this)
            }
        }

        binding.btnKeluar.setOnClickListener{
            customExitDialog()
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

    override fun onBackPressed() {
        customExitDialog()
    }

    //create exit dialog
    fun customExitDialog() {
        // creating custom dialog
        val dialog = Dialog(this@MainActivity)

        // setting content view to dialog
        dialog.setContentView(R.layout.exit_dialog)

        // getting reference of TextView
        val dialogButtonYes = dialog.findViewById(R.id.tv_ya) as TextView
        val dialogButtonNo = dialog.findViewById(R.id.tv_tidak) as TextView

        // click listener for No
        dialogButtonNo.setOnClickListener { // dismiss the dialog
            dialog.dismiss()
        }
        // click listener for Yes
        dialogButtonYes.setOnClickListener { // dismiss the dialog and exit the exit
            dialog.dismiss()
            finish()
        }

        // show the exit dialog
        dialog.show()
    }
}