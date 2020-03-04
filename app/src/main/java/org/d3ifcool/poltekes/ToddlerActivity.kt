package org.d3ifcool.poltekes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ToddlerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toddler)

        val actionBar = supportActionBar
        actionBar!!.title = "Berat Badan Ideal Balita 0 - 12 Bulan"

        val btnCalculateToddler : Button = findViewById(R.id.btn_calculate_toddler)
        btnCalculateToddler.setOnClickListener { calculateToddler() }
    }

    private fun calculateToddler(){
        val edToddler : EditText = findViewById(R.id.ed_toddler)
        val tvScore : TextView = findViewById(R.id.tv_score)
        if (edToddler.text.isEmpty()){
            Toast.makeText(applicationContext,"Umur Tidak Boleh Kosong",Toast.LENGTH_SHORT).show()
        } else if (edToddler.text.toString().toInt() > 10){
            Toast.makeText(applicationContext,"Umur Melebihi Batas Balita",Toast.LENGTH_SHORT).show()
        } else if (edToddler.text.toString().toInt() == 0) {
            Toast.makeText(applicationContext,"Umur Tidak Boleh 0",Toast.LENGTH_SHORT).show()
        } else {
            val toddler : Double = edToddler.text.toString().toDouble()/2 + 4
            tvScore.text = "Berat Badan Ideal Balita Anda seharusnya $toddler kg"
            tvScore.setTextColor(Color.parseColor("#00ff00"))
        }
    }
}
