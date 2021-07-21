package com.ac.id.pei.rpl.sihp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.ArrayList

class FirebaseAdapter(private val listDataku: ArrayList<FirebaseDataClassView>): RecyclerView.Adapter<FirebaseAdapter.FirebaseViewHolder>() {
    inner class FirebaseViewHolder(myView: View):RecyclerView.ViewHolder(myView) {
        var tvNama: TextView = myView.findViewById(R.id.tv_nama)
        var tvHarga: TextView = myView.findViewById(R.id.tv_harga)
        var btnEdit: ImageButton = myView.findViewById(R.id.btn_data_edit)
        var btnDel: ImageButton = myView.findViewById(R.id.btn_data_del)
        var btnLoad: ImageButton = myView.findViewById(R.id.btn_data_load)
        lateinit var ref: DatabaseReference
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirebaseViewHolder {
        val viewku: View = LayoutInflater.from(parent.context).inflate(R.layout.data_item, parent, false)
        return FirebaseViewHolder(viewku)
    }

    override fun onBindViewHolder(holder: FirebaseViewHolder, position: Int) {
        val dataku = listDataku[position]
        holder.tvNama.text = dataku.nama
        holder.tvHarga.text = dataku.harga
        holder.ref = FirebaseDatabase.getInstance().getReference("hp").child(dataku.uid)
        holder.btnEdit.setOnClickListener {
            val bundle = Bundle()
            val pindah = Intent(holder.itemView.context, UpdateActivity::class.java)
            bundle.putString("uid", dataku.uid)
            bundle.putString("nama", dataku.nama)
            bundle.putString("ukuran", dataku.ukuran)
            bundle.putString("chipset", dataku.chipset)
            bundle.putString("os", dataku.os)
            bundle.putString("ram", dataku.ram)
            bundle.putString("internal", dataku.internal)
            bundle.putString("kabel", dataku.kabel)
            bundle.putString("kadep", dataku.kadep)
            bundle.putString("baterai", dataku.baterai)
            bundle.putString("harga", dataku.harga)
            pindah.putExtras(bundle)
            holder.itemView.context.startActivity(pindah)
        }
        holder.btnDel.setOnClickListener{
            holder.ref.removeValue()
        }
        holder.btnLoad.setOnClickListener{
            val bundle = Bundle()
            val pindah = Intent(holder.itemView.context, LoadData::class.java)
            bundle.putString("uid", dataku.uid)
            bundle.putString("nama", dataku.nama)
            bundle.putString("ukuran", dataku.ukuran)
            bundle.putString("chipset", dataku.chipset)
            bundle.putString("os", dataku.os)
            bundle.putString("ram", dataku.ram)
            bundle.putString("internal", dataku.internal)
            bundle.putString("kabel", dataku.kabel)
            bundle.putString("kadep", dataku.kadep)
            bundle.putString("baterai", dataku.baterai)
            bundle.putString("harga", dataku.harga)
            pindah.putExtras(bundle)
            holder.itemView.context.startActivity(pindah)
        }
    }

    override fun getItemCount(): Int {
        return listDataku.size
    }
}