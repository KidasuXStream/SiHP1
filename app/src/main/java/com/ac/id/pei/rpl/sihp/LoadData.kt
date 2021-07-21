package com.ac.id.pei.rpl.sihp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class LoadData : AppCompatActivity() {
    lateinit var btnCancel:Button
    lateinit var etNama: TextView
    lateinit var etUkuran: TextView
    lateinit var etChipset: TextView
    lateinit var etOs: TextView
    lateinit var etRam: TextView
    lateinit var etInternal: TextView
    lateinit var etKabel: TextView
    lateinit var etKadep: TextView
    lateinit var etBaterai: TextView
    lateinit var etHarga: TextView
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
        setContentView(R.layout.activity_full_data)
        getMyData()
        declaration()
        myfunction()
    }

    fun declaration(){
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
        //ref = FirebaseDatabase.getInstance().getReference("hp").child(valUid)
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
        /*btnSubmit.setOnClickListener {
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
        }*/
        btnCancel.setOnClickListener {
            startActivity(pindah)
        }
    }
}