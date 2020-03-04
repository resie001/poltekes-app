package org.d3ifcool.poltekes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class BroscaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brosca)

        val actionBar = supportActionBar
        actionBar!!.title = "Brosca"

        val btnCalculateBrosca : Button = findViewById(R.id.btn_hitung_brosca)
        btnCalculateBrosca.setOnClickListener { calculateBrosca() }
    }

    private fun calculateBrosca(){
        val edTinggiBadan : EditText = findViewById(R.id.ed_tinggi_badan)
        val tvScore : TextView = findViewById(R.id.tv_hasil)
        val rbBoy : RadioButton = findViewById(R.id.rb_boy)
        val rbGirl : RadioButton = findViewById(R.id.rb_girl)

        if (edTinggiBadan.text.isEmpty()){
            Toast.makeText(applicationContext, "Kolom Tinggi Badan tidak boleh kosong", Toast.LENGTH_SHORT).show()
        } else if (edTinggiBadan.text.toString().toInt() == 0) {
            Toast.makeText(applicationContext, "Kolom Tinggi Badan tidak boleh 0", Toast.LENGTH_SHORT).show()
        } else if (!rbBoy.isChecked && !rbGirl.isChecked){
            Toast.makeText(applicationContext, "Pilih Gender Anda", Toast.LENGTH_SHORT).show()
        }else {
            var tinggiBadan = (edTinggiBadan.text.toString().toDouble() - 100)

            if (rbBoy.isChecked){
                tinggiBadan -= tinggiBadan * 0.1
            } else {
                tinggiBadan = tinggiBadan - tinggiBadan*0.15
            }

            val dec = DecimalFormat("#.00")
            tvScore.setTextColor(Color.parseColor("#00ff00"))
            tvScore.text = "Berat Badan Ideal adalah "+dec.format(tinggiBadan)+ " kg"
        }
    }
}
