package com.example.tptwitter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.tptwitter.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    lateinit var myFragmentView : FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Je récupère la vue du fragment
        myFragmentView = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)

        // Lors du clique du boutton
        myFragmentView.btnLogin.setOnClickListener {
            onSubmitLogin()
        }

        // Inflate the layout for this fragment
        return myFragmentView.root
    }

    fun onSubmitLogin() {
        // Vider le message d'erreur
        myFragmentView.tvError.text = ""

        // Par défaut 0 erreur
        var errors : ArrayList<String> = ArrayList<String>()

        // Je verifier les champs

        // Si l'email est invalide
        val edtLogin = myFragmentView.edtLogin
        if (edtLogin.text.isNullOrEmpty() || edtLogin.text.toString().length < 4){
            errors.add("Email invalide")
        }

        // Si le de ma passe est invalide
        val edtPassword = myFragmentView.edtPassword
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
            myFragmentView.tvError.text = message
        }
        else {
            // naviguer sur le fragment twitter
            requireActivity().findNavController(R.id.myNavHost).navigate(R.id.action_loginFragment_to_twitterFragment)
        }
    }
}