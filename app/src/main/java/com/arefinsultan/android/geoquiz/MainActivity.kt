package com.arefinsultan.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))



    private var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.w("MainActivity", "from onCreate Activity method")

        println("hello from onCreate Activity method: ");
        println("R.layout.activity_main: ");
        println(R.layout.activity_main);
        // System.out.println("Hello, World!")
//        setTitle(R.string.app_name)
        setContentView(R.layout.activity_main)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)



        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)



        trueButton.setOnClickListener{view: View ->
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT).show()



        }

        falseButton.setOnClickListener{view: View ->
            val myToast = Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT)

            checkAnswer(true)

//            val myToast = Toast.makeText(applicationContext,"toast message with gravity",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.TOP,0,200)
            myToast.show()

//            Toast.makeText(
//                this,
//                R.string.incorrect_toast,
//                Toast.LENGTH_SHORT).setGravity(10,10,10)

        }

        nextButton.setOnClickListener { currentIndex = (currentIndex + 1) % questionBank.size

            updateQuestion()
//            val questionTextResId = questionBank[currentIndex].textResId
//            questionTextView.setText(questionTextResId)

        }

        updateQuestion()
//        val questionTextResId = questionBank[currentIndex].textResId
//        questionTextView.setText(questionTextResId)
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
    }



}
