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
}