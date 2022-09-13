package com.android.fruitdetectorapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.android.fruitdetectorapp.databinding.ActivityCoreBinding

class CoreActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnImgBack.setOnClickListener{
            finish()
        }

        binding.btnHelp.setOnClickListener{
            val context = this@CoreActivity
            val duration : Int = Toast.LENGTH_LONG

            val layout : View = layoutInflater.inflate(R.layout.help_message,
                findViewById<ViewGroup>(R.id.help_message_layout))
            val textAtas : TextView = layout.findViewById(R.id.txt_fruit)
            val textBawah : TextView = layout.findViewById(R.id.txt_help)
            textAtas.text = "Fruit Detection"
            textBawah.text = "Arahkan Kepada 1 buah agar dapat di proses"


            val toast = Toast(context).apply {
                setGravity(Gravity.TOP, 0, 100)
                view = layout
                setDuration(duration)
                show()
            }
        }
    }


    override fun onBackPressed() {
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.Q) {
            // Workaround for Android Q memory leak issue in IRequestFinishCallback$Stub.
            // (https://issuetracker.google.com/issues/139738913)
            finishAfterTransition()
        } else {
            super.onBackPressed()
        }
    }
}