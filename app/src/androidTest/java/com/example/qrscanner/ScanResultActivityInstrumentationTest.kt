package com.example.qrscanner

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.qrscanner.scanresult.ScanResultActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ScanResultActivityInstrumentationTest {

    @get:Rule
    val rule = ActivityTestRule(ScanResultActivity::class.java)

    @Test
    fun testContainerLayoutItemsAreVisible(){
        onView(withId(R.id.tv_scan_result)).check(matches(isDisplayed())).check(matches(withText(R.string.txt_scanned_result)))
        onView(withId(R.id.tv_scan_result)).check(matches(hasTextColor(R.color.black_dark)))
        onView(withId(R.id.tv_content)).check(matches(isDisplayed())).check(matches(withText(R.string.txt_content)))
        onView(withId(R.id.tv_content)).check(matches(hasTextColor(R.color.black_lighter)))
        onView(withId(R.id.tv_content_text)).check(matches(isDisplayed())).check(matches(withText("5999545592451")))
        onView(withId(R.id.tv_content_text)).check(matches(hasTextColor(R.color.black_dark)))
        onView(withId(R.id.bt_search)).check(matches(isDisplayed())).check(matches(isClickable())).perform(click())
    }
}