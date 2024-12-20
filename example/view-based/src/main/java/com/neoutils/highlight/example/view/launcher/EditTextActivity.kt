package com.neoutils.highlight.example.view.launcher

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.neoutils.highlight.example.view.databinding.ActivityEditTextBinding
import org.intellij.lang.annotations.Language

class EditTextActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditTextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditTextBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
    }

    @SuppressLint("SetTextI18n")
    private fun setupView() {

        @Language("kotlin")
        val code = """
            fun main() {
                print("Hello, World!")
            }
        """.trimIndent()

        binding.root.setText(code)
    }
}