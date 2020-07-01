package com.example.qrscanner

import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.google.android.material.tabs.TabLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher

class EspressoHelper {

    fun clickOnSelectedTabAtPosition(tabIndex: Int): ViewAction {
        return object : ViewAction {
            override fun getDescription(): String {
                return "TabLayout with tab at index $tabIndex"
            }

            override fun getConstraints(): Matcher<View> {
                return allOf(isDisplayed(), isAssignableFrom(TabLayout::class.java))
            }

            override fun perform(uiController: UiController?, view: View) {
                val tabLayout = view as TabLayout
                val selectedTab = tabLayout.getTabAt(tabIndex)
                selectedTab?.select()
            }
        }
    }

    fun checkTextViewSize(size: Float): Matcher<View> {
        return object : BoundedMatcher<View, View>(View::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendValue(size)
            }

            override fun matchesSafely(item: View?): Boolean {
                item?.let {
                    if (!(item is TextView))
                        return false
                }

                val textView = item as TextView
                val pixels = textView.textSize
                val expectedSize = pixels / textView.resources.displayMetrics.scaledDensity
                return expectedSize.compareTo(size) == 0
            }
        }
    }
}