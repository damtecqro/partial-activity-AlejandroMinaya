package com.itesm.pokedex.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itesm.pokedex.R

import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin : AppCompatActivity() {
    val prevIntent = intent;
    var username = null;
    var password = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTheme(R.style.AppTheme_NoActionBar) // When loaded, set correct theme
        super.onCreate(savedInstanceState) // Call parent method
        this.setContentView(R.layout.activity_login)

        initializeState();
        prepareLogin();
    }

    fun initializeState() {
    }

    fun prepareLogin() {
        val usernameField = loginUsernameField;
        val passwordField = loginPasswordField;
        val submit = loginButton;

        val prevProfileBundle = intent?.extras?.getBundle("profile");
        usernameField.editText?.setText(prevProfileBundle?.getString("username"))
        passwordField.editText?.setText(prevProfileBundle?.getString("password"))

        submit.setOnClickListener{
            val username : String = usernameField.editText?.text.toString()
            val password : String = passwordField.editText?.text.toString()
            if(username == "pokedex" && password == "pokedex") {
                val profileBundle = Bundle();
                profileBundle.putString("username", username)
                profileBundle.putString("password", password)

                val newIntent = Intent(this@ActivityLogin, ActivityPokemonList::class.java)
                newIntent.putExtra("profile", profileBundle);
                newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                startActivity(newIntent);
            }
            else if(username == "") {
                usernameField.isErrorEnabled = true
                usernameField.error = this.getString(R.string.field_required)
            }
            else if(password == ""){
                passwordField.isErrorEnabled = true
                passwordField.error = this.getString(R.string.field_required)
            }
            else {
                usernameField.isErrorEnabled = true
                passwordField.isErrorEnabled = true
                usernameField.error = "Incorrect username/password"
                passwordField.error = "Incorrect username/password"
            }
        }
    }
 }
