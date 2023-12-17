package com.example.worldcinematest

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.worldcinematest.activity.SignUpActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class SignUpTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<SignUpActivity> =
        ActivityScenarioRule(SignUpActivity::class.java)

    @Test
    fun successfulRegisterWithValidCredentials() {
        onView(withId(R.id.etName)).perform(
            clearText(),
            typeText("ValidName"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.etLastname)).perform(
            clearText(),
            typeText("ValidLastname"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.etEmail)).perform(
            clearText(),
            typeText("valid@email.com"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            clearText(),
            typeText("123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.etConfirmPassword)).perform(
            clearText(),
            typeText("123456789"),
            ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.buttonSignUp)).perform(
            click()
        )
    }
}