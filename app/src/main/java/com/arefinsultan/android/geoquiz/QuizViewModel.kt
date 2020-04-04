package com.arefinsultan.android.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

//class QuizViewModel {
//}


private const val TAG = "QuizViewModel"

class QuizViewModel : ViewModel() {

    init {
        Log.d(TAG, "ViewModel instance created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "ViewModel instance about to be destroyed")
    }

    private var questionBank = listOf(
        Question(R.string.question_australia,
            true,
            false),
        Question(R.string.question_oceans,
            true,
            false),
        Question(R.string.question_mideast,
            false,
            false),
        Question(R.string.question_africa,
            false,
            false),
        Question(R.string.question_americas,
            true,
            false),
        Question(R.string.question_asia,
            true,
            false
        ))



    var currentIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId



    fun moveToNext() {


        var fullcheck= 0;
        do{
            fullcheck= fullcheck+ 1;
            currentIndex = (currentIndex + 1) % questionBank.size
            Log.i(TAG, "currentIndex: $currentIndex");
            Log.i(TAG,"questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}");
            Log.i(TAG, "fullCheck: $fullcheck");
        }while ((questionBank[currentIndex].answered == true) && (fullcheck<6))

            //        currentIndex = (currentIndex + 1) % questionBank.size
    }


}