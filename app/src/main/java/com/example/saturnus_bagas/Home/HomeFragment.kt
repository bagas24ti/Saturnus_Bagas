package com.example.saturnus_bagas.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saturnus_bagas.AuthActivity
import com.example.saturnus_bagas.Home.Pertemuan_5.FifthActivity
import com.example.saturnus_bagas.Home.pertemuan_4.FourthActivity
import com.example.saturnus_bagas.Home.pertemuan_6.SixthActivity
import com.example.saturnus_bagas.R
import com.example.saturnus_bagas.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            title = "Home"
        }

        //Kode ini harus selalu dipanggil saat butuh akses "user_pref"
        val sharedPref =  requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)

        binding.btnMasuk.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
            requireActivity().finish()
            Toast.makeText(requireContext(), "Berhasil berpindah ke FourthActivity", Toast.LENGTH_SHORT).show()
        }
        binding.btnMasukP5.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
            Toast.makeText(requireContext(), "Berhasil berpindah ke FifthActivity", Toast.LENGTH_SHORT).show()
        }
        binding.btnMasukP6.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
            Toast.makeText(requireContext(), "Berhasil berpindah ke SixthhActivity", Toast.LENGTH_SHORT).show()
        }

        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // clear
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()

                    val intent = Intent(requireContext(), AuthActivity::class.java)
                    startActivity(intent)
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}