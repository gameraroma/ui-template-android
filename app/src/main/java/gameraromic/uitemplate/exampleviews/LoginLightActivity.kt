package gameraromic.uitemplate.exampleviews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import gameraromic.uitemplate.R
import kotlinx.android.synthetic.main.activity_login_light.*

class LoginLightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_light)

        login_button.setOnClickListener { it ->
            loginAction()
        }

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
    }

    private fun loginAction() {
        Toast.makeText(this, "Login!", Toast.LENGTH_SHORT).show()
    }

    private fun registerAction() {
        Toast.makeText(this, "Register!", Toast.LENGTH_SHORT).show()
    }
}
