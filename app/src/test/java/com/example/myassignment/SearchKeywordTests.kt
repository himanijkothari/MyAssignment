package com.example.myassignment

import com.example.myassignment.ui.screen.isKeyWordValid
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SearchKeywordTests {
    @Test
    fun searchKeyword_validation_test(){
        assertTrue(isKeyWordValid("Test123#4"))
    }
}