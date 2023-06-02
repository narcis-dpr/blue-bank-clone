package com.example.blueapplication.presentation.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BackdropScaffold

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.blueapplication.R
import com.example.blueapplication.presentation.viewModel.TransactionViewModel
import com.example.blueapplication.ui.theme.Purple40
import com.example.blueapplication.ui.theme.Purple80
import com.example.blueapplication.ui.theme.PurpleGrey40
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransactionsHomeView(viewModel: TransactionViewModel) {
    val scroll = rememberScrollState(0)
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Purple80,
            darkIcons = true 
        )
    }
        BackdropScaffold(
        modifier = Modifier.paint(painterResource(if (isSystemInDarkTheme())
                R.drawable.header_dark else R.drawable.header_light)
           )
        ,
        appBar = {
            TopBar(modifier = Modifier.fillMaxWidth())
                 },
        backLayerContent = {
            TopCard(modifier = Modifier.fillMaxWidth()) { scroll.value }
        },
    frontLayerContent = {
        TransactionList(transactionList = viewModel.transaction.value.transactions)
    }) {

    }
}