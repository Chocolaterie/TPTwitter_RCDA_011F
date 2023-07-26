package com.example.tptwitter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.tptwitter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var myView : ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ca charge la vue databindé
        myView = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Lors du clique du boutton
        myView.btnLogin.setOnClickListener {
            onSubmitLogin()
        }
    }

    fun onSubmitLogin() {
        // Vider le message d'erreur
        myView.tvError.text = ""

        // Par défaut 0 erreur
        var errors : ArrayList<String> = ArrayList<String>()

        // Je verifier les champs

        // Si l'email est invalide
        val edtLogin = myView.edtLogin
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4){
            errors.add("Email invalide")
        }

        // Si le de ma passe est invalide
        val edtPassword = myView.edtPassword
        if (edtPassword.text.isNullOrEmpty() || edtPassword.text.toString().length < 6){
            errors.add("Password invalide")
        }

        //  Si y'a un au moins une erreur
        if (errors.isNotEmpty()){
            // Avant
            // Log.e("TpTwitterLogin", String.format("Erreur formulaire : %s", errorMessage))
            // Afficher le message d'erreur
            var message = ""
            for (error in errors){
                message += "\n" + error
            }
            myView.tvError.text = message
        }
    }
}