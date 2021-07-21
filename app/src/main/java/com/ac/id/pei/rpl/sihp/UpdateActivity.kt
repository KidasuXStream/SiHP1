package com.ac.id.pei.rpl.sihp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UpdateActivity : AppCompatActivity() {
    lateinit var btnSubmit:Button
    lateinit var btnCancel:Button
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
    lateinit var valNama: String
    lateinit var valHarga: String
    lateinit var valUkuran: String
    lateinit var valChipset: String
    lateinit var valRam: String
    lateinit var valInternal: String
    lateinit var valKabel: String
    lateinit var valKadep: String
    lateinit var valBaterai: String
    lateinit var valOs: String
    lateinit var valUid: String
    lateinit var ref: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        getMyData()
        declaration()
        myfunction()
    }

    fun declaration(){
        btnSubmit = findViewById(R.id.btn_up_submit)
        btnCancel = findViewById(R.id.btn_up_cancel)
        etHarga = findViewById(R.id.et_up_harga)
        etNama = findViewById(R.id.et_up_nama)
        etUkuran = findViewById(R.id.et_up_ukuran)
        etChipset = findViewById(R.id.et_up_chipset)
        etOs = findViewById(R.id.et_up_os)
        etRam = findViewById(R.id.et_up_ram)
        etInternal = findViewById(R.id.et_up_internal)
        etKabel = findViewById(R.id.et_up_kabel)
        etKadep = findViewById(R.id.et_up_kadep)
        etBaterai = findViewById(R.id.et_up_baterai)
        ref = FirebaseDatabase.getInstance().getReference("hp").child(valUid)
    }


    fun getMyData(){
        val myValue = intent.extras
        if (myValue!=null){
            valNama = myValue.getString("nama").toString()
            valHarga = myValue.getString("harga").toString()
            valUkuran = myValue.getString("ukuran").toString()
            valChipset = myValue.getString("chipset").toString()
            valRam = myValue.getString("ram").toString()
            valInternal = myValue.getString("internal").toString()
            valKadep = myValue.getString("kadep").toString()
            valKabel = myValue.getString("kabel").toString()
            valBaterai = myValue.getString("baterai").toString()
            valUid = myValue.getString("uid").toString()
            valOs = myValue.getString("os").toString()
        }
    }

    fun myfunction(){
        etNama.setText(valNama)
        etHarga.setText(valHarga)
        etBaterai.setText(valBaterai)
        etChipset.setText(valChipset)
        etInternal.setText(valInternal)
        etOs.setText(valOs)
        etKabel.setText(valKabel)
        etKadep.setText(valKadep)
        etUkuran.setText(valUkuran)
        etRam.setText(valRam)
        val pindah = Intent(this, MainActivity::class.java)
        btnSubmit.setOnClickListener {
            ref.child("nama").setValue(etNama.text.toString())
            ref.child("chipset").setValue(etChipset.text.toString())
            ref.child("os").setValue(etOs.text.toString())
            ref.child("harga").setValue(etHarga.text.toString())
            ref.child("ukuran").setValue(etUkuran.text.toString())
            ref.child("ram").setValue(etRam.text.toString())
            ref.child("baterai").setValue(etBaterai.text.toString())
            ref.child("internal").setValue(etInternal.text.toString())
            ref.child("kabel").setValue(etKabel.text.toString())
            ref.child("kadep").setValue(etKadep.text.toString())
            startActivity(pindah)
        }
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}
