package br.mdan.businesscard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.mdan.businesscard.databinding.ActivityAddBusinesCardBinding

class AddBusinesCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinesCardBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insetListeners()
    }

    private fun insetListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirmar.setOnClickListener {
        }
    }
}