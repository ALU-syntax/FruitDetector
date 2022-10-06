package com.android.fruitdetectorapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.fruitdetectorapp.databinding.ActivityCoreBinding
import com.android.fruitdetectorapp.model.FruitData
import com.android.fruitdetectorapp.util.JsonReader.Companion.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class CoreActivity : AppCompatActivity() {

    //initialize binding layout
    private lateinit var binding : ActivityCoreBinding

    //all reference for getting fruit detection
    var txtTest : Int? = null
    private var fruitData = ArrayList<FruitData>()
    private var untunt : Intent? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting detail data for every fruit from json
        val jsonFileString  = getJsonDataFromAsset(applicationContext, "data.json")
        Log.i("data", jsonFileString!!)
        val gson = Gson()
        val listPersonType = object : TypeToken<List<FruitData>>() {}.type
        fruitData = gson.fromJson(jsonFileString, listPersonType)
//        fruitData.forEachIndexed { idx, fruit -> Log.i("data", "> Item $idx:\n$fruit") }


        binding.btnProses.setOnClickListener{
            //validate what fruit that detect
            untunt = validate()
            binding.txtTestHasil.text = txtTest.toString()

            if(untunt != null){
                startActivity(untunt)
            }else{
                Toast.makeText(this, "masih kosong", Toast.LENGTH_LONG).show()
            }
        }

        binding.btnImgBack.setOnClickListener{
            finish()
        }

        binding.btnHelp.setOnClickListener{
            val context = this@CoreActivity
            val duration : Int = Toast.LENGTH_LONG

            //pop-up for btn help
            val layout : View = layoutInflater.inflate(R.layout.help_message,
                findViewById<ViewGroup>(R.id.help_message_layout))
            val textAtas : TextView = layout.findViewById(R.id.txt_fruit)
            val textBawah : TextView = layout.findViewById(R.id.txt_help)
            textAtas.text = "Fruit Detection"
            textBawah.text = "Arahkan Kepada 1 buah agar dapat di proses"

            val toast = Toast(context).apply {
                setGravity(Gravity.TOP, 0, 250)
                view = layout
                setDuration(duration)
                show()
            }
        }
    }

    //function for validate what fruit that we get
    fun validate():Intent?{
        if (txtTest == 0){
            var untunt1 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[0].nama)
                putExtra("desc", fruitData[0].deskripsi)
                putExtra("asal", fruitData[0].asal)
                putExtra("manfaat", fruitData[0].manfaat)
                putExtra("nutrisi", fruitData[0].nutrisi)
                putExtra("gambar", fruitData[0].gambar) }
            return untunt1;
        } else if (txtTest == 1){
            var untunt2 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[1].nama)
                putExtra("desc", fruitData[1].deskripsi)
                putExtra("asal", fruitData[1].asal)
                putExtra("manfaat", fruitData[1].manfaat)
                putExtra("nutrisi", fruitData[1].nutrisi)
                putExtra("gambar", fruitData[1].gambar) }
            return untunt2;
        } else if (txtTest == 2) {
            var untunt3 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[2].nama)
                putExtra("desc", fruitData[2].deskripsi)
                putExtra("asal", fruitData[2].asal)
                putExtra("manfaat", fruitData[2].manfaat)
                putExtra("nutrisi", fruitData[2].nutrisi)
                putExtra("gambar", fruitData[2].gambar) }
            return untunt3;
        } else if (txtTest == 3) {
            var untunt4 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[3].nama)
                putExtra("desc", fruitData[3].deskripsi)
                putExtra("asal", fruitData[3].asal)
                putExtra("manfaat", fruitData[3].manfaat)
                putExtra("nutrisi", fruitData[3].nutrisi)
                putExtra("gambar", fruitData[3].gambar) }
            return untunt4;
        } else if (txtTest == 4) {
            var untunt5 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[4].nama)
                putExtra("desc", fruitData[4].deskripsi)
                putExtra("asal", fruitData[4].asal)
                putExtra("manfaat", fruitData[4].manfaat)
                putExtra("nutrisi", fruitData[4].nutrisi)
                putExtra("gambar", fruitData[4].gambar) }
            return untunt5;
        } else if (txtTest == 5) {
            var untunt6 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[5].nama)
                putExtra("desc", fruitData[5].deskripsi)
                putExtra("asal", fruitData[5].asal)
                putExtra("manfaat", fruitData[5].manfaat)
                putExtra("nutrisi", fruitData[5].nutrisi)
                putExtra("gambar", fruitData[5].gambar) }
            return untunt6;
        } else if (txtTest == 6) {
            var untunt7 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[6].nama)
                putExtra("desc", fruitData[6].deskripsi)
                putExtra("asal", fruitData[6].asal)
                putExtra("manfaat", fruitData[6].manfaat)
                putExtra("nutrisi", fruitData[6].nutrisi)
                putExtra("gambar", fruitData[6].gambar) }
            return untunt7;
        } else if (txtTest == 7) {
            var untunt8 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[7].nama)
                putExtra("desc", fruitData[7].deskripsi)
                putExtra("asal", fruitData[7].asal)
                putExtra("manfaat", fruitData[7].manfaat)
                putExtra("nutrisi", fruitData[7].nutrisi)
                putExtra("gambar", fruitData[7].gambar) }
            return untunt8;
        } else if (txtTest == 8) {
            var untunt9 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[8].nama)
                putExtra("desc", fruitData[8].deskripsi)
                putExtra("asal", fruitData[8].asal)
                putExtra("manfaat", fruitData[8].manfaat)
                putExtra("nutrisi", fruitData[8].nutrisi)
                putExtra("gambar", fruitData[8].gambar) }
            return untunt9;
        } else if (txtTest == 9) {
            var untunt10 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[9].nama)
                putExtra("desc", fruitData[9].deskripsi)
                putExtra("asal", fruitData[9].asal)
                putExtra("manfaat", fruitData[9].manfaat)
                putExtra("nutrisi", fruitData[9].nutrisi)
                putExtra("gambar", fruitData[9].gambar) }
            return untunt10;
        } else if (txtTest == 10) {
            var untunt11 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[10].nama)
                putExtra("desc", fruitData[10].deskripsi)
                putExtra("asal", fruitData[10].asal)
                putExtra("manfaat", fruitData[10].manfaat)
                putExtra("nutrisi", fruitData[10].nutrisi)
                putExtra("gambar", fruitData[10].gambar) }
            return untunt11;
        } else if (txtTest == 11) {
            var untunt12 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[11].nama)
                putExtra("desc", fruitData[11].deskripsi)
                putExtra("asal", fruitData[11].asal)
                putExtra("manfaat", fruitData[11].manfaat)
                putExtra("nutrisi", fruitData[11].nutrisi)
                putExtra("gambar", fruitData[11].gambar) }
            return untunt12;
        } else if (txtTest == 12) {
            var untunt13 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[12].nama)
                putExtra("desc", fruitData[12].deskripsi)
                putExtra("asal", fruitData[12].asal)
                putExtra("manfaat", fruitData[12].manfaat)
                putExtra("nutrisi", fruitData[12].nutrisi)
                putExtra("gambar", fruitData[12].gambar) }
            return untunt13;
        } else if (txtTest == 13) {
            var untunt14 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[13].nama)
                putExtra("desc", fruitData[13].deskripsi)
                putExtra("asal", fruitData[13].asal)
                putExtra("manfaat", fruitData[13].manfaat)
                putExtra("nutrisi", fruitData[13].nutrisi)
                putExtra("gambar", fruitData[13].gambar) }
            return untunt14;
        } else if (txtTest == 14) {
            var untunt15 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[14].nama)
                putExtra("desc", fruitData[14].deskripsi)
                putExtra("asal", fruitData[14].asal)
                putExtra("manfaat", fruitData[14].manfaat)
                putExtra("nutrisi", fruitData[14].nutrisi)
                putExtra("gambar", fruitData[14].gambar) }
            return untunt15;
        } else if (txtTest == 15) {
            var untunt16 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[15].nama)
                putExtra("desc", fruitData[15].deskripsi)
                putExtra("asal", fruitData[15].asal)
                putExtra("manfaat", fruitData[15].manfaat)
                putExtra("nutrisi", fruitData[15].nutrisi)
                putExtra("gambar", fruitData[15].gambar) }
            return untunt16
        } else if (txtTest == 16) {
            var untunt17 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[16].nama)
                putExtra("desc", fruitData[16].deskripsi)
                putExtra("asal", fruitData[16].asal)
                putExtra("manfaat", fruitData[16].manfaat)
                putExtra("nutrisi", fruitData[16].nutrisi)
                putExtra("gambar", fruitData[16].gambar) }
            return untunt17
        } else if (txtTest == 17) {
            var untunt18 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[17].nama)
                putExtra("desc", fruitData[17].deskripsi)
                putExtra("asal", fruitData[17].asal)
                putExtra("manfaat", fruitData[17].manfaat)
                putExtra("nutrisi", fruitData[17].nutrisi)
                putExtra("gambar", fruitData[17].gambar) }
            return untunt18
        } else if (txtTest == 18) {
            var untunt19 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[18].nama)
                putExtra("desc", fruitData[18].deskripsi)
                putExtra("asal", fruitData[18].asal)
                putExtra("manfaat", fruitData[18].manfaat)
                putExtra("nutrisi", fruitData[18].nutrisi)
                putExtra("gambar", fruitData[18].gambar) }
            return untunt19
        } else if (txtTest == 19) {
            var untunt20 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[19].nama)
                putExtra("desc", fruitData[19].deskripsi)
                putExtra("asal", fruitData[19].asal)
                putExtra("manfaat", fruitData[19].manfaat)
                putExtra("nutrisi", fruitData[19].nutrisi)
                putExtra("gambar", fruitData[19].gambar) }
            return untunt20
        } else if (txtTest == 20) {
            var untunt21 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[20].nama)
                putExtra("desc", fruitData[20].deskripsi)
                putExtra("asal", fruitData[20].asal)
                putExtra("manfaat", fruitData[20].manfaat)
                putExtra("nutrisi", fruitData[20].nutrisi)
                putExtra("gambar", fruitData[20].gambar) }
            return untunt21
        } else if (txtTest == 21) {
            var untunt22 = Intent(this@CoreActivity, ResultActivity::class.java).apply {
                putExtra("nama", fruitData[21].nama)
                putExtra("desc", fruitData[21].deskripsi)
                putExtra("asal", fruitData[21].asal)
                putExtra("manfaat", fruitData[21].manfaat)
                putExtra("nutrisi", fruitData[21].nutrisi)
                putExtra("gambar", fruitData[21].gambar) }
            return untunt22
        }
        return untunt
    }

    //function for disable button if fruit not yet detected
    fun disableButton(){
        binding.btnProses.isEnabled = false
    }

    //fiunction for enable button if fruit detected
    fun enabledButton(){
        binding.btnProses.isEnabled = true
    }

    //function set text for helper id
    fun setTextTest(result : Int){
        txtTest = result
    }

}