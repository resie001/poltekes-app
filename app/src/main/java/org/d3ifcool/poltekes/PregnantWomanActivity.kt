package org.d3ifcool.poltekes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class PregnantWomanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregnant_woman)

        val actionBar = supportActionBar
        actionBar!!.title = "Berat Badan Ideal Ibu Hamil"

        val btnCalculatePregnant : Button = findViewById(R.id.btn_calculate_pregnant)
        btnCalculatePregnant.setOnClickListener { calculatePregnant() }
    }

    private fun calculatePregnant(){
        val edTinggiBadan : EditText = findViewById(R.id.ed_tinggi_badan)
        val edKehamilan : EditText = findViewById(R.id.ed_kehamilan)
        val tvScore : TextView = findViewById(R.id.tv_score)

        if (edTinggiBadan.text.isEmpty() || edKehamilan.text.isEmpty()){
            Toast.makeText(applicationContext,"Tinggi Badan atau Umur Kehamilan Tidak Boleh Kosong",Toast.LENGTH_SHORT).show()
        } else if (edTinggiBadan.text.toString().toInt()==0 || edKehamilan.text.toString().toInt()==0){
            Toast.makeText(applicationContext,"Tinggi Badan atau Umur Kehamilan Tidak Boleh 0",Toast.LENGTH_SHORT).show()
        } else if (edKehamilan.text.toString().toInt() > 42) {
            Toast.makeText(applicationContext,"Melebihi Batas Wajar Kehamilan!!!!",Toast.LENGTH_SHORT).show()
        } else {
            var tinggiBadan = edTinggiBadan.text.toString().toDouble() - 100
            tinggiBadan = tinggiBadan - tinggiBadan*0.15
            val kehamilan = edKehamilan.text.toString().toDouble()*0.35
            tinggiBadan += kehamilan
            tvScore.setTextColor(Color.parseColor("#00ff00"))
            if (edKehamilan.text.toString().toInt() > 40){
                tvScore.text = "Berat Badan Ideal Anda seharusnya $tinggiBadan kg\nAkan tetapi segera cek kandungan Anda ke Dokter"
            } else {
                tvScore.text = "Berat Badan Ideal Anda seharusnya $tinggiBadan kg"
            }
        }
    }
}
