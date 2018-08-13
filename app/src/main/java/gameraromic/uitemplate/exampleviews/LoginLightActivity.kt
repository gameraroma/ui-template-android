package gameraromic.uitemplate.exampleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import gameraromic.uitemplate.R
import kotlinx.android.synthetic.main.activity_login_light.*
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns


class LoginLightActivity : AppCompatActivity() {
    private val emailString: String = "a@a.co"
    private val passwordString: String = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_light)

        login_button.setOnClickListener { _ ->
            loginAction()
        }

        email_edit_text_layout.hint = email_edit_text_layout.hint.toString() + ": " + emailString
        password_edit_text_layout.hint = password_edit_text_layout.hint.toString() + ": " + passwordString

        password_edit_text.setOnEditorActionListener OnEditorActionListener@{ textView, i, keyEvent ->
            if (i == EditorInfo.IME_ACTION_DONE || keyEvent?.keyCode == KeyEvent.KEYCODE_ENTER)
            {
                loginAction()
                return@OnEditorActionListener true
            }
            return@OnEditorActionListener false
        }

        registerButtonText.setOnClickListener {
            registerAction()
        }

        email_edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                email_edit_text_layout.error = null
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        password_edit_text.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                password_edit_text_layout.error = null
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

    private fun loginAction() {
        email_edit_text_layout.error = null
        password_edit_text_layout.error = null

        val emailText = email_edit_text.text.toString()
        val passwordText = password_edit_text.text.toString()

        val isValidEmail = emailText == emailString
        val isValidPassword = passwordText == passwordString

        if (emailText.isEmpty()) {
            email_edit_text_layout.error = "Email cannot be empty"
        } else if (!isEmailFormatValid(emailText)) {
            email_edit_text_layout.error = "Wrong format"
        } else if (!isValidEmail) {
            email_edit_text_layout.error = "Incorrect Email"
        }

        if (passwordText.isEmpty()) {
            password_edit_text_layout.error = "Password cannot be empty"
        } else if (!isValidPassword) {
            password_edit_text_layout.error = "Incorrect Password"
        }

        if (isValidEmail && isValidPassword) {
            Toast.makeText(this, "Login!", Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun registerAction() {
        Toast.makeText(this, "Register!", Toast.LENGTH_SHORT).show()
    }

    private fun isEmailFormatValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}
