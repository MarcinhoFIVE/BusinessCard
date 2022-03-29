package br.mdan.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.mdan.businesscard.App
import br.mdan.businesscard.R
import br.mdan.businesscard.data.BusinessCard
import br.mdan.businesscard.data.MainViewModel
import br.mdan.businesscard.data.MainViewModelFactory
import br.mdan.businesscard.databinding.ActivityAddBusinesCardBinding
class AddBusinesCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinesCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

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
            val businessCard = BusinessCard(
                nome = binding.itNome.editText?.text.toString(),
                empresa = binding.itEmpresa.editText?.text.toString(),
                telefone = binding.itFone.editText?.text.toString(),
                email = binding.itEmail.editText?.text.toString(),
                fundoPersonalizado = binding.itCor.editText?.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sccuess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}