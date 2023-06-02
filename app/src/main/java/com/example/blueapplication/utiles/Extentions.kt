package com.example.blueapplication.utiles

import com.example.blueapplication.R

fun transactionIconId(number: Int) : Int{
    return when(number) {
        1 -> {R.drawable.download}
        2 -> {R.drawable.spaces}
        3 -> {R.drawable.download}
        4 -> {R.drawable.fee}
        5 -> {R.drawable.deposit_gift}
        6 -> {R.drawable.remittance_transfer}
        7 -> {R.drawable.baseline_shopping_cart_24}
        8 -> {R.drawable.fee}
        9 -> {R.drawable.remittance_transfer}
        else -> {R.drawable.atm}
    }
}

fun transactionTitleId(number: Int): String{
    return when(number) {
        1 -> {"افزایش موجودی"}
        2 -> {"انتقال به باکس"}
        3 -> {"دریافت از کارت"}
        4 -> {"رُند"}
        5 -> {"خرید اینترنتی"}
        6 -> {"انتقال به سپرده"}
        7 -> {"خرید از فروشگاه"}
        8 -> {"کارمزد"}
        9 -> {"انتقال به کارت"}
        else -> "تراکنش نامعلوم"
    }
}