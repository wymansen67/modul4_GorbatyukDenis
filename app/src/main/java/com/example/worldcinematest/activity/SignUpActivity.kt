package com.example.worldcinematest.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.worldcinematest.R
import com.example.worldcinematest.common.AppDatabase
import com.example.worldcinematest.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var signUp: ActivitySignUpBinding
    private lateinit var shPref: SharedPreferences
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUp = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(signUp.root)

        shPref = getSharedPreferences("userWorldCinema", MODE_PRIVATE)

        signUp.apply {

            buttonHaveAccount?.setOnClickListener {
                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                finish()
            }

            buttonSignUp.setOnClickListener {

                val name: String = etName.text.toString()
                val lastname: String = etLastname.text.toString()
                val email: String = etEmail.text.toString()
                val password: String = etPassword.text.toString()
                val confirmPassword: String = etConfirmPassword.text.toString()

                if (!name.isNullOrEmpty() && !lastname.isNullOrEmpty() && !email.isNullOrEmpty() && !password.isNullOrEmpty() && !confirmPassword.isNullOrEmpty()) {
                    if (onlyLetters(name) && onlyLetters(lastname)) {
                        if (name.length in 2..20) {
                            if (lastname.length in 2..45) {
                                if (checkEmail(email)) {
                                    if (password.length in 8..20) {
                                        if (password == confirmPassword) {
                                            if (email != shPref.getString("email", "")) {
                                                db = AppDatabase.getInstance(applicationContext)
                                                db.myCollectionDao().deleteAll()
                                                shPref.edit().putString("name", name).apply()
                                                shPref.edit().putString("lastname", lastname).apply()
                                                shPref.edit().putString("email", email).apply()
                                                shPref.edit().putString("password", password).apply()
                                                shPref.edit().putBoolean("logout", false).apply()
                                                startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
                                                finish()
                                            } else {
                                                Toast.makeText(this@SignUpActivity, R.string.such_mail_is_already_registered, Toast.LENGTH_SHORT).show()
                                            }
                                        } else {
                                            Toast.makeText(this@SignUpActivity, R.string.password_mismatch, Toast.LENGTH_SHORT).show()
                                        }
                                    } else {
                                        Toast.makeText(this@SignUpActivity, R.string.check_password, Toast.LENGTH_SHORT).show()
                                    }
                                } else {
                                    Toast.makeText(this@SignUpActivity, R.string.incorrect_email, Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                Toast.makeText(this@SignUpActivity, R.string.invalid_lastname_length, Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@SignUpActivity, R.string.invalid_name_length, Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@SignUpActivity, R.string.only_contain_letters, Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@SignUpActivity, R.string.empty_field, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun onlyLetters(text: String): Boolean {
        for (i in text) {
            if (!i.isLetter()) {
                return false
            }
        }
        return true
    }

    private fun checkEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}