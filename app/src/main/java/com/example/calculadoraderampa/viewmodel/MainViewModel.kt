package com.example.calculadoraderampa.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.calculadoraderampa.domain.Calculador
import java.lang.ArithmeticException

class MainViewModel: ViewModel() {

    val desnivel = MutableLiveData<Double>()
    val comprimennto = MutableLiveData<Double>()
    val inclinacao = MutableLiveData<Double>()
    val callculador = Calculador()

    init {
        desnivel.value = 0.00
        comprimennto.value = 0.00
        inclinacao.value = 0.00
    }

    fun atualizacaoInclinacao () {
        val dH = desnivel.value
        val dL = comprimennto.value
        inclinacao.postValue(callculador.calculaInclinacao(dH, dL))
    }



}