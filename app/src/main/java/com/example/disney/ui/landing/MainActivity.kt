package com.example.disney.ui.landing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView.OnScrollListener
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.disney.R
import com.example.disney.databinding.ActivityMainBinding
import com.example.disney.domain.adapter.DisneyAdapter
import com.example.disney.domain.model.Character
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val landingViewModel: LandingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadCharacters()

        landingViewModel.isLoading.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.INVISIBLE
        }

        landingViewModel.listCharacters.observe(this) {
            it.onSuccess { characters ->
                binding.textViewMessage.visibility = View.INVISIBLE
                initRecyclerView(characters)
            }.onFailure { binding.textViewMessage.visibility = View.VISIBLE }
        }

        binding.recyclerViewCharacters.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (!recyclerView.canScrollVertically(1)) {
                    loadCharacters()
                }
            }
        })
    }

    private fun initRecyclerView(characters: List<Character>) {
        val adapter = DisneyAdapter(characters)
        binding.recyclerViewCharacters.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewCharacters.adapter = adapter
    }

    private fun loadCharacters() {
        landingViewModel.loadCharacters()
    }
}