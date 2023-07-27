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
    }

}