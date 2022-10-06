package com.android.fruitdetectorapp

import android.content.Intent
import android.os.Bundle
import android.os.Environment
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.fruitdetectorapp.databinding.ActivityResultBinding
import com.bumptech.glide.Glide
import org.apache.poi.hssf.usermodel.HSSFCellStyle
import org.apache.poi.ss.usermodel.BorderStyle
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.ss.usermodel.HorizontalAlignment
import org.apache.poi.ss.usermodel.IndexedColors
import org.apache.poi.xssf.usermodel.*
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*


class ResultActivity : AppCompatActivity(), Serializable {

    //initialize binding layout
    private lateinit var binding : ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create reference from parsing intent
        val nama  = intent.getStringExtra("nama")
        val desc  = intent.getStringExtra("desc")
        val asal = intent.getStringExtra("asal")
        val manfaat = intent.getStringExtra("manfaat")
        val nutrisi = intent.getStringExtra("nutrisi")
        val gambar = intent.getStringExtra("gambar")

        //fetching all data result
        binding.txtNamaBuah.text = nama
        binding.txtDescBuah.text = desc
        binding.txtAsalBuah.text = asal
        binding.txtManfaatBuah.text = manfaat
        binding.txtNutrisiBuah.text = nutrisi

        Glide.with(this)
            .load(gambar)
            .fitCenter()
            .into(binding.ivBuah)

        //btn home logic
        binding.btnHome.setOnClickListener{
            Intent(this, MainActivity::class.java).apply{
                startActivity(this)
                finish()
            }
        }

        //btn back logic
        binding.btnBack.setOnClickListener{
            finish()
        }

        //btn next logic
        binding.btnNext.setOnClickListener{
            finish()
        }

        //floating action button logic
        binding.fabDownload.bringToFront()
        binding.fabDownload.setOnClickListener{
            createXlsx(nama.toString(), desc.toString(), asal.toString(), manfaat.toString(),
                nutrisi.toString(), gambar.toString())

            val context = this@ResultActivity
            val duration : Int = Toast.LENGTH_LONG

            val layout : View = layoutInflater.inflate(R.layout.export_notif,
                findViewById<ViewGroup>(R.id.export_notif))
            val textBerhasil : TextView = layout.findViewById(R.id.txt_berhasil)
            val ivSuccess : ImageView = layout.findViewById(R.id.iv_success)
            textBerhasil.text = "Data Berhasil di Export!"

            val toast = Toast(context).apply {
                setGravity(Gravity.CENTER, 0, 0)
                view = layout
                setDuration(duration)
                show()
            }
        }

    }

    //function export data to csv / excel
     fun createXlsx(paramNama : String, paramDesc : String, paramAsal :String, paramManfaat : String
                          ,paramNutrisi : String, paramGambar : String ){
        try{
            val strDate: String =
                SimpleDateFormat("dd-MM-yyyy HH-mm-ss", Locale.getDefault()).format(Date())
            val root = File(
                Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "FileExcel")
            if (!root.exists()) root.mkdirs()
            val path = File(root, "/$strDate.xlsx")

            var workbook = XSSFWorkbook()
            val outputStream = FileOutputStream(path)

            var headerStyle : XSSFCellStyle = workbook.createCellStyle()
            headerStyle.setAlignment(HorizontalAlignment.CENTER)
            headerStyle.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex())
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND)
            headerStyle.setBorderTop(BorderStyle.MEDIUM)
            headerStyle.setBorderBottom(BorderStyle.MEDIUM)
            headerStyle.setBorderRight(BorderStyle.MEDIUM)
            headerStyle.setBorderLeft(BorderStyle.MEDIUM)

            var font : XSSFFont = workbook.createFont()
            font.fontHeightInPoints = 12.toShort()
            font.color = IndexedColors.WHITE.getIndex()
            font.bold = true
            headerStyle.setFont(font)

            var sheet : XSSFSheet = workbook.createSheet("Data Buah")
            var row : XSSFRow = sheet.createRow(0)

            // nama, desc, asal, manfaat, nutrisi, gambar
            var cell : XSSFCell = row.createCell(0)
            cell.setCellValue("Nama Buah")
            cell.cellStyle = headerStyle

            cell = row.createCell(1)
            cell.setCellValue("Deskripsi Buah")
            cell.cellStyle = headerStyle

            cell = row.createCell(2)
            cell.setCellValue("Sejarah Buah")
            cell.cellStyle = headerStyle

            cell = row.createCell(3)
            cell.setCellValue("Manfaat Buah")
            cell.cellStyle = headerStyle

            cell = row.createCell(4)
            cell.setCellValue("Nutrisi Buah")
            cell.cellStyle = headerStyle

            cell = row.createCell(5)
            cell.setCellValue("Gambar Buah")
            cell.cellStyle = headerStyle

            row = sheet.createRow(1)

            var cellStyle : XSSFCellStyle = workbook.createCellStyle()
            cellStyle.wrapText = true
            row.rowStyle = cellStyle

            // nama, desc, asal, manfaat, nutrisi, gambar
            cell = row.createCell(0)
            cell.setCellValue(paramNama)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(0, (paramNama.length + 30) *225)

            cell = row.createCell(1)
            cell.setCellValue(paramDesc)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(1, 70*225)

            cell = row.createCell(2)
            cell.setCellValue(paramAsal)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(2, 70*225)

            cell = row.createCell(3)
            cell.setCellValue(paramManfaat)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(3, 70*225)

            cell = row.createCell(4)
            cell.setCellValue(paramNutrisi)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(4, 70*225)

            cell = row.createCell(5)
            cell.setCellValue(paramGambar)
            cell.cellStyle = cellStyle
            sheet.setColumnWidth(5, 70*225)

            workbook.write(outputStream)
            outputStream.close()
        } catch (e : IOException){
            e.printStackTrace()
        }
    }

}