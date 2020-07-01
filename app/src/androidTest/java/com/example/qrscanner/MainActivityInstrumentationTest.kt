package com.example.qrscanner

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.action.ViewActions.swipeRight
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.qrscanner.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityInstrumentationTest {

    @get: Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewPagerIsVisibleSwipeLeft(){
        onView(withId(R.id.vp_main)).check(matches(isDisplayed())).perform(swipeLeft())
    }

    @Test
    fun testTabLayoutClickOnChild(){
        onView(withId(R.id.tl_main)).check(matches(isDisplayed())).perform(EspressoHelper().clickOnSelectedTabAtPosition(1))
    }
}