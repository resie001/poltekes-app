package org.d3ifcool.poltekes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat

class BodyMassIndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body_mass_index)

        val btnCalculateBMI: Button = findViewById(R.id.btn_hitung_bmi)
        btnCalculateBMI.setOnClickListener { calcuteBMI() }
        val actionBar = supportActionBar
        actionBar!!.title = "Body Mass Index"
    }

    private fun calcuteBMI(){
        val edTinggiBadan : EditText = findViewById(R.id.ed_tinggi_badan)
        val edBeratBadan : EditText = findViewById(R.id.ed_berat_badan)
        val tvScore : TextView = findViewById(R.id.tv_hasil)

        if (edTinggiBadan.text.isEmpty()){
            Toast.makeText(applicationContext, "Kolom Tinggi Badan tidak boleh kosong",Toast.LENGTH_SHORT).show()
        } else if (edBeratBadan.text.isEmpty()){
            Toast.makeText(applicationContext, "Kolom Berat Badan tidak boleh kosong",Toast.LENGTH_SHORT).show()
        } else if (edBeratBadan.text.toString().toInt()==0 || edTinggiBadan.text.toString().toInt()==0) {
            Toast.makeText(applicationContext, "Kolom Berat Badan Atau Tinggi Badan tidak boleh 0",Toast.LENGTH_SHORT).show()
        } else {
            val beratBadan = edBeratBadan.text.toString().toDouble()
            var tinggiBadan = edTinggiBadan.text.toString().toDouble()/100
            tinggiBadan = tinggiBadan * tinggiBadan
            val dec = DecimalFormat("#.00")
            val total = beratBadan/tinggiBadan
            val total2 = dec.format(total)

            if (total < 18.0){
                tvScore.text = "Score BMI anda adalah "+total2+"\n"+getString(R.string.osteoporosis)
                tvScore.setTextColor(Color.parseColor("#ff0000"))
            } else if (total > 25){
                tvScore.text = "Score BMI anda adalah "+total2+"\n"+getString(R.string.seranganJantung)
                tvScore.setTextColor(Color.parseColor("#ff0000"))
            } else if (total > 40) {
                tvScore.text = "Score BMI anda adalah "+total2+"\n"+getString(R.string.danger)
                tvScore.setTextColor(Color.parseColor("#ff0000"))
            } else {
                tvScore.text = "Score BMI anda adalah "+total2+"\n"+"Anda memiliki Berat Badan Ideal"
                tvScore.setTextColor(Color.parseColor("#00ff00"))
            }
        }
    }
}
