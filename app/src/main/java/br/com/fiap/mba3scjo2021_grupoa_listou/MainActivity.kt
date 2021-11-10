package br.com.fiap.mba3scjo2021_grupoa_listou

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.mba3scjo2021_grupoa_listou.Services.RetrofitService
import br.com.fiap.mba3scjo2021_grupoa_listou.models.Login
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

public class MainActivity : AppCompatActivity() {

    private lateinit var retService: RetrofitService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            //get values from input
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            val login= Login(username,password)

            when {
              validaLogin(login)[0] -> {
                    etUsername.error = "Informe o usuário"
                    etUsername.requestFocus()
                }
                validaLogin(login)[1] -> {
                    etPassword.error = "Informe a senha"
                    etPassword.requestFocus()
                }
                else -> {
                    val intent = Intent(this@MainActivity, HomeActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    finish()

                }
            }
        }


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


    fun validaLogin(login: Login): ArrayList<Boolean> {
        var result = ArrayList<Boolean>()
        result.add(login.user.isEmpty())
        result.add(login.password.isEmpty())
        return result
    }
}