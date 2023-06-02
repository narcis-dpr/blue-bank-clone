package com.example.blueapplication.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TransactionResponse(
    @SerializedName("transactionType")
    @Expose
    val transactionType: Int,
    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("amount")
    @Expose
    val amount: String
)
