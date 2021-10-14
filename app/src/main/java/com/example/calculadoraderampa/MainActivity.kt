package com.example.calculadoraderampa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.calculadoraderampa.databinding.ActivityMainBinding
import com.example.calculadoraderampa.extensions.formatarInclinacao
import com.example.calculadoraderampa.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val inclinacaoTxt by lazy {
        binding.mainInclinaresultado
    }
    private val desnivelSld by lazy {
        binding.mainDisninvelSlider
    }
    private val comprimentoSld by lazy {
        binding.mainComprimenntoSlider
    }
    lateinit var mViewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initDesnivelSlider()
        initComprimentoSlider()

        initObserver()
    }

    private fun initObserver() {
        mViewModel.inclinacao.observe(this, { inclCalculada ->
            var formatacao = inclCalculada.formatarInclinacao()
            inclinacaoTxt.text = "i: $formatacao%"
        })
    }


    private fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun initComprimentoSlider() {
        comprimentoSld.addOnChangeListener { _, value, _ ->
            mViewModel.comprimennto.postValue(value.toDouble())
            mViewModel.atualizacaoInclinacao()
        }
    }

    private fun initDesnivelSlider() {
        desnivelSld.addOnChangeListener { _, value, _ ->
            mViewModel.desnivel.postValue(value.toDouble())
            mViewModel.atualizacaoInclinacao()
        }

    }

}