package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        card_lista.setOnClickListener {
            val intent = Intent(this, MinhasListas::class.java)
            startActivity(intent);
        }
    }
}