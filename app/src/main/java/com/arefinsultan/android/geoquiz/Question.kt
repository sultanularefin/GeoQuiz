package com.arefinsultan.android.geoquiz

import androidx.annotation.StringRes

data class Question(@StringRes var textResId: Int, var answer: Boolean,var answered:Boolean)
//data class Question(@StringRes val textResId: Int, val answer: Boolean,val answered:Boolean)
//class Question {
//}