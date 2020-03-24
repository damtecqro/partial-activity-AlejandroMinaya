package com.itesm.pokedex

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_login.*

class ActivityLogin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        this.setTheme(R.style.AppTheme_NoActionBar) // When loaded, set correct theme
        super.onCreate(savedInstanceState) // Call parent method
        this.setContentView(R.layout.activity_login)
    }
}
