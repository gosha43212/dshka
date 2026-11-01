package com.example.viewsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val EXTRA_ANSWER_IS_TRUE = "com.example.viewsapp.answer_is_true"

class PodskaskaActivity : AppCompatActivity() {

    private lateinit var answerTextView: TextView
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private var answerIsTrue = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.podskaska_main)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        answerTextView = findViewById(R.id.answer_text_view)
        yesButton = findViewById(R.id.yes_button)
        noButton = findViewById(R.id.no_button)

        yesButton.setOnClickListener {
            val answerText = if (answerIsTrue) R.string.true_button else R.string.false_button
            answerTextView.setText(answerText)
        }
        noButton.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, PodskaskaActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}