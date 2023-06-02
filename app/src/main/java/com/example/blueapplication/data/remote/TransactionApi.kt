package com.example.blueapplication.data.remote

import com.example.blueapplication.data.model.TransactionResponse
import ir.logicbase.mockfit.Mock
import retrofit2.http.GET


interface TransactionApi {
    @Mock("data.json")
    @GET("transaction")
    suspend fun getTransactions(): List<TransactionResponse>
}