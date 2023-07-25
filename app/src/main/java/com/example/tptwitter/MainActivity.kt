package com.example.tptwitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSubmitLogin(view: View) {
        // Vider le message d'erreur
        findViewById<TextView>(R.id.tvError).text = ""

        // Je verifier les champs
        var errorMessage = ""

        // Si l'email est invalide
        val edtLogin = findViewById<EditText>(R.id.edtLogin)
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4){
            errorMessage = "Email invalide"
        }

        // Si le de ma passe est invalide
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6){
            errorMessage = "Password invalide"
        }

        //  Si y'a un au moins une erreur
        if (errorMessage.isNotEmpty()){
            // Avant
            // Log.e("TpTwitterLogin", String.format("Erreur formulaire : %s", errorMessage))
            // Afficher le message d'erreur
            findViewById<TextView>(R.id.tvError).text = errorMessage
        }
    }
}