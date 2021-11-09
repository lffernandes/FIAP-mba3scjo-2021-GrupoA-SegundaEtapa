package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.mba3scjo2021_grupoa_listou.Adapter.ListasAdapter
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.ApiFactory
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.ListaCompra
import br.com.fiap.mba3scjo2021_grupoa_listou.models.UserListou
import br.com.fiap.mba3scjo2021_grupoa_listou.repository.UserRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var retService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            }
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            finish()
        /*var ur :UserRepository = UserRepository()
        if (ur.login(username, password) == true) {
            val intent = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(applicationContext,"Não conseguimos efetuar seu login, tente novamente!",Toast.LENGTH_SHORT).show()
        }
*/
        }
    }
}