package com.ac.id.pei.rpl.sihp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddActivity : AppCompatActivity() {
    lateinit var btnSubmit: Button
    lateinit var btnCancel: Button
    lateinit var etNama: EditText
    lateinit var etUkuran: EditText
    lateinit var etChipset: EditText
    lateinit var etOs: EditText
    lateinit var etRam: EditText
    lateinit var etInternal: EditText
    lateinit var etKabel: EditText
    lateinit var etKadep: EditText
    lateinit var etBaterai: EditText
    lateinit var etHarga: EditText
    lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        declaration()
        myfunction()
    }
    fun declaration(){
        btnSubmit = findViewById(R.id.btn_add_submit)
        btnCancel = findViewById(R.id.btn_add_cancel)
        etHarga = findViewById(R.id.et_add_harga)
        etNama = findViewById(R.id.et_add_nama)
        etUkuran = findViewById(R.id.et_add_ukuran)
        etChipset = findViewById(R.id.et_add_chipset)
        etOs = findViewById(R.id.et_add_os)
        etRam = findViewById(R.id.et_add_ram)
        etInternal = findViewById(R.id.et_add_internal)
        etKabel = findViewById(R.id.et_add_kabel)
        etKadep = findViewById(R.id.et_add_kadep)
        etBaterai = findViewById(R.id.et_add_baterai)
        ref = FirebaseDatabase.getInstance().getReference("hp")
    }
    fun myfunction(){
        val pindah = Intent(this, MainActivity::class.java)
        val arrayKu = FirebaseDataClassAdd()
        btnSubmit.setOnClickListener {
            arrayKu.nama = etNama.text.toString()
            arrayKu.chipset = etChipset.text.toString()
            arrayKu.os = etOs.text.toString()
            arrayKu.harga = etHarga.text.toString()
            arrayKu.ukuran = etUkuran.text.toString()
            arrayKu.ram = etRam.text.toString()
            arrayKu.kabel = etKabel.text.toString()
            arrayKu.kadep = etKadep.text.toString()
            arrayKu.baterai = etBaterai.text.toString()
            arrayKu.internal = etInternal.text.toString()
            val taskPush = ref.push()
            taskPush.setValue(arrayKu)
            startActivity(pindah)
        }
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}
