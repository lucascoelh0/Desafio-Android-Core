package com.example.desafioandroidcore.ui.credentials

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desafioandroidcore.R
import com.example.desafioandroidcore.ui.mainmenu.MainActivity
import kotlinx.android.synthetic.main.activity_credentials.*
import kotlinx.android.synthetic.main.fragment_register.view.*
import kotlinx.android.synthetic.main.toolbar.*

class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_register, container, false)

        view.btnRegister.setOnClickListener {
            startActivity(Intent(context, MainActivity::class.java))
        }

        return view
    }

}