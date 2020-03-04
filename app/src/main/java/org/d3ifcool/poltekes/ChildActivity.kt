package org.d3ifcool.poltekes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class ChildActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_child)

        val actionBar = supportActionBar
        actionBar!!.title = "Berat Badan Ideal Anak 1 - 10 Tahun"

        val btnCalculateChild : Button = findViewById(R.id.btn_calculate_child)
        btnCalculateChild.setOnClickListener { calculateChild() }
    }

    private fun calculateChild(){

        val edYear : EditText = findViewById(R.id.ed_year)
        val edMonth : EditText = findViewById(R.id.ed_month)
        val tvScore : TextView = findViewById(R.id.tv_score)

        if (edYear.text.isEmpty()){
            Toast.makeText(applicationContext,"Tahun harus diisi",Toast.LENGTH_SHORT).show()
        } else if (edMonth.text.isEmpty()){
            Toast.makeText(applicationContext,"Bulan harus diisi",Toast.LENGTH_SHORT).show()
        } else if (edYear.text.toString().toInt()>10){
            Toast.makeText(applicationContext,"Tahun melebihi batas anak",Toast.LENGTH_SHORT).show()
        } else if (edYear.text.toString().toInt()==10 && edMonth.text.toString().toInt()!=0){
            Toast.makeText(applicationContext,"Tahun melebihi batas anak",Toast.LENGTH_SHORT).show()
        } else if (edYear.text.toString().toInt() == 0 || edMonth.text.toString().toInt() == 0) {
            Toast.makeText(applicationContext,"Tahun atau Bulan Tidak Boleh 0",Toast.LENGTH_SHORT).show()
        } else if (edMonth.text.toString().toInt() > 12) {
            Toast.makeText(applicationContext,"Bulan tidak ada",Toast.LENGTH_SHORT).show()
        } else {
            var year = edYear.text.toString().toDouble()*2
            var month = edMonth.text.toString().toDouble()*2
            val total: Double

            if (month == 24.0){
                year += 2
            } else if (month > 12){
                year += 1
                month -= 12
                month /= 10
                year += month
            } else {
                month = month/10
                year += month
            }

            total = year + 8
            tvScore.text = "Berat Badan Ideal Anak Seharusnya $total kg"
            tvScore.setTextColor(Color.parseColor("#00ff00"))
        }
    }
}
