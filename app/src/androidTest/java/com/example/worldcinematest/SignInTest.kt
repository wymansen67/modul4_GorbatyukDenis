package com.example.worldcinematest

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.worldcinematest.activity.SignInActivity
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SignInTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<SignInActivity> = ActivityScenarioRule(SignInActivity::class.java)

    @Test
    fun successfulSignInWithValidCredentials() {
        onView(withId(R.id.etEmail)).perform(
            clearText(),
            typeText("valid@email.com"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            clearText(),
            typeText("123456789"),
            closeSoftKeyboard()
        )
        onView(withId(R.id.buttonSignIn)).perform(
            click()
        )
    }
}