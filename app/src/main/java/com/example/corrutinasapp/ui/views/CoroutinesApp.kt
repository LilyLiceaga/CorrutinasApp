package com.example.corrutinasapp.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.corrutinasapp.R
import com.example.corrutinasapp.ui.theme.CorrutinasAppTheme
import com.example.corrutinasapp.viewmodel.MainViewModel

@Composable
fun CoroutinesApp(modifier: Modifier = Modifier, viewModel: MainViewModel = MainViewModel()){
    var changeColor by remember{
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            //modifier = modifier.fillMaxWidth(),
            onClick = { changeColor =! changeColor },
                colors = ButtonDefaults.buttonColors(
                    if(changeColor) Color.Blue else Color.Red
                )
            )
        {
            Text(text = stringResource(R.string.cambio_de_color))
        }
        Spacer(modifier = modifier.height(10.dp))

        Row{
            Text(text = "${viewModel.countTime} [s]")
            Spacer(modifier = modifier.width(15.dp))
            Text(text = "${viewModel.countTime2} [s]")
        }
        Text(text = viewModel.resultState)
        Spacer(modifier = modifier.height(15.dp))
        Button(
            //modifier = modifier.fillMaxWidth(),
            onClick = {
            viewModel.fetchData()
            }
        ) {
            Text(text = stringResource(R.string.realizar_consulta))
        }
        Spacer(modifier = modifier.height(20.dp))

        Button(
            //modifier = modifier.fillMaxWidth(),
            onClick = {
            viewModel.detenerContadores()
        }) {
            Text(text = stringResource(R.string.detener_contadores))
        }
    }
}

@Preview
@Composable
fun CoroutinesAppPreview(){
    CorrutinasAppTheme(darkTheme = false) {
        CoroutinesApp()
    }
}