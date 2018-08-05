package com.toolx.vendingmachine

fun main(args: Array<String>) {
    println("Available chocolate bars: Caramel \$2.50, Hazelnut \$3.10 , Organic Raw \$2.")
    var totalCoin : Float = 0f
    while(true){
        val insertCoinStep = InsertCoinStep()
        println(insertCoinStep.message)

        val coin = readLine()
        val newTotalCoin = insertCoinStep.addCoin(coin, totalCoin)

        if(totalCoin == newTotalCoin){
            println("Invalid coin.")
        }else{
            totalCoin = newTotalCoin
        }

        if(totalCoin>=2){
            println("Make a selection (Y/N)?")
            val answer = readLine()

            if(answer?.toLowerCase()=="y"){
                val makeSelectionStep = MakeSelectionStep()
                println(makeSelectionStep.message)
                val selection = readLine() ?: "0"

                val selectionResult = makeSelectionStep.makeSelection(selection, totalCoin)
                println(selectionResult.message)
                if(selectionResult.change != null){
                    println("Your change is $${"%.2f".format(selectionResult.change)}")
                    return
                }
            }
        }
    }
}
