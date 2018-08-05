package com.toolx.vendingmachine

class InsertCoinStep{
    val message = "Insert a coin (10c, 20c, 50c, \$1, \$2):"
    fun addCoin(coin: String?, totalCoin: Float): Float {
        return when(coin){
            "10c" -> totalCoin+0.1f
            "20c" -> totalCoin+0.2f
            "50c" -> totalCoin+0.5f
            "$1" -> totalCoin+1
            "$2" -> totalCoin+2
            else -> totalCoin
        }
    }
}