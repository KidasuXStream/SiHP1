package com.ac.id.pei.rpl.sihp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private val TAG = "CreateAccountActivity"
    lateinit var et_username : EditText
    lateinit var et_password: EditText
    lateinit var btn_register: Button
    lateinit var btn_cancel: Button
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btn_register = findViewById(R.id.btn_reg_submit)
        btn_cancel = findViewById(R.id.btn_reg_cancel)
        et_username = findViewById(R.id.et_reg_usernameku)
        et_password = findViewById(R.id.et_reg_passwordku)
        firebaseAuth = FirebaseAuth.getInstance()
        btn_register.setOnClickListener {
            if (et_username.text.toString()== ""){
                Toast.makeText(
                    this, "Username kosong! Harap diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (et_password.text.toString()==""){
                Toast.makeText(
                    this, "Password kosong! Harap diisi",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                register(et_username.text.toString(), et_password.text.toString())
            }
        }
        btn_cancel.setOnClickListener {
            val pindah = Intent(this, LoginActivity::class.java)
            startActivity(pindah)
        }
    }
    fun register(usernameku: String, passwordku: String){
        val pindah = Intent(this, LoginActivity::class.java)
        firebaseAuth.createUserWithEmailAndPassword(usernameku, passwordku).addOnCompleteListener(this){ task ->
            if (task.isSuccessful){
                Log.d(TAG, "Berhasil membuat akun!")
                startActivity(pindah)
            } else {
                Log.w(TAG, "Gagal membuat akun!", task.exception)
                Toast.makeText(baseContext, "Aunthentication Failed $usernameku & $passwordku", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
