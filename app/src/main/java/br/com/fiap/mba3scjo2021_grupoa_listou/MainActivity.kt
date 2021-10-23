package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnKeyListener { v, keyCode, event ->

            when {

                //Check if it is the Enter-Key,      Check if the Enter Key was pressed down
                ((keyCode == KeyEvent.KEYCODE_ENTER) && (event.action == KeyEvent.ACTION_DOWN)) -> {


                    //perform an action here e.g. a send message button click
                    btnLogin.performClick()

                    //return true
                    return@setOnKeyListener true
                }
                else -> false
            }


        }

        //button click
        btnLogin.setOnClickListener {


            //get values from input
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            when {
                username.isEmpty() -> {
                    etUsername.error = "Informe o usuário"
                    etUsername.requestFocus()
                }
                password.isEmpty() -> {
                    etPassword.error = "Informe a senha"
                    etPassword.requestFocus()
                }
                else -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}