package com.example.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var countTime by mutableStateOf(0)
        private set
    var countTime2 by mutableStateOf(0)
        private set
    var oneCount by mutableStateOf(false)
        private set
    var twoCount by mutableStateOf(false)
        private set

    /*val oneCount by mutableStateOf(false)
        private set*/
    /*fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "respuesta de la Web o API"
    }*/
    fun fetchData(num: Any){
        val job = viewModelScope.launch{
            for (i in 1..5){
                delay(1000)
                countTime = i
            }
            oneCount = true
        }
        val job2 = viewModelScope.launch{
            for (i in 5..20){
                delay(6000)
                countTime2 = i
            }
            twoCount = true
        }
        if (oneCount || num == 2){
            job.cancel()
        }
        if (twoCount || num == 2){
            job2.cancel()
        }
        viewModelScope.launch{
            delay(5000)
            resultState = "Respuesta de la API o web"
        }

    }

}

