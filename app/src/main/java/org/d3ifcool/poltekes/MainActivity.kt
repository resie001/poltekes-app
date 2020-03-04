package org.d3ifcool.poltekes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnBMI : Button = findViewById(R.id.btn_bmi)
        btnBMI.setOnClickListener{
            val intent = Intent(this@MainActivity,BodyMassIndexActivity::class.java )
            startActivity(intent)
        }

        val btnBrosca : Button = findViewById(R.id.btn_brosca)
        btnBrosca.setOnClickListener{
            val intent = Intent(this@MainActivity,BroscaActivity::class.java)
            startActivity(intent)
        }

        val btnPregnantWoman : Button = findViewById(R.id.btn_ibu_hamil)
        btnPregnantWoman.setOnClickListener {
            val intent = Intent(this@MainActivity,PregnantWomanActivity::class.java)
            startActivity(intent)
        }

        val btnChild : Button = findViewById(R.id.btn_anak)
        btnChild.setOnClickListener {
            val intent = Intent(this@MainActivity,ChildActivity::class.java)
            startActivity(intent)
        }

        val btnToddler : Button = findViewById(R.id.btn_balita)
        btnToddler.setOnClickListener {
            val intent = Intent(this@MainActivity,ToddlerActivity::class.java)
            startActivity(intent)
        }
    }

}
