package br.mdan.businesscard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.mdan.businesscard.App
import br.mdan.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { BusinessCardAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListeners()
    }

    private fun insertListeners() {
        binding.btnAdd.setOnClickListener {
            val Intent = Intent(this@MainActivity, AddBusinesCardActivity::class.java)
            startActivity(Intent)

        }
    }

    private fun getAllBusinessCard() {
        mainViewModel.getAll().observe(this) { businessCard ->
            adapter.submitList(businessCard)
        }
    }
}