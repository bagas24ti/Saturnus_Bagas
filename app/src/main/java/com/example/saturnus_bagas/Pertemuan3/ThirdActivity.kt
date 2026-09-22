package com.example.saturnus_bagas.Pertemuan3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.saturnus_bagas.pertemuan_4.FourthActivity
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.saturnus_bagas.R
import com.example.saturnus_bagas.databinding.ActivityThirdBinding
import kotlin.jvm.java

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val inputNoTujuan: EditText = findViewById(R.id.inputNoTujuan)
//        val btnKirim: Button = findViewById(R.id.btnKirim)

        binding.btnKirim.setOnClickListener {
            val angka = binding.inputNoTujuan.text
            Log.e("Klik btnSubmit", "pesan berhasil di kirim ke = $angka")
            val intent = Intent(this, FourthActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "pesan berhasil di kirim ke  $angka", Toast.LENGTH_SHORT)
                .show()
        }
        }
}