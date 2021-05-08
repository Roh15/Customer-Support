package com.example.streamchatdemo.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.streamchatdemo.R
import com.example.streamchatdemo.ui.VerifyPhoneActivity


class MainActivity : AppCompatActivity() {
    private var editTextMobile: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextMobile = findViewById(R.id.editTextMobile)
        findViewById<View>(R.id.buttonContinue).setOnClickListener(View.OnClickListener {
            val editTextMobileTemp = editTextMobile
            val mobile = editTextMobileTemp?.text.toString().trim { it <= ' ' }
            if (mobile.isEmpty() || mobile.length < 10) {
                editTextMobileTemp?.error = "Enter a valid mobile"
                editTextMobileTemp?.requestFocus()
                return@OnClickListener
            }
            val intent = Intent(this@MainActivity, VerifyPhoneActivity::class.java)
            intent.putExtra("mobile", mobile)
            startActivity(intent)
        })
    }
}