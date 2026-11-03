package com.example.saturnus_bagas.Message

import android.R.id.message
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.saturnus_bagas.Home.Pertemuan_5.FifthActivity
import com.example.saturnus_bagas.databinding.ItemMessageBinding
import com.google.android.material.snackbar.Snackbar

class MessageAdapter(
    context: Context,
    private val  Messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, Messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = Messages[position]

        Glide.with(context)
            .load(data.avatarUrl)
            .into(binding.avatarImg)

        binding.textSender.text = data.senderName
        binding.textMessage.text = data.messageText
        binding.usia.text = data.usia

        view.setOnClickListener {
//            val i = Intent (context, FifthActivity::class.java)
//            context.startActivity(i)
//
//            i.putExtra("nama : ", data.senderName)
//
            Snackbar.make(
                parent,
                "Pesan dari ${data.senderName}: ${data.messageText}, \n Usia: ${data.usia} ",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        return view
    }
}