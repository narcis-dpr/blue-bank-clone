package com.example.blueapplication.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blueapplication.data.model.Transaction
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.blueapplication.ui.theme.BlueApplicationTheme
import com.example.blueapplication.ui.theme.HallowBackground
import com.example.blueapplication.ui.theme.LightBackground


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TransactionList(
    modifier: Modifier = Modifier,
    transactionList: List<Transaction>,

    ) {
    Surface(modifier = modifier.fillMaxSize(),
        color =  (if (isSystemInDarkTheme()) HallowBackground else LightBackground
    )) {
        Column(modifier = Modifier.padding(start = 4.dp, top = 20.dp, end = 4.dp)) {
            Divider(modifier = Modifier.width(40.dp).height(4.dp).align(Alignment.CenterHorizontally))
            Spacer(Modifier.height(8.dp))

            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(200.dp),
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                content = {
                    itemsIndexed(transactionList) { _, transaction ->

                                TransactionItem(
                                    modifier = Modifier.fillMaxWidth(),
                                   item = transaction,
                                )

                    }
                    item(span = StaggeredGridItemSpan.FullLine) {
                        Spacer(
                            modifier = Modifier
                                .windowInsetsBottomHeight(WindowInsets.navigationBars)
                        )
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun showTansactionListPreview() {
    BlueApplicationTheme {
        val list = listOf(Transaction(transactionType = 2, date = "3.3.3.3", amount = "4.4.4.4"))
        TransactionList(
            modifier = Modifier.fillMaxSize(),
            list
        )
    }
}