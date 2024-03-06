package com.example.corrutinasapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    var resultState by mutableStateOf("")
        private set
    /*fun bloqueoApp(){
        Thread.sleep(5000)
        resultState = "respuesta de la Web o API"
    }*/
    fun fetchData(){
        viewModelScope.launch{
            delay(5000)
            resultState = "Respuesta de la API o web"
        }
    }
}