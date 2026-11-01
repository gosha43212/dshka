package com.example.viewsapp

import android.util.Log
import androidx.lifecycle.ViewModel
private const val TAG = "QuizViewModel"
class QuizViewModel : ViewModel() {
    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    var currentIndex = 0
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        if (currentIndex < questionBank.size - 1 ) {
            currentIndex ++
        }
    }
    fun moveToPrev() {
        if (currentIndex > 0) {
            currentIndex --
        }
    }

    val hasNext: Boolean
        get() = currentIndex < questionBank.size - 1

    val hasPrev: Boolean
        get() = currentIndex > 0
    private val result = mutableMapOf<Int, Boolean>()
    fun isAnsewered(index: Int) = result.containsKey(index)
    fun recordAnswer(index: Int, isCorrect: Boolean){
        result[index] = isCorrect
    }
    val answeredCount: Int
        get()=result.size
    val correctCount: Int
        get()= result.values.count {it}

}