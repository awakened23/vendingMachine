package com.toolx.vendingmachine

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class InsertCoinStepTest {
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMessage() {
        val insertCoinStep = InsertCoinStep()
        assertEquals(insertCoinStep.message, "Insert a coin (10c, 20c, 50c, \$1, \$2):")
    }

    @Test
    fun add10c() {
        val insertCoinStep = InsertCoinStep()
        assertEquals(insertCoinStep.addCoin("10c", 0f), 0.1f)
    }

    @Test
    fun add50c() {
        val insertCoinStep = InsertCoinStep()
        assertEquals(insertCoinStep.addCoin("50c", 0f), 0.5f)
    }

    @Test
    fun addInvalidCoid() {
        val insertCoinStep = InsertCoinStep()
        assertEquals(insertCoinStep.addCoin("5c", 0f), 0f)
    }
}