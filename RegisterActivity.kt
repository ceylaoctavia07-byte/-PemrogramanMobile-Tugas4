package com.example.mahasale

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var rgGender: RadioGroup
    private lateinit var rbMale: RadioButton
    private lateinit var rbFemale: RadioButton
    private lateinit var btnRegister: Button
    private lateinit var tvLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername        = findViewById(R.id.etRegUsername)
        etEmail           = findViewById(R.id.etRegEmail)
        etPassword        = findViewById(R.id.etRegPassword)
        etConfirmPassword = findViewById(R.id.etRegConfirmPassword)
        rgGender          = findViewById(R.id.rgGender)
        rbMale            = findViewById(R.id.rbMale)
        rbFemale          = findViewById(R.id.rbFemale)
        btnRegister       = findViewById(R.id.btnRegister)
        tvLogin           = findViewById(R.id.tvLogin)

        btnRegister.setOnClickListener {
            val username        = etUsername.text.toString().trim()
            val email           = etEmail.text.toString().trim()
            val password        = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()
            val genderSelected  = rgGender.checkedRadioButtonId

            when {
                username.isEmpty() -> {
                    etUsername.error = "Username wajib diisi"
                }
                email.isEmpty() -> {
                    etEmail.error = "Email wajib diisi"
                }
                !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    etEmail.error = "Format email tidak valid"
                }
                password.isEmpty() -> {
                    etPassword.error = "Password wajib diisi"
                }
                password.length < 6 -> {
                    etPassword.error = "Password minimal 6 karakter"
                }
                confirmPassword != password -> {
                    etConfirmPassword.error = "Konfirmasi password tidak cocok"
                }
                genderSelected == -1 -> {
                    Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Registrasi berhasil! Selamat datang, $username 🎉", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra("USERNAME", username)
                    startActivity(intent)
                    finish()
                }
            }
        }

        tvLogin.setOnClickListener {
            finish() // Kembali ke halaman Login
        }
    }
}
