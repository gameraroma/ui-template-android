package gameraromic.uitemplate.exampleviews

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import gameraromic.uitemplate.R
import kotlinx.android.synthetic.main.activity_login_light.*
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class LoginLightActivity : AppCompatActivity() {
    private val emailString: String = "a@a.co"
    private val passwordString: String = "1234"

    private lateinit var loginButton: Button
    private lateinit var emailEditTextLayout: TextInputLayout
    private lateinit var passwordEditTextLayout: TextInputLayout
    private lateinit var emailEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_light)

        loginButton = login_button as Button
        emailEditTextLayout = email_edit_text_layout as TextInputLayout
        passwordEditTextLayout = password_edit_text_layout as TextInputLayout
        emailEditText = email_edit_text as TextInputEditText
        passwordEditText = password_edit_text as TextInputEditText

        loginButton.setOnClickListener { _ ->
            loginAction()
        }

        emailEditTextLayout.hint = emailEditTextLayout.hint.toString() + ": " + emailString
        passwordEditTextLayout.hint = passwordEditTextLayout.hint.toString() + ": " + passwordString

        passwordEditText.setOnEditorActionListener OnEditorActionListener@{ textView, i, keyEvent ->
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

        emailEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                emailEditTextLayout.error = null
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        passwordEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                passwordEditTextLayout.error = null
            }

            override fun afterTextChanged(s: Editable) {
            }
        })
    }

    private fun loginAction() {
        emailEditTextLayout.error = null
        passwordEditTextLayout.error = null

        val emailText = emailEditText.text.toString()
        val passwordText = passwordEditText.text.toString()

        val isValidEmail = emailText == emailString
        val isValidPassword = passwordText == passwordString

        if (emailText.isEmpty()) {
            emailEditTextLayout.error = "Email cannot be empty"
        } else if (!isEmailFormatValid(emailText)) {
            emailEditTextLayout.error = "Wrong format"
        } else if (!isValidEmail) {
            emailEditTextLayout.error = "Incorrect Email"
        }

        if (passwordText.isEmpty()) {
            passwordEditTextLayout.error = "Password cannot be empty"
        } else if (!isValidPassword) {
            passwordEditTextLayout.error = "Incorrect Password"
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
