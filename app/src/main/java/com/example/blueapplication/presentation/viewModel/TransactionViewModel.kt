package com.example.blueapplication.presentation.viewModel

import androidx.compose.runtime.Recomposer
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.blueapplication.data.model.Transaction
import com.example.blueapplication.domain.GetAllTransactionsUseCase
import com.example.blueapplication.presentation.state.TransactionState
import com.example.electrobitemap.utiles.ResultWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase
) : ViewModel() {
    private val _transactions = mutableStateOf(TransactionState())
    val transaction: State<TransactionState> = _transactions

    init {
        getTransactions()
    }

    private fun getTransactions() {
        getAllTransactionsUseCase(Unit).onEach { result ->
            when (result) {
                is ResultWrapper.Error -> {
                    _transactions.value =
                        TransactionState(error = result.exception.toString() ?: "Unknown Error")
                }

                ResultWrapper.Loading -> {
                    _transactions.value = TransactionState(isLoading = true)
                }

                is ResultWrapper.Success -> {
                    _transactions.value = TransactionState(transactions = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}