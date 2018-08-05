package com.toolx.vendingmachine

class MakeSelectionStep {
    val message = "1. Caramel \$2.50 2. Hazelnut \$3.10 3. Organic Raw \$2.00 (1/2/3):"

    fun makeSelection(selection: String, totalCoin: Float) : SelectionResult{
        return when{
            selection == "1" && totalCoin>=2.5f ->
                SelectionResult("Here is your Caramel bar", totalCoin-2.5f)
            selection == "2" && totalCoin>=3.1f ->
                SelectionResult("Here is your Hazelnut bar", totalCoin-3.1f)
            selection == "3" && totalCoin>=2 ->
                SelectionResult("Here is your Organic Raw bar", totalCoin-2)
            selection.toIntOrNull() in 1..3 ->
                SelectionResult("Not enough coins.", null)
            else -> SelectionResult("Invalid selection.", null)
        }
    }
}