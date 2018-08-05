package com.toolx.vendingmachine

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MakeSelectionStepTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMessage() {
        val makeSelectionStep = MakeSelectionStep()
        assertEquals(makeSelectionStep.message, "1. Caramel \$2.50 2. Hazelnut \$3.10 3. Organic Raw \$2.00 (1/2/3):")
    }

    @Test
    fun selectOneWithEnoughCoins() {
        val makeSelectionStep = MakeSelectionStep()
        val selectionResult = makeSelectionStep.makeSelection("1", 3f)
        assertEquals(selectionResult.message, "Here is your Caramel bar")
        assertEquals(selectionResult.change, 0.5f)
    }

    @Test
    fun selectOneWithLessCoins() {
        val makeSelectionStep = MakeSelectionStep()
        val selectionResult = makeSelectionStep.makeSelection("2", 2f)
        assertEquals(selectionResult.message, "Not enough coins.")
        assertEquals(selectionResult.change, null)
    }

    @Test
    fun makeInvalidSelection() {
        val makeSelectionStep = MakeSelectionStep()
        val selectionResult = makeSelectionStep.makeSelection("0", 2f)
        assertEquals(selectionResult.message, "Invalid selection.")
        assertEquals(selectionResult.change, null)
    }
}