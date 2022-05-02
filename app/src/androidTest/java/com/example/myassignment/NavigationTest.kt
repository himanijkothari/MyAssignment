package com.example.myassignment

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class  NavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun app_launches() {
        composeTestRule.onNodeWithText("Sign in").assertIsDisplayed()
        composeTestRule.onNodeWithText("Movies").assertIsDisplayed()
        composeTestRule.onNodeWithText("TV Shows").assertIsDisplayed()
        composeTestRule.onNodeWithText("Actors").assertIsDisplayed()
    }
}