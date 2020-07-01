package com.example.qrscanner

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.qrscanner.adapter.HistoryAdapter
import com.example.qrscanner.adapter.HistoryVH
import com.example.qrscanner.data.Scan
import com.example.qrscanner.history.HistoryViewModel
import com.example.qrscanner.ui.MainActivity
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentHistoryInstrumentationTest {

    @get:Rule
    val rule = ActivityTestRule(MainActivity::class.java)

    private lateinit var viewModel: HistoryViewModel

    @Before
    fun setUp() {
        viewModel = mockk<HistoryViewModel>()
    }

    @Test
    fun testClick() {
        onView(withId(R.id.tl_main)).perform(EspressoHelper().clickOnSelectedTabAtPosition(1))

        val adapter = HistoryAdapter(viewModel)
        val scanList = mutableListOf<Scan>(Scan("as-34", "5999545592451", 1591923722))
        adapter.submitList(scanList)

        rule.activity.runOnUiThread {
            rule.activity.findViewById<RecyclerView>(R.id.rv_history).adapter = adapter
        }

        onView(withId(R.id.rv_history)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_history)).perform(
            RecyclerViewActions.actionOnItemAtPosition<HistoryVH>(0, click())
        )
    }
}